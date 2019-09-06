# 命令列表

> 启动示例程序
>
> ​	wget https://alibaba.github.io/arthas/arthas-demo.jar
> ​	java -jar arthas-demo.jar

## 查看帮助

### $ help

查看支持的命令

```bash
      NAME         DESCRIPTION
Base>  help         Display Arthas Help
Base>  version      Display Arthas version
Base>  cls          Clear the screen
Base>  history      Display command history
Base>  keymap       Display all the available keymap for the specified connection.    
Base>  session      Display current session information
Base>  pwd          Return working directory name
Base>  cat          Concatenate and print files
Base>  shutdown     Shutdown Arthas server and exit the console
Base>  quit         退出
Base>  grep         管道过滤

Sys>   sysprop      Display, and change the system properties.
Sys>   sysenv       Display the system env.

jvm>   dashboard    Overview of target jvm's thread, memory, gc, vm, tomcat info.
jvm>   jvm          Display the target JVM information
jvm>   thread       Display thread info, thread stack
jvm>   mbean        Display the mbean information

Hot>   mc           Memory compiler, compiles java files o class files in memory.
Hot>   redefine     Redefine classes. @see Instrumentation#redefineClasses

Class> sc           Search all the classes loaded by JVM                         
Class> sm           Search the method of classes loaded by JVM                   
Class> jad          Decompile class
Class> dump         Dump class byte array from JVM
Class> ognl         Execute ognl expression.
Class> getstatic    Show the static field of a class
Class> classloader  Show classloader info

Debug> watch        Display the input/output parameter, return object...
Debug> trace        Trace the execution time of specified method invocation.
Debug> stack        Display the stack trace for the specified class and method   
Debug> tt           Time Tunnel
Debug> monitor      Monitor method execution statistics, e.g. total/success/failure count...

options      View and change various Arthas options
reset        Reset all the enhanced classes

```

### 查看命令帮助

```bash
$ help reset
$ reset -h
```



## 基础命令 Base

| 命令     | 描述                                                         |      |
| -------- | ------------------------------------------------------------ | ---- |
| help     | 查看帮助                                                     |      |
| version  | 版本信息                                                     |      |
| cls      | 清屏                                                         |      |
| history  | 打印命令历史                                                 |      |
| keymap   | 支持的快捷键                                                 |      |
| session  | 查看 Attach 的 Java 进程ID                                   |      |
| pwd      | 当前目录                                                     |      |
| cat      | 查看文件内容                                                 |      |
| shutdown | 关闭 Arthas 服务端，所有 Arthas 客户端全部退出，重置所有增强过的类 |      |
|          |                                                              |      |
| quit     | 退出当前 Arthas 客户端，其他 Arthas 客户端不受影响           |      |
| grep     | 管道过滤                                                     |      |



## 系统信息 Sys

| 命令    | 描述                                                         | 原理 |
| ------- | ------------------------------------------------------------ | ---- |
| sysprop | 系统属性 `System.getProperties()` ，可以 读取和设置，**支持 Tab 自动补全** |      |
| sysenv  | 环境变量 `System.getenv()` ，只可读取，**支持 Tab 自动补全** |      |



## 虚拟机 信息 JVM

