#!/bin/bash

echo "=== 开始部署 MySQL 8.0 ==="

# 拉取 MySQL 8.0 镜像
echo "1. 拉取 MySQL 8.0 镜像..."
docker pull mysql:8.0

# 运行 MySQL 容器
echo "2. 启动 MySQL 容器..."
docker run -d \
  --name mysql8.0 \
  -p 3307:3306 \
  -e MYSQL_ROOT_PASSWORD=admin123! \
  mysql:8.0

# 等待容器启动
echo "3. 等待 MySQL 启动..."
sleep 10

# 检查容器状态
echo "4. 检查容器状态:"
docker ps

# 测试 MySQL 连接
echo "5. 测试 MySQL 连接..."
docker exec -i mysql8.0 mysql -uroot -padmin123! -e "SELECT version();"

echo "=== MySQL 部署完成 ==="
echo "连接信息:"
echo "主机: localhost:3307"
echo "用户: root"
echo "密码: admin123!"