package com.shopAll.ApiRESTfull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Clase Principal para levantar la aplicación SpringBoot

@SpringBootApplication
public class ApiResTfullApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiResTfullApplication.class, args);
	}

}
//public static void main(String[] args) { ... }

//public: Esto significa que el método main puede ser invocado desde cualquier lugar de tu código.

//static: Esto indica que el método main se puede llamar sin necesidad de crear una instancia de la clase ApiResTfullApplication.
// En otras palabras, puedes ejecutarlo directamente.

//void: Esto indica que el método main no devuelve ningún valor.

//public static void main(String[] args) { ... }




//En resumen, este código define la clase principal de una aplicación Spring Boot (ApiResTfullApplication) con la anotación @SpringBootApplication.
//El método main utiliza SpringApplication.run para arrancar la aplicación y cargar el contexto de Spring Boot,
// que es el contenedor que gestiona los objetos (beans) de la aplicación.