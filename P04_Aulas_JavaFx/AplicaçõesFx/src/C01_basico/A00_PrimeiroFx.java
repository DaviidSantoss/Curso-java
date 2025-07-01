package C01_basico;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class A00_PrimeiroFx extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		
		Button a = new Button("A");
		Button b = new Button("B");
		Button c = new Button("C");
		
		VBox box = new VBox();
		
		box.getChildren().addAll(a,b,c);
		
		Scene cena = new Scene(box,800,600);

		
		primaryStage.setScene(cena);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {

		launch(args);
		
	}
	
	

}
