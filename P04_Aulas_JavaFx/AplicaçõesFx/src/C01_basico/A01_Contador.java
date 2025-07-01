package C01_basico;



import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class A01_Contador extends Application {

	private int contador = 0;

	private void AtualizarNumero(Label label) {

		label.setText(Integer.toString(contador));

		label.getStyleClass().remove("positivo");
		label.getStyleClass().remove("negativo");

		if (contador < 0) {
			label.getStyleClass().add("negativo");
		} else {
			label.getStyleClass().add("positivo");
		}
	}

	@SuppressWarnings("unused")
	@Override
	public void start(Stage primaryStage) throws Exception {

		Platform.setImplicitExit(true);

		/*
		 * Criamos duas labels uma que vai conter o titulo da aplicação "Contador" outra
		 * que ira ser utilizada para atualizar os números.
		 */
		Label labelT = new Label("Contador");
		

		/* Aplicamos o estilo da classe "titulo" para nossa label. */
		labelT.getStyleClass().add("titulo");
		
		Label labelN = new Label("0");
		
		/* Aplicamos o estilo da classe "numero" para nossa label. */
		labelN.getStyleClass().add("numero");

		/*
		 * Criamos botões que utilizaremos para encrementar e decrementar.
		 */
		Button b1 = new Button("-");
		
		b1.getStyleClass().add("botoes");

		/*
		 * Definimos uma acão para os botões, em que ao ser clicado o contador sera
		 * decrementado em 1 e a label "LabelN" tera esse valor setado como String.
		 */
		b1.setOnAction(e -> {
			contador--;
			AtualizarNumero(labelN);


		});

		Button b2 = new Button("+");
		
		b2.getStyleClass().add("botoes");

		b2.setOnAction(e -> {
			contador++;
			AtualizarNumero(labelN);

		});



		/* Caixa Horizontal. */
		HBox caixaHo = new HBox();

		/* Adicionamos os botões dentro da caixa horizontal. */
		caixaHo.getChildren().addAll(b1, b2);

		/*
		 * Setamos o espaçamento entre os botôes de 10 pixels e alinhamos eles ao
		 * centro.
		 */
		caixaHo.setSpacing(10);
		caixaHo.setAlignment(Pos.CENTER);


		/* Caixa vertical. */
		VBox boxVer = new VBox();

		/*
		 * Setamos o espaçamento entre as labels de 10 pixels e alinhamos eles ao
		 * centro, e tbm adicionamos uma classe css chamada "conteudo" para a nossa
		 * "Caixa Vertical".
		 */
		boxVer.getStyleClass().add("conteudo");
		boxVer.setSpacing(10);
		boxVer.setAlignment(Pos.CENTER);

		/*
		 * Adicionamos todos nossos elementos visuais (labels e botões) dentro da nossa
		 * caixa vertical.
		 */
		boxVer.getChildren().addAll(labelT, labelN, caixaHo);

		/* Criamos uma nova cena */
		Scene cena = new Scene(boxVer, 400, 400);

		/*
		 * Informamos o caminho do arquivo css que será implementado dentro dessa nossa
		 * classe.
		 */
		String CaminhoDocss = getClass().getResource("/basico/A02_Contador.css").toExternalForm();


		/* Adicionamos o nosso arquivo css dentro da nossa classe */
		cena.getStylesheets().add(CaminhoDocss);

		/*
		 * Definimos a fonte para a nossa cena principal, porém ela sera somente
		 * aplicanda dentro da nossa "classe" css, dentro do nosso arquivo css existe
		 * uma classe chamada ".conteudo" e nós associamos a nossa "BoxVer" a essa
		 * classe, ou seja tudo que estiver dentro da nossa caixa vertical terá essa
		 * fonte.
		 */
		cena.getStylesheets().add("https://fonts.googleapis.com/css2?family=Inter");

		/*
		 * Setamos a cena e em seguida a exibimos na tela.
		 */
		primaryStage.setScene(cena);
		primaryStage.show();

	}

	public static void main(String[] args) {

		launch(args);
	}

}
