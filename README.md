# Strategy - Explicación del escenario

Con la finalidad de comprender mejor lo que acabamos de explicar expondremos un escenario bastante común en las aplicaciones. Imaginemos que estamos diseñando una aplicación que hace cualquier cosa pero nos han pedido que esta aplicación permita definir la forma en la que los usuario se podrán autentificar con la aplicación, de entrada nuestro cliente nos dice que les dará la opción de que los usuarios se puedan autentificar de tres formas, sin embargo, nos ha dejado en claro que requiere que la aplicación esté preparada para soportar más formas de autentificación.

Los métodos de autentificación que la aplicación deberá de soportar son:

* XML Authentification: Permite al administrador dar de alta a los usuarios de la aplicación mediante un archivo XML.
* SQL Authentification: Permitirá al administrador dar de alta usuarios mediante el registro de éstos en una tabla de la base de datos.
* OnMemory Authentification: Permitirá al administrador dar de alta a nuevos usuarios que vivan en la memoria del programa.

Los puntos a tomar en cuenta son los siguientes:

1. La autentificación se realizará mediante usuario y contraseña y el autenticador nos deberá indicar el rol del usuario dentro de la aplicación.
2. La aplicación le deberá indicar el método de autentificación que desea utilizar para el logeo.

![alt text](https://reactiveprogramming.io/public/books/patterns/img/patterns/strategy2.png)

En la imagen podemos apreciar un escenario de autentificación sin utilizar el patrón estrategia, en la imagen podemos apreciar los tres proveedores de autentificación disponibles. Si bien todos implementan la misma interfaz, este escenario presenta algunos problemas.

* El primero es que el cliente debe estar atento cuando la estrategia de autentificación cambie con el fin de utilizar un proveedor distinto.
* Segundo, es necesario conocer las implementaciones concretas utilizadas para realizar la autentificación.
* Tercero, es que no siempre podemos notificar al cliente en tiempo de ejecución para indicarle la nueva estrategia.
* El cuarto problema es que tenemos que configurar al cliente cada vez que una nueva estrategia sea dada de alta, por ejemplo una autentificación por medio de un servidor LDAP o por WebService.
