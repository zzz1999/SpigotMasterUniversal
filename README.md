# SpigotMasterUniversal

版本：**1.4.0-universal**。

从提供的 SpigotMaster JAR 恢复的源码工程。能确认的第三方库使用 Maven 依赖；无法确认对应构件的协议库及部分混合版本 Fastutil 保留源码并参与编译。构建不依赖原始 SpigotMaster JAR。

## 构建

需要 JDK 17 和 Maven 3.9，输出 Java 8 字节码。

```sh
mvn clean verify
python3 scripts/verify_artifact.py
```

产物：`target/SpigotMasterUniversal-1.4.0-universal.jar`。

默认使用 Spigot 1.12.2 API。使用相同源码检查 1.18.2 API：

```sh
mvn -Dspigot-api.version=1.18.2-R0.1-SNAPSHOT clean verify
```

服务端还需要安装 **NBTAPI** 插件；编译依赖固定为 `de.tr7zw:item-nbt-api-plugin:2.15.7`，不打包进本插件。

## 自动 Release

推送到 `main` 后，GitHub Actions 分别以 1.12.2、1.18.2 API 编译并运行回归测试，再检查成品 JAR 的类覆盖、资源哈希和 Java 8 字节码。全部通过才发布 Release。

Release 名称和标签读取 `pom.xml` 的版本。同版本重复推送会更新该标签及附件；新版本发布成功后删除旧 Release，保留 Git 提交历史和旧版本标签。Releases 页面只保留最新版本。

## 兼容修改与验证范围

- 保留原 JAR 已有的 `versionWrapper` Universal 实现，在此基础上移除 `Material.isAir()` 链接，兼容 1.12，并识别 `AIR`、`CAVE_AIR`、`VOID_AIR`、`LEGACY_AIR`。
- 修正原判空函数将有效物品判为空的反向条件；将 switch 表达式改为 Java 8 语法。
- 对少量新旧材质名称增加兼容解析，保留原有 1.12 专用事件分支；版本解析支持省略补丁号的 `MC: 1.18`。
- 修复反编译造成的参数名、泛型、lambda 和局部变量作用域问题。对应第三方库源码仍保留在原包名下。

编译、回归测试和成品检查不等同于服务端实测。尚需在实际 1.12／1.18 服务器完成网易客户端、PyRpc、NBT 及协议联调。原 Universal 包装器的 `setEntitySize` 和两个 `addEntity` 方法仍按原实现抛异常；旧纹理数据模型也未在本次恢复中重新设计。

## 来源与原始资料

原始文件名：`SpigotMaster-1.3.13-SNAPSHOT.jar`。其 `plugin.yml` 已标注 `1.4.0-universal`，内嵌历史 Maven 配置仍是 `1.3.13-SNAPSHOT`。

原始 JAR SHA-256：

```text
1a611c99cca297d5735bc2fed924a312aa8f5c848a13caf123cc9e640d52b188
```

反编译工具：[Vineflower 1.12.0](https://github.com/Vineflower/vineflower/releases/tag/1.12.0)。部分疑难类会在恢复记录中注明其他反编译工具。

原始 Manifest 与 Maven 元数据存于 `provenance/jar-metadata/`；其他资源和原始 LICENSE／NOTICE 保留于 `src/main/resources/`。这些第三方声明不代表对整个反编译工程重新授予统一许可证。
