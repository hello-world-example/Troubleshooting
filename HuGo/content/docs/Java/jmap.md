# jmap

`jmap` 可以输出 Java 进程 内存中对象的工具，64位机上使用需要加上`-J-d64`参数。jmap 一般和 `jhat` 或者 `MAT`  配合使用，以图像的形式直观的展示当前内存是否有问题。

## 参数说明
``` bash
-dump:[live,]format=b,file=<filename>
    以hprof二进制格式转储Java堆到指定filename的文件中。
    live子选项是可选的，如果指定了live子选项，堆中只有活动的对象会被转储。
    想要浏览heap dump，你可以使用 jhat(Java堆分析工具) 或者 MAT 读取生成的文件。
    
-finalizerinfo
    打印等待终结的对象信息。
    
-heap
    打印一个堆的摘要信息，包括使用的GC算法、堆配置信息和generation wise heap usage。
    
-histo[:live]
    打印每个Java类、对象数量、内存大小(单位：字节)、完全限定的类名。
    打印的虚拟机内部的类名称将会带有一个'*'前缀。
    如果指定了live子选项，则只计算活动的对象。
    
-permstat
    打印Java堆内存的永久保存区域的类加载器的智能统计信息。
    对于每个类加载器而言，它的名称、活跃度、地址、父类加载器、它所加载的类的数量和大小都会被打印。
    此外，包含的字符串数量和大小也会被打印。
    
-F
    强制模式。如果指定的pid没有响应，请使用jmap -dump或jmap -histo选项。此模式下，不支持live子选项。
    
-h | -help
    打印帮助信息。
    
-J<flag>
    指定传递给运行jmap的JVM的参数。
```



## 例子


**jmap -histo `<pid>`**

打印每个Java类、对象数量、内存大小(单位：字节)、完全限定的类名。

``` bash
$ jmap -histo 56227

 num     #instances         #bytes  class name
----------------------------------------------
   1:         32283        4509704  <constMethodKlass>
   2:         32283        4139728  <methodKlass>
   3:           631        3899688  [I
   4:          3346        3563648  <constantPoolKlass>
   5:         11058        2885584  [B
   6:          3346        2262360  <instanceKlassKlass>
   7:          2569        1892992  <constantPoolCacheKlass>
   8:         13562        1296680  [C
   9:          3554         333488  java.lang.Class
  10:         11413         273912  java.lang.String
  11:          5401         268688  [[I
  12:          4874         257224  [S
  13:          5724         183168  java.util.concurrent.ConcurrentHashMap$HashEntry
  14:           427         178552  <methodDataKlass>
  15:          4108         164320  java.util.LinkedHashMap$Entry
  16:          1747         151976  [Ljava.util.HashMap$Entry;
...
1167:             1             16  com.sun.proxy.$Proxy27
1168:             1             16  java.util.logging.SimpleFormatter
Total        188585       28109352
```

> *B*  byte
> *C*  char
> *D*  double
> *F*  float
> *I*  int
> *J*  long
> *Z*  boolean
> *[*  数组，如[I表示int[]
> *[L+类名* 其他对象

**jmap -heap `<pid>`**

查看进程堆内存使用情况，包括使用的GC算法、堆配置参数和各代中堆内存使用情况

``` bash
$ jmap  -heap 56227
Attaching to process ID 56227, please wait...
Debugger attached successfully.
Server compiler detected.
JVM version is 24.75-b04

using thread-local object allocation.
Parallel GC with 4 thread(s)

Heap Configuration:
   MinHeapFreeRatio = 0
   MaxHeapFreeRatio = 100
   MaxHeapSize      = 805306368 (768.0MB)
   NewSize          = 1310720 (1.25MB)
   MaxNewSize       = 17592186044415 MB
   OldSize          = 5439488 (5.1875MB)
   NewRatio         = 2
   SurvivorRatio    = 8
   PermSize         = 21757952 (20.75MB)
   MaxPermSize      = 85983232 (82.0MB)
   G1HeapRegionSize = 0 (0.0MB)

Heap Usage:
PS Young Generation
Eden Space:
   capacity = 67633152 (64.5MB)
   used     = 8637816 (8.237663269042969MB)
   free     = 58995336 (56.26233673095703MB)
   12.771570959756541% used
From Space:
   capacity = 11010048 (10.5MB)
   used     = 0 (0.0MB)
   free     = 11010048 (10.5MB)
   0.0% used
To Space:
   capacity = 11010048 (10.5MB)
   used     = 0 (0.0MB)
   free     = 11010048 (10.5MB)
   0.0% used
PS Old Generation
   capacity = 71827456 (68.5MB)
   used     = 3938640 (3.7561798095703125MB)
   free     = 67888816 (64.74382019042969MB)
   5.483474174555201% used
PS Perm Generation
   capacity = 34078720 (32.5MB)
   used     = 17868280 (17.04051971435547MB)
   free     = 16210440 (15.459480285644531MB)
   52.43236835186298% used

4688 interned Strings occupying 380152 bytes.
```

其结果可和 `jstat -gc 56227` 一样，但是`jmap -heap 56227`要稍微详细一点
``` bash
$ jstat -gc 56227
 S0C    S1C    S0U    S1U      EC       EU        OC         OU       PC     PU    YGC     YGCT    FGC    FGCT     GCT   
10752.0 10752.0  0.0    0.0   66048.0   8435.4   70144.0     3846.3   33280.0 17449.5      5    0.046   4      0.193    0.239
```

**jmap -dump:format=b,file=`<dumpFileName>`  `<pid>`**

用jmap把进程内存使用情况dump到文件中
``` bash
jmap -dump:format=b,file=/tmp/123.hprof 56227 
Dumping heap to /Users/kail/Desktop/123.hprof ...
Heap dump file created
```
其与 `jcmd` dump 的结果是一样。
``` bash
jcmd 56227 GC.heap_dump /tmp/456.hprof
56227:
Heap dump file created
```
生成的文件内容是二进制，需要用 MAT 或者 jhat 工具打开进行分析。

以上是在JVM运行期 dump 出内存使用情况，如果需要在 JVM 崩溃的时候自动 dump，需要在启动的时候加上`-XX:+HeapDumpOnOutOfMemoryError`参数，加上`-XX:HeapDumpPath=<file_path>`指定保存位置




## Read More

- [jmap](https://docs.oracle.com/javase/8/docs/technotes/tools/windows/jmap.html)官方文档

- [jmap命令(Java Memory Map)](http://blog.csdn.net/fenglibing/article/details/6411953)

- [使用 Eclipse Memory Analyzer 进行堆转储文件分析](http://www.ibm.com/developerworks/cn/opensource/os-cn-ecl-ma/index.html)

- [Memory Analyzer (MAT)](http://www.eclipse.org/mat/)下载




