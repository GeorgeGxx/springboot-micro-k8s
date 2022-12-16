#docker login
docker build -t config-server:v1 . -f .\Dockerfile
docker images
docker tag config-server:v1 georgegxx/config-server:v1
docker push georgegxx/config-server:v1