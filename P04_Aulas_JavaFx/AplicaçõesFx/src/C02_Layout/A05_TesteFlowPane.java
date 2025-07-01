package C02_Layout;

import javafx.geometry.Insets;
import javafx.scene.layout.FlowPane;

public class A05_TesteFlowPane extends FlowPane {

	public A05_TesteFlowPane() {

		A04_Quadrado q1 = new A04_Quadrado();
		A04_Quadrado q2 = new A04_Quadrado();
		A04_Quadrado q3 = new A04_Quadrado();
		A04_Quadrado q4 = new A04_Quadrado();
		A04_Quadrado q5 = new A04_Quadrado();

		/*
		 * "setHgap" seta o pulo(gap) que um elemento tera do outro na direção
		 * horizontal, no nosso caso tera 10 pixel de distância na horizontal e
		 * vertical(setVgap), o "setPadding" seta um espaçamento de 10 pixels em todas
		 * as direções para cada elemento.
		 */
		setHgap(10);
		setVgap(10);
		setPadding(new Insets(10));


		getChildren().addAll(q1, q2, q3, q4, q5);
	}

}
