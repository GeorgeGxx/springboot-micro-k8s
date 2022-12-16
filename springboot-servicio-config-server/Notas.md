#docker login
docker build -t config-server . -f .\Dockerfile
docker images
docker rmi -f config-server
docker tag config-server georgegxx/config-server
docker push georgegxx/config-server