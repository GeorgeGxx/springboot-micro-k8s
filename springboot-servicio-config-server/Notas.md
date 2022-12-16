#docker login
docker build -t config-server . -f .\Dockerfile
docker images
docker tag config-server georgegxx/config-server
docker push georgegxx/config-server