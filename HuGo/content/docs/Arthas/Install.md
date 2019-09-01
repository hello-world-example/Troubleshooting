

# Install



## 安装

在 Github 上找到最新的发布包：https://github.com/alibaba/arthas/releases

```bash
$ wget https://github.com/alibaba/arthas/releases/download/arthas-all-3.1.1/arthas-3.1.1-bin.zip

$ unzip arthas-3.1.1-bin.zip -d arthas
$ cd arthas

# 帮助
$ java -jar arthas-boot.jar -h
```



## 如何使用

```bash
# 进入交互页面
$ java -jar arthas-boot.jar
[INFO] arthas-boot version: 3.1.1
[INFO] Process 62498 already using port 3658
[INFO] Process 62498 already using port 8563
[INFO] Found existing java process, please choose one and hit RETURN.
* [1]: 62498 xxx Java 进程 xxx
  [2]: 54006 xxx Java 进程 xxx
  [3]: 53993 xxx Java 进程 xxx
  > 选择一个 Java 进程ID，进入交互页面
  
[INFO] arthas home: /opt/websuite/arthas
[INFO] The target process already listen port 3658, skip attach.
[INFO] arthas-client connect 127.0.0.1 3658
  ,---.  ,------. ,--------.,--.  ,--.  ,---.   ,---.                           
 /  O  \ |  .--. ''--.  .--'|  '--'  | /  O  \ '   .-'                          
|  .-.  ||  '--'.'   |  |   |  .--.  ||  .-.  |`.  `-.                          
|  | |  ||  |\  \    |  |   |  |  |  ||  | |  |.-'    |                         
`--' `--'`--' '--'   `--'   `--'  `--'`--' `--'`-----'                          
                                                                                

wiki      https://alibaba.github.io/arthas                                      
tutorials https://alibaba.github.io/arthas/arthas-tutorials                     
version   3.1.1                                                                 
pid       62498                                                                 
time      2019-09-01 18:40:40                                                   

# 在 arthas 交互页面 查看帮助
arthas> $ help
 NAME         DESCRIPTION                                                                                                                                                                  
 help         Display Arthas Help                                                                                                                                                          
 keymap       Display all the available keymap for the specified connection.                                                                                                               
 sc           Search all the classes loaded by JVM                                                                                                                                         
 sm           Search the method of classes loaded by JVM                                                                                                                                   
 classloader  Show classloader info                                                                                                                                                        
 jad          Decompile class                                                                                                                                                              
 getstatic    Show the static field of a class                                                                                                                                             
 monitor      Monitor method execution statistics, e.g. total/success/failure count, average rt, fail rate, etc.                                                                           
 stack        Display the stack trace for the specified class and method                                                                                                                   
 thread       Display thread info, thread stack                                                                                                                                            
 trace        Trace the execution time of specified method invocation.                                                                                                                     
 watch        Display the input/output parameter, return object, and thrown exception of specified method invocation                                                                       
 tt           Time Tunnel                                                                                                                                                                  
 jvm          Display the target JVM information                                                                                                                                           
 ognl         Execute ognl expression.                                                                                                                                                     
 mc           Memory compiler, compiles java files into bytecode and class files in memory.                                                                                                
 redefine     Redefine classes. @see Instrumentation#redefineClasses(ClassDefinition...)                                                                                                   
 dashboard    Overview of target jvm's thread, memory, gc, vm, tomcat info.                                                                                                                
 dump         Dump class byte array from JVM                                                                                                                                               
 options      View and change various Arthas options                                                                                                                                       
 cls          Clear the screen                                                                                                                                                             
 reset        Reset all the enhanced classes                                                                                                                                               
 version      Display Arthas version                                                                                                                                                       
 shutdown     Shutdown Arthas server and exit the console                                                                                                                                  
 session      Display current session information                                                                                                                                          
 sysprop      Display, and change the system properties.                                                                                                                                   
 sysenv       Display the system env.                                                                                                                                                      
 history      Display command history                                                                                                                                                      
 cat          Concatenate and print files                                                                                                                                                  
 pwd          Return working directory name                                                                                                                                                
 mbean        Display the mbean information                                   
```

> 如果attach不上目标进程，可以查看`~/logs/arthas/` 目录下的日志

## Web Console

> arthas-boot.jar 启动后访问： http://127.0.0.1:8563/



## 卸载

```bash
# 安装安装目录
rm -rf arthas

rm -rf ~/.arthas/
rm -rf ~/logs/arthas
```



## Read More

> 官方文档：https://alibaba.github.io/arthas/install-detail.html