package br.com.builder.apicliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ApiClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiClienteApplication.class, args);
	}

}
