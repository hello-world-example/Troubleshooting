# jstat

jstat 统计 JVM 信息，**打印 GC 信息**

## options

``` bash
-help       显示帮助信息
-options    支持的统计项
```
这里使用`-options` 输出如下：

``` bash
$ jstat -options

-class
-compiler
-gc
-gccapacity
-gccause
-gcnew
-gcnewcapacity
-gcold
-gcoldcapacity
-gcpermcapacity
-gcutil
-printcompilation
```
## options 含义

|参数|含义|
|:---:|----|
|gc|                  用于查看JVM中堆的垃圾收集情况的统计|
|gcutil     |         用于查看新生代、老生代及持代垃圾收集的情况|
|class      |         用于查看类加载情况的统计|
|compiler    |        用于查看HotSpot中即时编译器编译情况的统计|
|gccapacity  |	    用于查看新生代、老生代及持久代的存储容量情况|
|gccause	  |          用于查看垃圾收集的统计情况（这个和-gcutil选项一样），如果有发生垃圾收集，它还会显示最后一次及当前正在发生垃圾收集的原因。|
|gcnew          |     用于查看新生代垃圾收集的情况|
|gcnewcapacity	|    用于查看新生代的存储容量情况|
|gcold	  |          用于查看老生代及持久代发生GC的情况|
|gcoldcapacity	 |   用于查看老生代的容量|
|gcpermcapacity	|    用于查看持久代的容量|
|printcompilation    |HotSpot编译方法的统计|

## 参数

格式 ： `jstat -<option> [-t] [-h<lines>] <vmid> [<interval> [<count>]]`

``` bash
<interval>          每隔多长时间统计一次，单位支持 ms 和 s
<count>             统计的次数
-t                  每次会输出目标JVM启动开始到现在的时间戳
-h<lines>           没隔多少次输出一下统计表头
```

## 例子

``` bash
$ jstat -gc -t -h 4 20901 500 10

Timestamp        S0C    S1C    S0U    S1U      EC       EU        OC         OU       PC     PU    YGC     YGCT    FGC    FGCT     GCT   
         1998.6 10752.0 10752.0 8038.9  0.0   66048.0  45065.2   174592.0    627.8    21504.0 17411.2      2    0.039   1      0.029    0.069
         1999.2 10752.0 10752.0 8038.9  0.0   66048.0  45065.2   174592.0    627.8    21504.0 17411.2      2    0.039   1      0.029    0.069
         1999.6 10752.0 10752.0 8038.9  0.0   66048.0  45065.2   174592.0    627.8    21504.0 17411.2      2    0.039   1      0.029    0.069
         2000.2 10752.0 10752.0 8038.9  0.0   66048.0  45065.2   174592.0    627.8    21504.0 17411.2      2    0.039   1      0.029    0.069
Timestamp        S0C    S1C    S0U    S1U      EC       EU        OC         OU       PC     PU    YGC     YGCT    FGC    FGCT     GCT   
         2000.7 10752.0 10752.0 8038.9  0.0   66048.0  45065.2   174592.0    627.8    21504.0 17411.2      2    0.039   1      0.029    0.069
         2001.2 10752.0 10752.0 8038.9  0.0   66048.0  45065.2   174592.0    627.8    21504.0 17411.2      2    0.039   1      0.029    0.069
         2001.7 10752.0 10752.0 8038.9  0.0   66048.0  45065.2   174592.0    627.8    21504.0 17411.2      2    0.039   1      0.029    0.069
         2002.2 10752.0 10752.0 8038.9  0.0   66048.0  45065.2   174592.0    627.8    21504.0 17411.2      2    0.039   1      0.029    0.069
Timestamp        S0C    S1C    S0U    S1U      EC       EU        OC         OU       PC     PU    YGC     YGCT    FGC    FGCT     GCT   
         2002.7 10752.0 10752.0 8038.9  0.0   66048.0  45065.2   174592.0    627.8    21504.0 17411.2      2    0.039   1      0.029    0.069
         2003.2 10752.0 10752.0 8038.9  0.0   66048.0  45065.2   174592.0    627.8    21504.0 17411.2      2    0.039   1      0.029    0.069
```


如果要看懂以上每一列的含义，其涉及到 JVM 分代GC的问题，这里给出一个图供参考，应该来自《深入理解Java虚拟机》这本书。

![JVM内存分布](//pic01.kail.xyz/images/java-self-monitor-command/1.png)

以下给出简单解释：
```
堆内存 = 年轻代 + 年老代 + 永久代  
年轻代 = Eden区 + 两个Survivor区（From和To）  

S0C、S1C、S0U、S1U   Survivor 0/1区容量（Capacity）和使用量（Used）  
EC、EU：             Eden 区容量和使用量  
OC、OU：             年老代容量和使用量  
PC、PU：             永久代容量和使用量   
YGC、YGT：           年轻代GC次数和GC耗时  
FGC、FGCT：          Full GC次数和Full GC耗时  
GCT：                GC总耗时
```



## Read More

- [Java垃圾回收机制](http://www.jianshu.com/p/778dd3848196)
- [HotSpot Virtual Machine Garbage Collection Tuning Guide](http://docs.oracle.com/javase/8/docs/technotes/guides/vm/gctuning/toc.html)
- [官网文档  jstat](https://docs.oracle.com/javase/7/docs/technotes/tools/share/jstat.html#output_options)
- [**java高分局之jstat命令使用**](http://blog.csdn.net/maosijunzi/article/details/46049117)
-  [jstat命令(Java Virtual Machine Statistics Monitoring Tool)](http://blog.csdn.net/fenglibing/article/details/6411951)





