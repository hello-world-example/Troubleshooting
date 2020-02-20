---
title: ReadMe
type: docs
---





可以使用下面这个工具类来排查 Java 应用和JVM的问题。这些命令大部分是不受支持的，有可能在以后的JDK版本中被移除

- **内存监控**
  - `jstat`
- **故障排查**
  - `jcmd`: 向运行中的 JVM 发送诊断命令
  - `jinfo`: [**试验性的**]获得 JVM 配置信息
  - `jhat`:  [**试验性的**]方便析 Java 堆 的工具
  - `jmap`:  [**试验性的**]主要用于打印Java进程的 堆 信息
  - `jsadebugd`: [**试验性的**]依附到一个Java进程或核心文件，担当一个调试服务器的作用
  - `jstack`:  [**试验性的**]主要用于打印Java进程的 栈 信息
- **图形工具**
  - `jmc`
  - `jvisualvm`
  - `jconsole`



## Read More
> - 官方文档：[Java Platform, Standard Edition Tools Reference](https://docs.oracle.com/javase/8/docs/technotes/tools/unix/toc.html)
>   - [Troubleshooting](https://docs.oracle.com/javase/8/docs/technotes/tools/unix/s11-troubleshooting_tools.html)