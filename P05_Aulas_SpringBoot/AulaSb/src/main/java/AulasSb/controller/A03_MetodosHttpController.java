package AulasSb.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*Diz ao Spring que essa classe vai ser um controlador REST.
	Ou seja, ela vai responder requisições HTTP (GET, POST, PUT, DELETE etc.)
	com dados no formato JSON por padrão.
	 */
@RestController

/* Mapeia as operações dessa classe para o caminho "/metodos" */
@RequestMapping("/metodos")
public class A03_MetodosHttpController {

	/*
	 * Responde a requisições GET em "/metodos" Usado para listar todos os metodos,
	 * buscar dados sem alterar nada.
	 */
	@GetMapping
	public String get() {
		return "Requisição get ";
	}

	/*
	 * Responde a requisições POST em "/metodos" // Usado para criar um novo metodo
	 * no banco de dados.
	 */
	@PostMapping
	public String post() {
		return "Requisição POST";
	}

	/*
	 * Responde a requisições PUT em "/metodos".Usado para atualizar completamente
	 * um metodo existente.
	 */
	@PutMapping
	public String put() {
		return "Requisição PUT";
	}

	/*
	 * Responde a requisições PATCH. Usado para atualização **parcial** (ex: só o
	 * nome ou o preço).
	 */
	@PatchMapping
	public String patch() {
		return "Requisição PATCH";
	}

	/*
	 * Responde a requisições DELETE Usado para remover um metodo pelo ID.
	 */
	@DeleteMapping
	public String delete() {
		return "Requisição DELETE";
	}
}
