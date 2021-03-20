# Taller All Secure App Spark
## Security Login

## Circleci

## Descripcion

Es proyecto nos permite ingresar de una manera segura con el protocolo https 
a una aplicacion web, en este momento nos permite iniciar sesion con un login y usar una 
calculadora basica, esta calculadora usa metodos Rest para obtener el resultado al hacer una 
conexion segura con otro proyecto que podemos encontrar en el siguiente repositorio:

* https://github.com/jsr25/Taller6ArepApi

## Requisitos
Para el uso de esta aplicacion se necesitan las siguientes herramientas"
* Java
* maven
* SparkJava
* Docker

## Instalacion 
Debe descargar los dos repositorios usando los siguientes commandos:
* git clone https://github.com/jsr25/Taller6ArepApi.git
* git clone https://github.com/jsr25/Taller6ArepLogin.git

Al tenerlos descargados debe ingresar a la raiz de cada proyecto y ejecutar 
el siguiente comando:
* mvn install

para generar las images de docker para los proyectos deben se guir los siguiente pasos:
* ingresar a la raiz del proyecto
* ejecutar docker docker build --tag <nombre imagen> . 

De esta manera genera las imagenes docker correctamente, recuerde que los nombres de
las imagenes deben ser diferentes

## Imagenes Docker
Puede obtener la imagenes del proyecto ejecutando los siquientes comandos


## Video
https://www.youtube.com/watch?v=ALH2o-YpCvU&ab_channel=JuanRamos

## Arquitectura

## Javadoc
La documentación se encuentra en el directorio apidocs dentro el directorio Robin y LogService, para generar una nueva documentación
pueden hacer uso del comando mvn javadoc:javadoc en su Shell esta se generará en el directorio target/site.

## Licencia
En este proyecto se usó la licencia GNU - se puede ver [LICENSE.txt](LICENSE.txt) para más detalles.