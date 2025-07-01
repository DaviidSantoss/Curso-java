package C02_Layout;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class A04_Quadrado extends Rectangle {

	private static int i = 0;

	private String[] Cores = {

			"#c33c5e", "#39aac6", "#28d79a", "#fb750e", "#6657a8", "#f9060e" };

	public A04_Quadrado() {

		/* Chama o outro construtor passando largura e altura padrão */
		this(100, 100);

	}

	/* Construtor que recebe largura e altura como parâmetros */
	public A04_Quadrado(int largura, int altura) {

		setHeight(altura);
		setWidth(largura);



		setFill(Color.web(Cores[i]));

		i++;
		if (i == 6)
			i = 0;

	}

}
