# 使用案例

## 诊断 Docker 里的 Java 进程

```bash
$ docker exec -it  ${containerId} /bin/bash \
  -c "wget https://alibaba.github.io/arthas/arthas-boot.jar && java -jar arthas-boot.jar"
```

