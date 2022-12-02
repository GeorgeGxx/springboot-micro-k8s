`Notas:`

`Empaquetar .jar`

Moverte al nivel del pom.xml

.\mvnw clean package

.\mvnw clean package -DskipTests

.\mvnw install

`Ejecutar .jar`

java -jar .\target\artifact-name-0.0.1-SNAPSHOT.jar

`Desplegar Zipkin`

java -jar zipkin-server-2.12.9-exec.jar

java -jar zipkin-server-2.12.9-exec.jar --zipkin.collector.rabbitmq.addresses=localhost:5672

java -jar zipkin-server-2.23.2-exec.jar

`Puerto`

http://localhost:9411/zipkin/

`Instalar RabbitMQ`

choco install rabbitmq

`Desplegar RabbitMQ sin chocolatey`

rabbitmq-plugins enable rabbitmq_management

`Puerto`

http://localhost:15672/

`Login`

guest

guest

`Iniciar Zipkin por script`

Ejecutar zipkin.cmd

---

`Docker hub example`

docker login

docker build -t config-server:v1 . -f .\Dockerfile

docker images

docker tag config-server:v1 user/config-server:v1

docker push user/config-server:v1

---

`Comandos Docker`

docker build -t config-server:v1 .

docker network create springcloud

docker run -p 8888:8888 --name config-server --network springcloud config-server:v1

docker build -t servicio-eureka-server:v1 .

docker run -p 8761:8761 --name servicio-eureka-server --network springcloud servicio-eureka-server:v1

docker run -p 3307:3306 --name microservicios-mysql8 --network springcloud -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=db_springboot_cloud -d mysql:8

docker run -p 5532:5432 --name microservicios-postgres14 --network springcloud -e POSTGRES_PASSWORD=root -e POSTGRES_DB=db_springboot_cloud -d postgres:14-alpine

---

docker logs -f config-server

docker exec -it config-server bash

docker image prune --all --force

---

docker build -t servicio-productos:v1 .

docker run -P --network springcloud --name servicio-productos servicio-productos:v1

`Instancia adicional de servicio-productos`

docker run -P --network springcloud --name servicio-productos2 servicio-productos:v1

---

docker build -t servicio-zuul-server:v1 .

docker run -p 8090:8090 --name servicio-zuul-server --network springcloud servicio-zuul-server:v1

docker build -t servicio-usuarios:v1 .

docker run -P --network springcloud --name servicio-usuarios servicio-usuarios:v1

docker build -t servicio-oauth:v1 .

docker run -p 9100:9100 --network springcloud --name servicio-oauth servicio-oauth:v1

docker build -t servicio-items:v1 .

docker run -p 8002:8002 -p 8005:8005 -p 8007:8007 --network springcloud --name servicio-items servicio-items:v1

docker pull rabbitmq:3.9-management-alpine

docker run -p 5672:5672 -p 15672:15672 --hostname rabbit-server --name microservicios-rabbitmq39  --network springcloud -d rabbitmq:3.9-management-alpine

docker build -t zipkin-server:v1 .

docker run -p 9411:9411 --name zipkin-server --network springcloud -e RABBIT_ADDRESSES=microservicios-rabbitmq39:5672 -e STORAGE_TYPE=mysql -e MYSQL_USER=zipkin -e MYSQL_PASS=zipkin -e MYSQL_DB=zipkin -e MYSQL_HOST=microservicios-mysql8 -e MYSQL_TCP_PORT=3306 zipkin-server:v1

docker compose up -d microservicios-mysql8

docker compose down 

`Como administrador para Containers`

docker ps -q

docker stop $(docker ps -q)

docker rm $(docker ps -aq)

docker rmi $(docker images -q)

---

`Endpoints`

---

GET

localhost:8090/api/productos/listar

localhost:8090/api/usuarios/usuarios/2

localhost:8888/servicio-items/dev

localhost:8090/api/items/obtener-config

localhost:8090/api/productos/ver/11

localhost:8090/api/usuarios/usuarios

localhost:8090/api/items/ver/2/cantidad/5

localhost:8090/api/usuarios/usuarios/search/buscar-username?username=jorge

---

POST y Auth: 

localhost:8090/api/security/oauth/token

Postman: 
Authorization > Type: Basic Auth (Username: frontendapp, Password: 12345)
Body > x-www-form-urlencoded: ({"username":"admin","password":"12345", "grant_type":"password"})

Después de generar el token agregar en el header de la peticion: Authorization: Bearer Token <token>

---

Continúa POST

localhost:8090/api/items/crear

{
    "nombre": "Samsung Galaxy S9",
    "precio": "1000",
    "createdAt": "2022-10-26"
}

localhost:8090/api/productos/crear

{
    "nombre": "Panasonic Ultra HD",
    "precio": 1600,
    "createAt": "2022-10-28"
}

localhost:8090/api/usuarios/usuarios

{
    "username": "usuarioprueba",
    "password": "12345",
    "enabled": true,
    "nombre": "Usuario",
    "apellido": "Prueba",
    "email": "prueba@correo.com",
    "roles": [
        {
            "id": 1,
            "nombre": "ROLE_USER"
        },
        {
            "id": 2,
            "nombre": "ROLE_ADMIN"
        }
    ]
}

---

PUT

localhost:8090/api/usuarios/usuarios/2

{
    "username": "usuarioprueba",
    "password": "12345",
    "enabled": true,
    "nombre": "Usuario",
    "apellido": "Prueba",
    "email": "prueba@correo.com",
    "roles": [
        {
            "id": 1,
            "nombre": "ROLE_USER"
        },
        {
            "id": 2,
            "nombre": "ROLE_ADMIN"
        }
    ]
}

localhost:8090/api/productos/editar/11

{
    "nombre": "Sony Ultra HD",
    "precio": 2000
}

---

DELETE

localhost:8090/api/usuarios/usuarios/1

localhost:8090/api/productos/eliminar/11