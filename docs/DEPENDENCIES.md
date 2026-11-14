# 依赖与源码恢复说明

本项目从指定的 SpigotMaster JAR 反编译恢复。插件版本是 `1.4.0-universal`；原文件名及内嵌 Maven 版本仍为 `1.3.13-SNAPSHOT`，原始元数据保存在 `provenance/jar-metadata/`。

## 构建方式

Maven 编译项目内全部保留的 Java 源码，再通过 Shade 合入公开依赖。构建不读取原始 SpigotMaster JAR，不复制其中的 class，不使用 `systemPath` 或本地二进制基底。编译目标为 Java 8；开发和 CI 可使用较新的 JDK。原始 JAR 中三个 Universal 类是 Java 21 字节码，这与本项目重新编译后的目标版本不同。

默认使用 Spigot API `1.12.2-R0.1-SNAPSHOT` 编译；可使用 `-Dspigot-api.version=1.18.2-R0.1-SNAPSHOT` 检查另一套 API。服务端实际运行效果仍需要分别在目标服务器验收。

## 按 class 字节核对的公开库

下表中的目标类与对应公开 JAR 完全一致，因此改为 Maven 依赖。完整坐标、仓库与 JAR SHA-256 见 `provenance/verified-dependencies.json`。

| Maven 坐标 | 与输入 JAR 相同的 class 数 |
| --- | ---: |
| `com.github.stephenc.jcip:jcip-annotations:1.0-1` | 4 |
| `com.nimbusds:nimbus-jose-jwt:9.13` | 389 |
| `io.airlift:aircompressor:0.25` | 125 |
| `org.apache.httpcomponents:httpasyncclient:4.1.4` | 86 |
| `org.apache.httpcomponents:httpclient:4.5.6` | 467 |
| `org.apache.httpcomponents:httpcore:4.4.10` | 252 |
| `org.apache.httpcomponents:httpcore-nio:4.4.10` | 240 |
| `org.bitbucket.b_c:jose4j:0.9.3` | 210 |
| `org.slf4j:slf4j-api:1.7.21` | 34 |
| `org.msgpack:msgpack-core:0.9.3` | 106 |
| `commons-codec:commons-codec:1.10` | 92 |
| `commons-logging:commons-logging:1.2` | 28 |
| `io.netty:netty-buffer:4.1.101.Final` | 138 |
| `io.netty:netty-codec:4.1.101.Final` | 214 |
| `io.netty:netty-common:4.1.101.Final` | 492 |
| `io.netty:netty-resolver:4.1.101.Final` | 29 |
| `io.netty:netty-transport:4.1.101.Final` | 373 |
| `net.jodah:expiringmap:0.5.9` | 28 |
| `org.cloudburstmc.math:immutable:2.0` | 75 |
| `org.geysermc.cumulus:cumulus:1.1.1` | 92 |
| `com.nukkitx:math:1.1.1` | 52 |
| `org.lanternpowered:lmbda:2.0.0` | 21 |
| `com.nukkitx:natives:1.0.3` | 35 |

## 混合版本 Fastutil

输入 JAR 同时包含 Fastutil `6.5.13` 与 NukkitX Fastutil `8.5.3` 模块的类，不能用其中一个版本整体替换。按核对后的依赖顺序，103 个顶层源码文件重新生成 539 个 class，10,580 个 class 由公开依赖提供。原始类族中的 24 个旧版内部类仍由 `6.5.13` 依赖保留。Maven Shade 仅对依赖排除实际重建的 539 个 class 精确路径，确保重建类不被覆盖，也不会误删这些旧版内部类。

固定的依赖顺序、源码类族与排除规则见 `provenance/fastutil-reconstruction.json`。没有把本地较新的 Fastutil 当成原版本替代。

## 编译与运行时外部 API

- Spigot API、Guava、Gson、Commons Lang、JSR-305、JetBrains 注解由服务端或构建环境提供，不合入插件。
- `de.tr7zw:item-nbt-api-plugin:2.15.7` 为已核对方法签名的候选外部 API，输入 JAR 未记录原本使用的 NBTAPI 版本。`plugin.yml` 添加了 `depend: [NBTAPI]`，要求服务端先加载 NBTAPI。
- `com.nukkitx:nbt:2.2.1` 提供旧协议源码引用的 `com.nukkitx.nbt.NbtUtils`；这是输入 JAR 自身未内嵌的旧 API。
- Netty epoll、kqueue、unix-common API 作为 `provided` 编译依赖，不合入本插件；网络传输仍由环境与库的运行时选择决定。
- Jackson/Lombok 注解只用于恢复源码编译，Lombok 注解处理器关闭。JUnit 与 Hamcrest 仅用于测试。
- 所有依赖固定版本并排除传递依赖，避免未知依赖树覆盖已核实版本。

## 保留源码与资源

网易定制协议、未能确认完整对应依赖的 Cloudburst/Nukkit 协议等类保留源码。第三方源码仅恢复编译所需的泛型、装箱、lambda 类型和局部变量作用域；对应更改见 `provenance/library-source-recovery.patch`。

输入 JAR 的 288 个非 class 资源全部记录在 `provenance/jar-resource-index.json`：135 个旧 Manifest/Maven 元数据保存至 provenance，其余 153 个运行资源与声明保存至 `src/main/resources/`。除添加 NBTAPI 加载依赖的 `plugin.yml` 外，原始资源逐字节保留。`libnukkit-natives.so` 是保留的原生库资源，本项目没有恢复其 C 源码。

原始 LICENSE/NOTICE 声明按原样保存；这些来自不同内嵌库的声明不构成对整个反编译主程序新增 MIT 授权。
