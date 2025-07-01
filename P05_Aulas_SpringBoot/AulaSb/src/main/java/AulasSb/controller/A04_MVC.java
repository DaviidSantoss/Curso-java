package AulasSb.controller;

public class A04_MVC {

	/* **************** VISÃO GERAL *****************/

	/*
	 * O Model contem regras de negócio,Entidades,Camadas de acesso á dados. A View
	 * é responsável por renderizar as respostas. Já o Controller ele cordexa o
	 * fluxo da aplicação, ele é o intermédio entre o model e a view.
	 */

	/*
	 * MVC SEM acesso a dados:
	 * 
	 * Você pede um hambúrguer ao garçom (Controller). O garçom faz o pedido ao
	 * cozinheiro (Model), que já tem os ingredientes na cozinha. O cozinheiro
	 * prepara e entrega o hambúrguer (resultado) para o garçom, que o entrega a
	 * você (View).
	 */

	/*
	 * MVC COM acesso a dados:
	 * 
	 * Você pede um hambúrguer ao garçom (Controller). O garçom pede ao cozinheiro
	 * (Model) que prepare o hambúrguer. O cozinheiro, para isso, consulta a
	 * despensa (banco de dados, via Repository). O hambúrguer é preparado e volta
	 * para o garçom, que o serve a você.
	 */

}
