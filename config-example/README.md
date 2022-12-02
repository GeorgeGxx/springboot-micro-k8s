# Microservices Config Server Files (Bundle)

Para instancias de 16Gb+ de RAM con imagen SQL sin imagen pueden ser 8Gb+.

Se debe crear un repo unico con x nombre que va en el properties del config server junto con el token en las lineas:

spring.cloud.config.server.git.uri=https://github.com/usuario/repo-name.git

spring.cloud.config.server.git.username=usuario

#GitHub > Settings > Developer settings > Personal access tokens

spring.cloud.config.server.git.password=ghp_...

