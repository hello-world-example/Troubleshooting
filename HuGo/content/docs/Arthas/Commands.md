# 命令列表



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

sc           Search all the classes loaded by JVM                         
sm           Search the method of classes loaded by JVM                   
classloader  Show classloader info                                       
jad          Decompile class                                             
getstatic    Show the static field of a class                             
monitor      Monitor method execution statistics, e.g. total/success/failure count, average rt, fail rate, etc.                 
stack        Display the stack trace for the specified class and method   

trace        Trace the execution time of specified method invocation.     
watch        Display the input/output parameter, return object, and thrown exception of specified method invocation
tt           Time Tunnel
ognl         Execute ognl expression.
mc           Memory compiler, compiles java files into bytecode and class files in memory.
redefine     Redefine classes. @see Instrumentation#redefineClasses(ClassDefinition...)
dump         Dump class byte array from JVM
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

| 命令        | 描述                                                         | 原理 |
| ----------- | ------------------------------------------------------------ | ---- |
| dashboard   | 线程、内存、GC、Runtime 信息；`dashboard -i1 -n1` 只执行一次 |      |
| jvm         | RunTime、ClassLoading、Compilation、操作系统<br>GC（次数、耗时、收集器）、内存（堆内存、非堆内存）<br>线程（当前活跃、守护、曾经最大、启动过的线程次数、死锁线程数）<br>文件描述符（最大可用、当前） |      |
| thread [id] | `thread -b` 查找阻塞的线程，只支持找出 synchronized 关键字阻塞住的线程；<br>`thread -n 3` 当前最忙的三个线程；<br>`thread | grep WAITING` 等待的线程 |      |
| mbean       | `mbean`所有 MBean信息<br>`mbean java.lang:type=Memory` 属性信息<br>`mbean -m java.lang:type=Memory` 元信息 |      |

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

| 命令         | 描述                                                         | 原理 |
| ------------ | ------------------------------------------------------------ | ---- |
| sc           | `sc demo.*` 模糊搜索已加载的类<br>`sc -d demo.MathGame` 类的详细信息（**来自哪个 jar**，接口、父类、注解...） <br>`sc -d -f demo.MathGame` 类的字段信息 |      |
| sm           | `sm demo.MathGame` 查看类的方法<br>`sm -d demo.MathGame` 查看每个方法的签名<br>`sm -d demo.MathGame primeFactors` 制定方法签名 |      |
| jad          | `jad demo.MathGame` 反编译指定的类<br>`jad demo.MathGame main` 反编译指的方法 |      |
| dump [class] | 把指定类 dump 到本地文件，支持通配符                         |      |
| classloader  |                                                              |      |
| ognl         |                                                              |      |
| getstatic    |                                                              |      |
| classloader  |                                                              |      |



## 热更新 Hot

| 命令     | 描述       | 原理 |
| -------- | ---------- | ---- |
|          |            |      |
| mc       | 内存编译器 |      |
| redefine |            |      |
|          |            |      |



## 监控 Debug

| 命令    | 描述 | 原理 |
| ------- | ---- | ---- |
| monitor |      |      |
| watch   |      |      |
| trace   |      |      |
| stack   |      |      |
| tt      |      |      |



## 全局开关

> https://alibaba.github.io/arthas/options.html#options

|      |      |      |
| ---- | ---- | ---- |
|      |      |      |
|      |      | ``   |
|      |      |      |
|      |      |      |
|      |      |      |
|      |      |      |
|      |      | ``   |
|      |      |      |