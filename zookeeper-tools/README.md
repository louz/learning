## 启动本地zookeeper命令
```shell
docker run --name some-zookeeper -p 2181:2181 --restart always -d zookeeper:3.4.10
```