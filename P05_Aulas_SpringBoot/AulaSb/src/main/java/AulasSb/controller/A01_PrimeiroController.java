package AulasSb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/* Indica que esta classe é um controlador REST (retorna dados diretamente para APIs). */
@RestController
public class A01_PrimeiroController {

	/* Mapeia requisições GET para o endpoint "/ola" */
	@GetMapping("/ola")
	public String ola() {
		return "ola pequeno gafanhoto";
	}
}