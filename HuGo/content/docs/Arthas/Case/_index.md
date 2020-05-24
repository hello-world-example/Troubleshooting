# 使用案例

## 查找被加载的类

```
sc *Main
xyz.kail.demo.troubleshooting.jsonde.JsondeMain
xyz.kail.demo.troubleshooting.jsonde.JsondeMain$$EnhancerBySpringCGLIB$$95be0a45
```



## 诊断 Docker 里的 Java 进程

```bash
$ docker exec -it  ${containerId} /bin/bash \
  -c "wget https://alibaba.github.io/arthas/arthas-boot.jar && java -jar arthas-boot.jar"
```

