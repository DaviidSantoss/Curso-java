package C02_Layout;

import javafx.scene.layout.BorderPane;

public class A05_TesteBorderPane extends BorderPane {

	public A05_TesteBorderPane() {

		A04_Caixa c1 = new A04_Caixa().ComTexto("Topo");
		setTop(c1);
		A04_Caixa c2 = new A04_Caixa().ComTexto("Esquerda");
		setLeft(c2);

		A04_Caixa c3 = new A04_Caixa().ComTexto("Direita");
		setRight(c3);

		A04_Caixa c4 = new A04_Caixa().ComTexto("Fundo");
		setBottom(c4);

		A04_Caixa c5 = new A04_Caixa().ComTexto("Area Central");
		setCenter(c5);

	}



}