| 命令                                                         | 描述                                                         | 原理 |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ---- |
| [dashboard](https://alibaba.github.io/arthas/dashboard.html) | 线程、内存、GC、Runtime 信息；`dashboard -i1 -n1` 只执行一次 |      |
| [jvm](https://alibaba.github.io/arthas/jvm.html)             | RunTime、ClassLoading、Compilation、操作系统<br>GC（次数、耗时、收集器）、内存（堆内存、非堆内存）<br>线程（当前活跃、守护、曾经最大、启动过的线程次数、死锁线程数）<br>文件描述符（最大可用、当前） |      |
| [thread [id]](https://alibaba.github.io/arthas/thread.html)  | `thread -b` 查找阻塞的线程，只支持找出 synchronized 关键字阻塞住的线程；<br>`thread -n 3` 当前最忙的三个线程；<br>`thread | grep WAITING` 等待的线程 |      |
| [mbean](https://alibaba.github.io/arthas/mbean.html)         | `mbean`所有 MBean信息<br>`mbean java.lang:type=Memory` 属性信息<br>`mbean -m java.lang:type=Memory` 元信息 |      |

> [Java 线程的 6种 状态及切换](https://blog.csdn.net/pange1991/article/details/53860651)
>
> 1. 初始(`NEW`)：新创建了一个线程对象，但还没有调用start()方法。
> 2. 运行(`RUNNABLE`)：Java线程中将就绪（ready）和运行中（running）两种状态笼统的称为“运行”。
> 线程对象创建后，其他线程(比如main线程）调用了该对象的start()方法。该状态的线程位于可运行线程池中，等待被线程调度选中，获取CPU的使用权，此时处于就绪状态（ready）。就绪状态的线程在获得CPU时间片后变为运行中状态（running）
> 3. 阻塞(`BLOCKED`)：表示线程阻塞于锁
> 4. 等待(`WAITING`)：进入该状态的线程需要等待其他线程做出一些特定动作（通知或中断）。
> 5. 超时等待(`TIMED_WAITING`)：该状态不同于WAITING，它可以在指定的时间后自行返回
> 6. 终止(`TERMINATED`)：表示该线程已经执行完毕
>

## 类信息 Class

| 命令                                                         | 描述                                                         | 原理 |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ---- |
| [sc](https://alibaba.github.io/arthas/sc.html)               | `sc demo.*` 模糊搜索已加载的类<br>`sc -d demo.MathGame` 类的详细信息（**来自哪个 jar**，接口、父类、注解...） <br>`sc -d -f demo.MathGame` 类的字段信息 |      |
| [sm](https://alibaba.github.io/arthas/sm.html)               | `sm demo.MathGame` 查看类的方法<br>`sm -d demo.MathGame` 查看每个方法的签名<br>`sm -d demo.MathGame primeFactors` 查看指定方法签名 |      |
| [jad](https://alibaba.github.io/arthas/jad.html)             | `jad demo.MathGame` 反编译指定的类<br>`jad demo.MathGame main` 反编译指的方法 |      |
| [dump [class]](https://alibaba.github.io/arthas/dump.html)   | 把指定类 dump 到本地文件，支持通配符                         |      |
| [ognl](https://alibaba.github.io/arthas/ognl.html)           | 执行ognl表达式                                               |      |
| [getstatic](https://alibaba.github.io/arthas/getstatic.html) | 查看类的静态属性 <br>`getstatic demo.MathGame random`        |      |
| [classloader](https://alibaba.github.io/arthas/classloader.html) | `classloader` |  `classloader -t`统计 classloader 信息 <br>`classloader -c 3d4eac69  -r META-INF/MANIFEST.MF` 查找资源 |      |



## 热更新 Hot

| 命令                                                       | 描述                                                    | 原理                                                         |
| ---------------------------------------------------------- | ------------------------------------------------------- | ------------------------------------------------------------ |
| [mc](https://alibaba.github.io/arthas/mc.html)             | Memory Compiler/内存编译器，编译`.java`文件生成`.class` |                                                              |
| [redefine](https://alibaba.github.io/arthas/redefine.html) | 加载外部的 `.class` 文件<br>`redefine /tmp/Test.class`  | [Instrumentation](https://docs.oracle.com/javase/8/docs/api/java/lang/instrument/Instrumentation.html) |

> - jad命令反编译，然后可以用其它编译器，比如vim来修改源码
> - mc命令来内存编译修改过的代码
> - 用redefine命令加载新的字节码
>   - 不允许新增加field/method
>   - 正在跑的函数，没有退出不能生效



## 监控 Debug

| 命令                                                     | 描述                                                         | 原理 |
| -------------------------------------------------------- | ------------------------------------------------------------ | ---- |
| [watch](https://alibaba.github.io/arthas/watch.html)     | 观察方法的 **参数**、**返回值**、**异常**<br>`watch demo.MathGame primeFactors "{params,returnObj}" -x 2` 打印参数和返回值 |      |
| [trace](https://alibaba.github.io/arthas/trace.html)     | 方法路径上的每个节点上耗时<br>`trace demo.MathGame run`<br>`trace demo.MathGame run '#cost > 10'` 耗时大于10ms的调用路径 |      |
| [stack](https://alibaba.github.io/arthas/stack.html)     | 当前方法被调用的路径br<br>`stack demo.MathGame primeFactors` |      |
| [tt](https://alibaba.github.io/arthas/tt.html)           | TimeTunnel <br>`tt -t -n3 demo.MathGame primeFactors` + `tt -i 1003` |      |
| [monitor](https://alibaba.github.io/arthas/monitor.html) | 对指定类的方法进行监控(次数、成功、失败 等)，`-c` 指定监控周期<br/>`monitor -c 5 demo.MathGame primeFactors` |      |



## 全局开关

> https://alibaba.github.io/arthas/options.html#options
