# Taller All Secure App Spark
## Security Login

## Circleci
[![CircleCI](https://circleci.com/gh/jsr25/Taller6ArepLogin.svg?style=svg)](https://app.circleci.com/pipelines/github/jsr25/Taller5Arep)


## Descripcion

Es proyecto nos permite ingresar de una manera segura con el protocolo HTTPS
a una aplicación web, en este momento nos permite iniciar sesión con un login y usar una
calculadora básica, esta calculadora usa métodos Rest para obtener el resultado al hacer una
conexión segura con otro proyecto que podemos encontrar en el siguiente repositorio:

* https://github.com/jsr25/Taller6ArepApi

## Requisitos
Para el uso de esta aplicacion se necesitan las siguientes herramientas"
* [Java](https://openjdk.java.net/)
* [maven](https://maven.apache.org/)
* [SparkJava](https://sparkjava.com/)
* [Docker](https://www.docker.com/)

## Instalacion 
Debe descargar los dos repositorios usando los siguientes comandos:
* git clone https://github.com/jsr25/Taller6ArepApi.git
* git clone https://github.com/jsr25/Taller6ArepLogin.git

Al tenerlos descargados debe ingresar a la raíz de cada proyecto y ejecutar
el siguiente comando:
* mvn install

Para generar las imágenes de docker para los proyectos deben seguir los siguientes pasos:
* ingresar a la raíz del proyecto
* ejecutar docker docker build --tag <nombre imagen> . 

De esta manera genera las imágenes docker correctamente, recuerde que los nombres de
las imágenes deben ser diferentes

## Imagenes Docker
Puede obtener las imágenes del proyecto ejecutando los siguientes comandos


## Video
https://www.youtube.com/watch?v=ALH2o-YpCvU&ab_channel=JuanRamos

## Arquitectura

## Javadoc
La documentación se encuentra en el directorio apidocs dentro el directorio Robin y LogService, para generar una nueva documentación
pueden hacer uso del comando mvn javadoc:javadoc en su Shell esta se generará en el directorio target/site.

## Licencia
En este proyecto se usó la licencia GNU - se puede ver [LICENSE.txt](LICENSE.txt) para más detalles.