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

<h1 align="center">🔍 Presentacion del programa</h1>
<p align="center">
<img width="700" heigth="auto" src="https://user-images.githubusercontent.com/105408069/210125107-af07f676-91d5-4e6d-b689-4a55840ef480.png">
<p>


## Verificacion  
Al seleccionar Login podremos ingresar nuestro usuario y contraseña (admin, admin). La logica de verificacio es muy simple, solo tiene una condicional y un String con los datos del usuario.
<p align="center">
<img width="700" heigth="auto" src="https://user-images.githubusercontent.com/105408069/210125112-50c14946-91d0-4a2b-9e73-b08b1c9a3717.png">
<p>
 
## Menu principal
Aqui podremos elegir entre dos opciones, ir al registro del hotel o ver todos los huespedes y sus reservas.
<p align="center">
<img width="700" heigth="auto" src="https://user-images.githubusercontent.com/105408069/210125183-f76c8b42-eb76-4234-8b9e-9f1274ee0581.png">
<p>

<h1 align="center">🔍 Registro de Reservas y Huespedes</h1>

## Sistema de reservas
Si elegimos la opcion de Registro de reservas se abrira la ventana <Strong>Sistema de reservas</Strong>, aqui podremos guardar en la base de datos los dias de estadia, el valor y la forma de pago del huesped. El valor es de $25 por dia, el valor total se calcula segun los dias elegidos y se hace de forma automatica mostrando el resultado en el campo  <Strong>Valor de la reserva</Strong>. En esta parte del registro se genera de forma interna la <Strong>clave foranea</Strong> que usaremos en el registro de huespedes
<p align="center">
<img width="700" heigth="auto" src="https://user-images.githubusercontent.com/105408069/210125588-f4439b84-595e-49a2-9320-83d6c506532f.png">
<p>
     
## Registro del huesped
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
<p align="center">
<img width="700" heigth="auto" src="https://user-images.githubusercontent.com/105408069/210199442-d9c1fcc9-3f16-4d50-b1f5-52f4bbf9c700.png">
<p>

<p align="center">
<img width="700" heigth="auto" src="https://user-images.githubusercontent.com/105408069/210199444-99c84ac3-33a9-4b5e-9ac6-c5f267461b8b.png">
<p>




     
## 🖥️ Tecnologías Utilizadas:

- Java
- Eclipse
- Biblioteca JCalendar
- MySql
- Plugin WindowBuilder </br>


## 📊 Banco de Dados

### ¿Cómo importar MySqlConnector al proyecto?

Es la misma ruta descrita para importar el <strong>JCalendar</strong>, haga clic con el botón derecho en el proyecto, <em>Build Path</em>, <em>Configure Build Path</em>, <em>Libraries</em>, <em>Add External JARs</em>. Para encontrar la ruta de este archivo <strong>.jar</strong>, ve al disco duro de tu computadora e ingresa a la carpeta  <em>Archivos de Programas (x86)</em>.

- Archivos de Programas (x86):
<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/101413385/173169394-a67b528a-c8b7-4f7a-b374-a1da81b1cc5d.png">
</p>

- MySQL
<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/101413385/173169551-b32a9978-3a05-4b6e-b077-f586d0c41e31.png">
</p>

- Connector J 8.0:

<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/101413385/173169584-48e21a03-e70f-4a65-9197-448a3645f526.png">
</p>

- My SQL Connector Java:
<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/101413385/173169737-5f93868e-df8f-4177-90ba-faf9570758ac.png">
</p>

### Modelado de tablas:

Para este reto te proponemos dos tablas: <strong>Reservas</strong> y <strong>Huéspedes</strong>. La tabla de huéspedes debe contener la clave externa <em>(foreign key)</em> <strong>idReserva</strong>.

<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/101413385/169529338-09a4d4c2-1b5a-41dc-b305-38498ebc29a8.png">
</p>
<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/91544872/173358015-a252c5cf-48a2-4285-907d-a69239e7c5a5.png">
</p>

## 🗔 Plugin WindowBuilder

En el menú de <strong>Eclipse</strong>, ir a la pestaña <em>Help</em> y seleccione la opción <em>Eclipse Marketplace</em>.

<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/101413385/173254683-a4d27b04-3994-4c7b-bf70-6e1b665a5452.png">
</p>

En la barra de búsqueda, ingresa <strong>window builder</strong> y haz click en <em>Go</em>. Después de la búsqueda, selecciona la primera opción y haz click en <em>Install</em>.

<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/101413385/173254936-b1ed41ba-af1b-47ae-bf75-00de4a22ff19.png">
</p>

En la siguiente ventana, selecciona el botón <em>Confirm</em>.

<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/101413385/173255237-94789460-0544-4dd3-b00d-2738b83bd575.png">
</p>

Haz click en la opción para aceptar los Términos de Uso, y para finalizar haz clic en <em>Finish</em>.

<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/101413385/173255298-05ac80f1-3e93-4097-90af-7fc8a4fa1611.png">
</p>

Después de la instalación, será necesario reiniciar el <strong>Eclipse</strong>.

### ¿Cómo abrir cada ventana de diseño?

Una vez que completes el desafío, si quieres explorar el <em>Window Builder</em> y agregar nuevas ventanas, o cambiar el diseño de las existentes, haz clic en el archivo <strong>.java</strong>, y luego en <em>Open With</em> y finalmente en <em>Window Builder Editor</em>.

<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/101413385/173681973-5699a164-b66d-49f5-87c1-5436dd425457.png">
</p>

La pestaña de <em>Design</em> se abrirá por encima de la zona del <em>Console</em>. ¡Aquí puedes liberar al artista que llevas dentro de ti!

<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/101413385/173682648-4c371224-fe4b-4e57-a3ee-9298a4d44554.png">
</p>

## 📬 Entrega

### ¿Cómo incluir mi proyecto con el "#" del desafío?

1) Ten el <strong>Fork</strong> del proyecto en tu repositorio en Github.
2) Utilize el topico **#challengeonehotelaluralatam2** </br>
3) Ve a la pestaña derecha de tu proyecto y haz clic en el engranaje de configuración en la sección <em>About</em>, seleccione el campo **topics** e inserte la etiqueta **challengeonehotelaluralatam3**


### ¿Cómo hago la entrega final de mi Proyecto?

4) Rellena el siguiente formulario con tus datos personales, junto con el enlace de tu repositorio. 🔹 [Link para o formulário](https://lp.alura.com.br/alura-latam-lp-entrega-de-challenge-one-esp)

<p align="center" >
     <img width="700" heigth="700" src="https://user-images.githubusercontent.com/91544872/179625558-4dda7e69-bdaf-4a79-9ca9-82cf8fede9de.png">
</p>

5) Ve a tu correo electrónico y canjea tu insignia obtenida al completar otro desafío del Proyecto ONE! 🏆

6) ¡No olvides poner un enlace o video de tu proyecto en Linkedin! Etiqueta a #Oracle y #AluraLatam 🏁


## Autor:
| [<img src="https://avatars.githubusercontent.com/u/105408069?v=4" width=115><br><sub>Javir Anibal Villca</sub>](https://github.com/Javier104-dev)  |
| :---: |
