package C02_Layout;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class A04_Caixa extends HBox {

	private static int i = 0;

	private String[] Cores = {

			"#c33c5e", "#39aac6", "#28d79a", "#fb750e", "#6657a8", "#f9060e" };

	public A04_Caixa() {

		/* Chama o outro construtor passando largura e altura padrão */
		this(100, 100);

	}

	/* Construtor que recebe largura e altura como parâmetros */
	public A04_Caixa(int largura, int altura) {
		
		/* Centraliza os elementos dentro da caixa */
		setAlignment(Pos.CENTER);

		setMinHeight(altura);
		setMinWidth(largura);

		BackgroundFill fill = new BackgroundFill(Color.web(Cores[i]), new CornerRadii(20), Insets.EMPTY);

		setBackground(new Background(fill));

		i++;
		if (i == 6)
			i = 0;

	}

	/* Método para adicionar um texto dentro da caixa */
	public A04_Caixa ComTexto(String texto) {

		Label label = new Label(texto);

		label.setFont(new Font(20));
		/*
		 * Adiciona o label dentro da caixa
		 */
		getChildren().add(label);

		return this;
	}

}
