<h1 align="center">Java | Back-end | Hotel Alura</h1>


<p align="center" >
     <img width="300" heigth="300" src="https://user-images.githubusercontent.com/91544872/189419040-c093db78-c970-4960-8aca-ffcc11f7ffaf.png">
</p>

---
##  Entrega de mi Challenge ONE Java: Hotel Alura:

En esta ocasion debiamos realizar la logica detras de un programa para poder conectarnos a una base de datos y poder registrar a los huespedes y sus reservas en el hotel. Debiamos usar todo lo aprendido de Java utilizando Eclipse para poder cumplir con los requisitos del desafio que consistian en:


<strong>
🔹 Sistema de autenticación de usuario.</br>
🔹 Permitir crear, editar y eliminar una reserva para los clientes.</br>
🔹 Buscar en la base de datos todas las informaciones tanto de los clientes como de las reservas.</br>
🔹 Registrar, editar y eliminar datos de los huéspedes.</br>
🔹 Calcular el valor de la reserva en base a la cantidades de días.</br>
🔹 Base de datos para almacenar todos los datos pedidos anteriormente.</br>
</strong>

<h1 align="center"> 🔴 Demostracion</h1>
Aqui se pueden ver todas las caracteristicas que tiene el programa, desde registrar a los huespedes y sus reservas hasta buscar, editar y borrarlos de la base de datos.

