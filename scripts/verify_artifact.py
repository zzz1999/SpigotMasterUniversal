#!/usr/bin/env python3
"""Check the rebuilt distribution without running a Minecraft server."""

import argparse
import hashlib
import json
import io
import os
import re
import struct
import zipfile
import xml.etree.ElementTree as ET


def verify(jar_path=None):
    root = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
    project = ET.parse(os.path.join(root, "pom.xml")).getroot()
    version = project.findtext("{http://maven.apache.org/POM/4.0.0}version")
    if jar_path is None:
        jar_path = os.path.join(root, "target", "SpigotMasterUniversal-" + version + ".jar")
    with io.open(os.path.join(root, "scripts", "artifact-expectations.json"), encoding="utf-8") as expectations:
        expected = json.load(expectations)
    with zipfile.ZipFile(jar_path) as archive:
        names = set(archive.namelist())
        missing = sorted(set(expected["classes"]) - names)
        if missing:
            raise AssertionError("Missing original classes: " + ", ".join(missing[:30]))
        for name, digest in expected["resources"].items():
            if name == "plugin.yml":
                continue
            if name not in names:
                raise AssertionError("Missing resource: " + name)
            actual = hashlib.sha256(archive.read(name)).hexdigest()
            if actual != digest:
                raise AssertionError("Changed original resource: " + name)
        description = archive.read("plugin.yml").decode("utf-8")
        if not re.search(r"(?m)^version:\s*['\"]?" + re.escape(version) + r"['\"]?\s*$", description):
            raise AssertionError("Unexpected plugin version")
        if "NBTAPI" not in description:
            raise AssertionError("The required NBTAPI plugin dependency is not declared")
        classes = [name for name in names if name.endswith(".class")]
        for name in classes:
            data = archive.read(name)
            if data[:4] != b"\xca\xfe\xba\xbe":
                raise AssertionError("Invalid class header: " + name)
            version = struct.unpack(">H", data[6:8])[0]
            if version > 52:
                raise AssertionError("Class requires a newer JVM than Java 8: " + name + " (" + str(version) + ")")
        wrapper = archive.read("com/neteasemc/spigotmaster/versionWrapper/VersionWrapperUniversal.class")
        if b"isAir" in wrapper:
            raise AssertionError("The wrapper still links to Material.isAir")
    print("Verified {} classes, {} original classes, and {} preserved resources.".format(
        len(classes), len(expected["classes"]), len(expected["resources"])
    ))


if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument("jar", nargs="?")
    arguments = parser.parse_args()
    verify(arguments.jar)
