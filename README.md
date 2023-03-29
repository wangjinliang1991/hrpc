# hrpc

simple RPC framework

## dependency

- jdk
```shell
mkdir -p /usr/local/java
tar -vzxf jdk-8u241-linux-x64.tar.gz -C /usr/local/java/
cd /usr/local/java/ && mv jdk1.8.0_241/ jdk1.8
vim /etc/profile

export JAVA_HOME=/usr/local/java/jdk1.8
export CLASSPATH=$:CLASSPATH:$JAVA_HOME/lib/
export PATH=$PATH:$JAVA_HOME/bin

source /etc/profile

verify: java -version
```
- zookeeper

```shell
mkdir -p /home/aizk;
groupadd -g 2024 aizk; useradd -d /home/aizk -u 2024 -g aizk aizk;
echo 'yourPassword'| passwd --stdin aizk


```

