package C03_fxml;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class A07_AppFXML extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		String filecss = getClass().getResource("/C03_fxml/A08_Login.css").toExternalForm();
		
		/*
		 * Criamos uma URL que ira buscar nosso arquivo "Login.fxml", o comando
		 * "getClass()" pega a classe atual que está executando o código, em seguida o
		 * "getResource()" procura nossa classe "/C03_fxml/Login.fxml" e retorna um
		 * objeto do tipo url.
		 */
		URL ArquivoFXML = getClass().getResource("/C03_fxml/Login.fxml");

		/*
		 * Lê o arquivo Login.fxml e carrega o layout como um GridPane (nó raiz da
		 * interface).
		 */
		GridPane raiz = FXMLLoader.load(ArquivoFXML);
		
		/* setamos a cena */
		Scene cena = new Scene(raiz);
		
		/* Aplicamos nosso css a cena atual */
		cena.getStylesheets().add(filecss);

		/* Definimos que a cena sera maximizada sempre que o programa for iniciado */
		primaryStage.setMaximized(true);

		/* setamos o nome do programa */
		primaryStage.setTitle("Tela Login"); 

		/* Definios a cena */
		primaryStage.setScene(cena);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	

}
