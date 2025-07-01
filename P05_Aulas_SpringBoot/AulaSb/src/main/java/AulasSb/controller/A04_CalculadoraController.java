package AulasSb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class A04_CalculadoraController {

	@GetMapping("/{a1}/{a2}")
	public int somar(@PathVariable int a1, @PathVariable int a2) {
		return a1 + a2;

	}

	@GetMapping(path = "subtrair")
	public int subtrair(@RequestParam(name = "a1") int a1, @RequestParam(name = "a2") int a2) {
		return a1 - a2;

	}
	
	


}
