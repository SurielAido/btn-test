# btn-test
Este proyecto es una prueba para Between

## Herramientas y versiones
- El proyecto se ha creado con el uso de maven.
- Se ha utilizado la versión de JAVA 11 y la version 2.6.6 de spring-boot.
- Además, se han importado las siguientes librerías:
    - JPA
    - log4j
    - Lombok
    - JUnit
    - Datafaker
    - StringUtils
- Como base de datos se ha utilizado h2.

## Asunciones
- Se ha asumido durante el desarrollo, a falta de otra información, que todos los campos de la entidad Price no puede ser nulos, por lo que se han hecho las validaciones oportunas.

## Tests
- Como test unitarios, se han desarrollado 5 test unitarios, uno sobre el servicio y 4 sobre el controlador.
- Como test de aceptación, se han realizado pruebas con POSTMAN, de manera que los 5 casos que se han solicitado en la prueba quedan reflejados en las imágenes de la carpeta "images" de este mismo repositorio.
    - Test 1:  ![test1](/images/Test1.png)
    - Test 2:  ![test1](/images/Test2.png)
    - Test 3:  ![test1](/images/Test3.png)
    - Test 4:  ![test1](/images/Test4.png)
    - Test 5:  ![test1](/images/Test5.png)

## Instalación y usabilidad.
Para probar el funcionamiento de la App solo es necesario tener instalado java 11, clonar el proyecto de este repositorio, hacen un "mvn clean install" para que baje las dependencias necesarias y arrancar la aplicación (BetweenTestApplication.java). Tras esto, la base de datos estará creada con la tabla Price y los datos de prueba. De la misma manera, cuando la aplicación pare, los datos se elimnarán, ya que es una BBDD levantada en memoria, tal y como se requería en la prueba. 
Siempre que se levante la aplicación, la BBDD se levantará con la tabla y los datos de prueba. Además de esto, la aplicacion se levanta en el puerto 8080, por lo que con levantar la aplicación y hacer una petición
GET http://localhost:8080/price?startdate=2020-06-16-21.00.00&productid=35455&brandid=1 se obtendrá el resultado deseado. Para obtener otros resultados, tan solo es necesario cambiar los parámetros de entrada.