[![Alt text](https://img.youtube.com/vi/OZGkz9YAwLw/0.jpg)](https://www.youtube.com/watch?v=OZGkz9YAwLw)

<h1 align="center">🔍 Presentacion del programa</h1>
<p align="center">
<img width="700" heigth="auto" src="https://user-images.githubusercontent.com/105408069/210125107-af07f676-91d5-4e6d-b689-4a55840ef480.png">
<p>


<h2 align="center">Verificacion</h2>
Al seleccionar Login podremos ingresar nuestro usuario y contraseña (admin, admin). La logica de verificacio es muy simple, solo tiene una condicional y un String con los datos del usuario.
<p align="center">
<img width="700" heigth="auto" src="https://user-images.githubusercontent.com/105408069/210125112-50c14946-91d0-4a2b-9e73-b08b1c9a3717.png">
<p>
     
<h2 align="center">Menu principal</h2>
Aqui podremos elegir entre dos opciones, ir al registro del hotel o ver todos los huespedes y sus reservas.
<p align="center">
<img width="700" heigth="auto" src="https://user-images.githubusercontent.com/105408069/210125183-f76c8b42-eb76-4234-8b9e-9f1274ee0581.png">
<p>

<h1 align="center">🔍 Registro de Reservas y Huespedes</h1>

<h2 align="center">Sistema de reservas</h2>
Si elegimos la opcion de Registro de reservas se abrira la ventana <Strong>Sistema de reservas</Strong>, aqui podremos guardar en la base de datos los dias de estadia, el valor y la forma de pago del huesped. El valor es de $25 por dia, el valor total se calcula segun los dias elegidos y se hace de forma automatica mostrando el resultado en el campo  <Strong>Valor de la reserva</Strong>. En esta parte del registro se genera de forma interna la <Strong>clave foranea</Strong> que usaremos en el registro de huespedes
<p align="center">
<img width="700" heigth="auto" src="https://user-images.githubusercontent.com/105408069/210125588-f4439b84-595e-49a2-9320-83d6c506532f.png">
<p>
     
<h2 align="center">Registro del huesped</h2>
Una vez guardada la reserva en la base de datos debemos registrar al huesped, en esta ventana tendremos que llenar el formulario con nombre completo, fecha de nacimiento, nacionalidad y telefono. En el campo numero de reserva podremos ver la clave generada en la pestaña anterior, esta clave es la que vincula la tabla de reservas y huespedes en la base de datos, es su <Strong>clave foranea</Strong>. Una vez completado todos los campos con datos validos podremos enviarlos a nuestro servidor MySql con el boton <Strong>Guardar</Strong> y nos regresara al menu principal para poder agregar otra reserva.
<p align="center">
<img width="700" heigth="auto" src="https://user-images.githubusercontent.com/105408069/210125966-44b06459-dfce-4c83-a863-2eb5af7f1554.png">
<p>   
     
<h1 align="center">🔍 Buscar, editar y eliminar las reservas/huespedes</h1>

## Editar y eliminar registros de la base de datos
En la seccion <Strong>Busqueda</Strong> del menu principal podremos ver en dos pestañas todas las reservas y los huespedes registrados en el hotel. En estas tablas podremos editar y eliminar los registros que selecciones.

<h2 align="center">Eliminar</h2>
Para eliminar solo seleccionamos el registro y luego presionamos el boton <Strong>Eliminar</Strong>, esta opcion eliminara el registro de huespedes y sus reservas de forma simultanea aprovechando la clave foranea que creamos y vinculamos en la seccion de registro, actualizando y mostrando los datos en tiempo real.
<p align="center">
<img width="700" heigth="auto" src="https://user-images.githubusercontent.com/105408069/210128444-cc55c6d4-b2be-492e-b34c-3ec9b9f3a01b.png">
<p>

<h2 align="center">Editar</h2>
De la misma forma podremos editar los campos de la tabla, excepto el ID del huesped e Id de reserva, solamente haciendo doble click y escribiendo los datos nuevos. Para enviarlos al servidor y guardarlos solamente bastara con presionar el boton "Editar".
<p align="center">
<img width="700" heigth="auto" src="https://user-images.githubusercontent.com/105408069/210128446-1817e431-3272-4bd7-8994-86b4b92eaadf.png">
<p> 
     
<h2 align="center">Busqueda en la base de datos</h2>
Para obtener la reserva y sus huespedes podemos usar el <Strong>Id de reserva o el apellido del cliente</Strong>. Siempre se mostraran ambos registros y podremos eliminarlos o editarlos a nuestro gusto.

<p>Para volver a ver todos los huespedes y reservas debemos usar el boton <Strong>Ver registros</Strong></p>
<p align="center">
<img width="700" heigth="auto" src="https://user-images.githubusercontent.com/105408069/210199442-d9c1fcc9-3f16-4d50-b1f5-52f4bbf9c700.png">
<p>

<p align="center">
<img width="700" heigth="auto" src="https://user-images.githubusercontent.com/105408069/210199444-99c84ac3-33a9-4b5e-9ac6-c5f267461b8b.png">
<p>

     
## 🖥️ Tecnologías Utilizadas:

- Java 11
- Eclipse
- Biblioteca JCalendar
- MySql
- Plugin WindowBuilder </br>


## 📊 Banco de Dados

### MySql

Para este proyecto tuve que crear una base de datos en MySql con dos tablas, huespedes y reservas, ambas estan vinculadas con una clave foranea que utilice para la busqueda y el listado de los registros en el programa. El campo tiene como propiedad AUTO_INCREMENT por cada reserva creada.
<p>Aqui dejo unas imagenes donde se ven los valores que tienen ambas tablas:</p>

<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/101413385/169529338-09a4d4c2-1b5a-41dc-b305-38498ebc29a8.png">
</p>
<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/91544872/173358015-a252c5cf-48a2-4285-907d-a69239e7c5a5.png">
</p>

## 🖥️ Sobre mi desafio:

Realmente fue un gran desafio poder terminar este proyecto, esta era la segunda vez que ponia en practica todo lo que aprendi de Java y fue bastante dificil por que el unico lenguaje que conocia era JavaScript y estoy bastante acostumbrado a su forma de sintaxis, estructura, obtener los inputs, el debil tipado de datos, ect. Al ver el desafio dude muchas veces en siquiera terminar los primeros pasos, pero al comenzar poco a poco usar el Trello, analizar lo que nos estaban pidiendo y compararlo con lo que nos enseñaron pude darme cuenta que no era tan dificil como lo pensaba.
<p>Fue gratificante ver como completaba el programa, crear las peticiones al servidor, la logica para usar y mostrar los datos obtenidos, pero sobre todo ver que el codigo funcionaba en cada testeo. Una verdadera experiencia con este lenguaje de programacion llamado Java.</p>

Gracias por ver mi repositorio.

## Autor:
| [<img src="https://avatars.githubusercontent.com/u/105408069?v=4" width=115><br><sub>Javir Anibal Villca</sub>](https://github.com/Javier104-dev)  |
| :---: |
