#!/bin/bash


#compose 安装
sudo curl -L "https://github.com/docker/compose/releases/download/1.24.1/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
#将可执行权限应用于二进制文件：
sudo chmod +x /usr/local/bin/docker-compose
#创建软链：
sudo ln -s /usr/local/bin/docker-compose /usr/bin/docker-compose
#测试是否安装成功：
docker-compose --version

#运行docker-compose
docker-compose up
