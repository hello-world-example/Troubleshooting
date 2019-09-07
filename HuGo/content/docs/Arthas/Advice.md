# Advice

> https://github.com/alibaba/arthas/blob/master/core/src/main/java/com/taobao/arthas/core/advisor/Advice.java

```java
public class Advice {
    /**
     * 本次调用类所在的 ClassLoader
     */
    ClassLoader loader;
    /**
     * 本次调用类的 Class 引用
     */
    Class<?> clazz;
    /**
     * 本次调用方法反射引用
     */
    ArthasMethod method;
    /**
     * ❤ 本次调用类的实例 ❤
     */
    Object target;
    /**
     * ❤ 本次调用参数列表，这是一个数组，如果方法是无参方法则为空数组 ❤
     */
    Object[] params;
    /**
     * ❤ 本次调用返回的对象，返回值 void，则值为 null ❤
     */
    Object returnObj;
    /**
     * ❤ 本次调用抛出的异常 ❤
     */
    Throwable throwExp;

    /**
     * 辅助判断标记
     */
    boolean isBefore;
    /**
     * 辅助判断标记
     */
    boolean isThrow;
    /**
     * 辅助判断标记
     */
    boolean isReturn;
}
```

> https://github.com/alibaba/arthas/blob/master/core/src/main/java/com/taobao/arthas/core/advisor/ArthasMethod.java

```java
public class ArthasMethod {
    /**
     * 方法类型
     */
    int type;
    /**
     * 构造方法
     */
    Constructor<?> constructor;
    /**
     * 普通方法
     */
    Method method;
}
```

## 内置变量

- `#cost` 单位 ms，表示耗时



## Read More

- [watch](https://alibaba.github.io/arthas/watch.html) 命令
- [表达式核心变量](https://alibaba.github.io/arthas/advice-class.html)
- Issues
  - [【Arthas问题排查集】活用ognl表达式](https://github.com/alibaba/arthas/issues/71)
  - [Arthas的一些特殊用法文档说明](https://github.com/alibaba/arthas/issues/71)
- [Apache Commons Ognl](https://hello-world-example.github.io/Apache-Commons/docs/Ognl/)

