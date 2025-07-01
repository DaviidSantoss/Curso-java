package C02_Layout;

import javafx.application.Platform;
import javafx.scene.layout.StackPane;

public class A06_TesteStackPane extends StackPane {

	public A06_TesteStackPane() {

		A04_Caixa c1 = new A04_Caixa().ComTexto("1");
		A04_Caixa c2 = new A04_Caixa().ComTexto("2");
		A04_Caixa c3 = new A04_Caixa().ComTexto("3");
		A04_Caixa c4 = new A04_Caixa().ComTexto("4");
		A04_Caixa c5 = new A04_Caixa().ComTexto("5");
		A04_Caixa c6 = new A04_Caixa().ComTexto("6");

		getChildren().addAll(c2, c3, c4, c5, c6, c1);

		setOnMouseClicked(e -> {

			/* si o tamanho da cena x for maior que a altura da cena dividido por 2 */
			if (e.getSceneX() > getScene().getWidth() / 2) {

				/*
				 * quando o lado deireito foi cliclado pegaremos o elemento do indice 0 e o
				 * jogaremos pra frente fazendo assim a alternância das caixas, se a caixa 1
				 * está no indice 0 ao ser clicada ela será jogada para frente fazendo que a
				 * caixa 2 passe a ser o indice 0.
				 */
				getChildren().get(0).toFront();

			} else {
				getChildren().get(5).toBack();
			}

		});

		Thread t = new Thread(() -> {

			while (true) {

				try {
					Thread.sleep(2000);

					Platform.runLater(() -> {
						getChildren().get(0).toFront();
					});



				} catch (Exception e) {
					System.out.println(e.getMessage());

				}

			}
		});

		t.setDaemon(true);
		t.start();

	}

}
