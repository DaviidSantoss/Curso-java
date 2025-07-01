package C02_Layout;

import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class A05_TesteAnchorPane extends AnchorPane {

	public A05_TesteAnchorPane() {

		/*
		 * Através do comando "setTop" setamos que o quadrado "Q1 ficara setado na parte
		 * de cima, e o comando "setLeft" nos indica que ele ficara na parte esquerda,
		 * ou seja nosso quadrado "Q1" ficara na parte superior esquerdo a 10 pixels de
		 * distância tanto da parte de cima quando da parte da esquerda.
		 */
		A04_Quadrado q1 = new A04_Quadrado();
		setTopAnchor(q1, 10.0);
		setLeftAnchor(q1, 10.0);

		A04_Quadrado q2 = new A04_Quadrado();
		setTopAnchor(q2, 10.0);
		setRightAnchor(q2, 10.0);

		A04_Quadrado q3 = new A04_Quadrado();
		setBottomAnchor(q3, 10.0);
		setRightAnchor(q3, 10.0);

		A04_Quadrado q4 = new A04_Quadrado();
		setBottomAnchor(q4, 10.0);
		setLeftAnchor(q4, 10.0);

		/*
		 * Com essa Hbox conseguimos alinhar um elemento ao centro mesmo com a
		 * diminuição ou aumento da tela o elemento sempre permanecera ao centro.
		 */
		HBox centro = new HBox();
		centro.setAlignment(Pos.CENTER);
		setTopAnchor(centro, 0.0);
		setBottomAnchor(centro, 0.0);
		setLeftAnchor(centro, 0.0);
		setRightAnchor(centro, 0.0);

		A04_Quadrado q5 = new A04_Quadrado();

		centro.getChildren().add(q5);

		getChildren().addAll(q1, q2, q3, q4, centro);

	}

}
