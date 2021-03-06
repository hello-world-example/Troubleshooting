# jcmd

jcmd 是 JDK 7 之后推出的一个多功能工具，拥有 `jmap` 的大部分功能。



## 列出 Java 进程

直接执行 `jcmd` 即可列出java进行，效果与 `jcmd -l` 、 `jps -ml` 的效果是一样的


## 打印出 java 进行支持的命令

`jcmd 0 help` ： 打印出所有java进程支持的命令
`jcmd <pid> help` ： 打印出执行中java进程支持的命令

以下是在我的机器上执行的结果，结果打印出了 43976 Java 进程可用的命令。
``` bash
$ jcmd 43976 help
43976:
The following commands are available:
  
VM.native_memory
VM.commercial_features
ManagementAgent.stop
ManagementAgent.start_local
ManagementAgent.start
Thread.print
GC.class_histogram
GC.heap_dump
GC.run_finalization
GC.run
VM.uptime
VM.flags
VM.system_properties
VM.command_line
VM.version
help

  
For more information about a specific command use 'help <command>'.
```

**不同环境、不同进程，可用的命令可能会不太一样**



## 获取可用命令的帮助

`jcmd <pid> help command `

例如:
``` bash
$ jcmd 43976 help GC.heap_dump 

43976:
GC.heap_dump
Generate a HPROF format dump of the Java heap.
  
Impact: High: Depends on Java heap size and content. Request a full GC unless the '-all' option is specified.
  
Syntax : GC.heap_dump [options] <filename>
  
Arguments:
	filename :  Name of the dump file (STRING, no default value)
  
Options: (options must be specified using the <key> or <key>=<value> syntax)
	-all : [optional] Dump all objects, including unreachable objects (BOOLEAN, false)
```



## 使用 jcmd 支持的命令

`jcmd <pid> command `

例如:


**打印 JVM 版本**
``` bash
$ jcmd 43976 VM.version
43976:
Java HotSpot(TM) 64-Bit Server VM version 24.75-b04
JDK 7.0_75
```

**打印 JVM 参数**
``` bash
$ jcmd 43976 VM.command_line
43976:
VM Arguments:
jvm_args: -Djava.awt.headless=true -Didea.version==2016.3.3 -Xmx768m -Didea.maven.embedder.version=3.3.9 -Dfile.encoding=UTF-8 
java_command: org.jetbrains.idea.maven.server.RemoteMavenServer
Launcher Type: SUN_STANDARD
```



## 部分命令功能

| 命令 |  英文解释 |
|----:|:----|
|**GC.heap_dump**       | Generate a HPROF format dump of the Java heap.|
|**Thread.print**             | Print all threads with stacktraces.|
|||
|GC.run                   | all java.lang.System.gc().|
|GC.class_histogram       | Provide statistics about the Java heap usage.|
|GC.run_finalization      | Call java.lang.System.runFinalization().|
|||
|VM.uptime                | Print VM uptime.|
|**VM.system_properties**     | Print system properties.|
|**VM.command_line**          | Print the command line used to start this VM instance.|
|**VM.flags**                 | Print VM flag options and their current values.|
|VM.version               | Print JVM version information.|

## Read More

> - 官方文档 [jcmd](https://docs.oracle.com/javase/8/docs/technotes/tools/windows/jcmd.html)
> - [Java SE 7: Reviewing JVM Performance Command Line Tools](http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/JavaJCMD/index.html)


