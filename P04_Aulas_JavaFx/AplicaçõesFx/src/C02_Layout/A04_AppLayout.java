package C02_Layout;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class A04_AppLayout extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		Parent raiz = null;
		//raiz = new A05_TesteAnchorPane();
		// raiz = new A05_TesteBorderPane();
		// raiz = new A05_TesteFlowPane();
		// raiz = new A06_TesteStackPane();
		raiz = new A06_TesteGridPane();

		Scene principal = new Scene(raiz);

		primaryStage.setScene(principal);

		/* Maximiza a tela do usuário */
		primaryStage.setMaximized(true);

		primaryStage.setTitle("Gerenciador Layout");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
