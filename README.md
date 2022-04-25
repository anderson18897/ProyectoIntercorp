<!-- PROJECT LOGO -->
<br />
<p align="center">
  <div align="center"><h1>customer</h1></div>
  <div align="center"><h3>Technologies</h3></div>
  <div align="center">
    <a>
        <img src="./media/java.png" alt="Logo" width="150" height="100">
        <img src="./media/mysql.png" alt="Logo" width="100" height="100">
        <img src="./media/spring.png" alt="Logo" width="100" height="100">
    </a>
  </div><!-- PROJECT LOGO -->
<br />

## About customer microservice
This microservice dedicated to registering customers, searching by dni or email and consulting indicators.

```
​
## Run

# Run normally
$ Antes de ejecutar o abrir el proyecto debe crear un database en mysql llamada intercorp para que pueda crearse la conexion correspondiente, adicional cambiar los datos en el properties en caso tenga configurado con otros datos.
# Puedo abrirlo en un IDE en este caso fue desarrollado en intellij idea puedo abrir el proyecto y ejecutar el IntercopApplication o lo puedo realizar con el comando mvnw spring-boot:run
$ El microservicio esta por defecto en el puerto 8080 si en caso este ocupando este puerto agregar la siguiente línea de código en el archivo application.properties: server.port : "PUERTO DE SU PREFERENCIA"
# Por último abrir el postman y validar la funcionalidad en la raiz del proyecto esta subido el archivo swagger.yml documentado el microservicio en caso requiera mas detalle

