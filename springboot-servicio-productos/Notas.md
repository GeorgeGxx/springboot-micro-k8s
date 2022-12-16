#docker login
docker build -t servicio-productos:v1 . -f .\Dockerfile
docker images
docker tag servicio-productos:v1 georgegxx/servicio-productos:v1
docker push georgegxx/servicio-productos:v1