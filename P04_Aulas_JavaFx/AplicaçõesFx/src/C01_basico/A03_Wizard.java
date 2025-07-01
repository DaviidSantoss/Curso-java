package C01_basico;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class A03_Wizard extends Application {

	/*
	 * Criamos nosso Stage("Palco") para comportar nossas cenas, e em seguida
	 * criamos todas as cenas que iremos utilizar.
	 */
	private Stage janela;
	private Scene passo1;
	private Scene passo2;
	private Scene passo3;
	@Override
	public void start(Stage primaryStage) throws Exception {

		janela = primaryStage;

		CriarPasso1();
		CriarPasso2();
		CriarPasso3();

		primaryStage.setScene(passo1);
		primaryStage.setTitle("Tela 1");
		primaryStage.show();

	}

	/* Criamos a "Passo 1" */
	private void CriarPasso1() {

		/* Criamos um botão que ira nos levar para a proxima tela. */
		Button next = new Button("Ir p/ Tela 2");

		/*
		 * Setamos uma ação para quando o botão for clicado a proxima cena será setada
		 * na cena atual fazendo assim a troca de cena.
		 */
		next.setOnAction(e -> {
			janela.setScene(passo2);
			janela.setTitle("Tela 2");
		});
		
		/*
		 * Adicionamos um caixa horizontal que ira conter nosso botão que estara alinha
		 * ao centro.
		 */
		HBox box = new HBox();
		box.getChildren().add(next);
		box.setAlignment(Pos.CENTER);
		
		/* E por fim criamos nossa Tela 1 */
		passo1 = new Scene(box, 400,400);
		
	}

	private void CriarPasso2() {

		/* Botão 3 com ação de ir para tela 3 */
		Button next = new Button("Ir p/ Tela 3");
		next.setOnAction(e -> {
			janela.setScene(passo3);
			janela.setTitle("Tela 3");
		});

		/* botão com ação de voltar para a tela 2 */
		Button back = new Button("<< Voltar p/ Tela 1");
		back.setOnAction(e -> {
			janela.setScene(passo1);
			janela.setTitle("Tela 1");
		});

		/* Caixa horizontal */
		HBox box = new HBox();
		box.getChildren().addAll(back, next);
		box.setAlignment(Pos.CENTER);
		box.setSpacing(10);

		/* Criação da cena e setando o titulo. */
		passo2 = new Scene(box, 400, 400);
		janela.setTitle("Tela 3");

	}


	private void CriarPasso3() {

		/* botão com ação de voltar para a tela 2 */
		Button back = new Button("<< Voltar p/ Tela 2");
		back.setOnAction(e -> {
			janela.setScene(passo2);
			janela.setTitle("Tela 2");
		});

		/* Botão com ação de encerrar o programa */
		Button exit = new Button("Fechar");
		exit.setOnAction(e -> {
			System.exit(0);
		});

		/* Caixa horizontal */
		HBox box = new HBox();
		box.getChildren().addAll(back, exit);
		box.setAlignment(Pos.CENTER);
		box.setSpacing(10);

		/* Criação da cena e setando o titulo. */
		passo3 = new Scene(box, 400, 400);
		janela.setTitle("Tela 3");

	}

	public static void main(String[] args) {
		launch(args);
	}

}
