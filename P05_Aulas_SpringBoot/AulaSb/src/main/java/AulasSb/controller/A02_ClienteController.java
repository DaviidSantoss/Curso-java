package AulasSb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import AulasSb.models.entities.A01_Clientes;

/* Essa notação indica que essa classe é um controlador REST */
@RestController

/* Mapeia todas as operações deste controller para o caminho "/clientes" */
@RequestMapping("/clientes")
public class A02_ClienteController {

	/*
	 * mapeamos a requisição GET para o end point "/clientes/qualquer" que retorna
	 * um novo cliente.
	 */
	@GetMapping(path = "/qualquer")
	public A01_Clientes obterClientes() {
		return new A01_Clientes(28, "jose", "333.222.555-00");
	}

	/*
	 * Quando colocamos o "id" entre chaves estamos querendo dizer que esse id será
	 * uma variável.E com a notação "@PathVariable" indicamos que nosso path( ou
	 * URL) tera uma variável.
	 */
	@GetMapping("/{id}")
	public A01_Clientes obterClientePorId(@PathVariable int id) {
		return new A01_Clientes(id, "Maria", "222.333.655-98");
	}

	/*
	 * Quando usamos "@RequestParam", indicamos que o parâmetro será passado na URL
	 * como uma query string (ex: /clientes?id=123). O atributo "name" especifica o
	 * nome do parâmetro que será recebido na requisição.
	 */
	@GetMapping
	public A01_Clientes obterClientePorId2(@RequestParam(name = "id") int id) {
		id = 22;
		return new A01_Clientes(id, "joao", "111-222-333-44");
	}

}
