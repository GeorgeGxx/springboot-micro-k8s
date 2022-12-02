#!/bin/sh
#Linux

#cd -
#ls
docker cp ./springboot-micro-docker/zipkin-server/mysql.sql microservicios-mysql8:/tmp/mysql.sql
#Windows > Terminal IntelliJ
#docker cp .\zipkin-server\mysql.sql microservicios-mysql8:/tmp/mysql.sql
docker exec -it microservicios-mysql8 mysql -uroot -proot
SOURCE /tmp/mysql.sql;
create user 'zipkin'@'%' identified by 'zipkin';
#SHOW DATABASES;
#SELECT user,authentication_string,plugin,host FROM mysql.user;
alter user 'zipkin'@'%' identified with mysql_native_password by 'zipkin';
grant all privileges on zipkin.* to 'zipkin'@'%';
flush privileges;
exit;
#cd springboot-micro-docker/docker-compose

#RUN docker exec -it microservicios-mysql8 bash
#RUN cd /tmp
#pwd
#ls
#