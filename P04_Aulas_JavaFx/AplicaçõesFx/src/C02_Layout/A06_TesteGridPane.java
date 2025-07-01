package C02_Layout;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;

public class A06_TesteGridPane extends GridPane {

	public A06_TesteGridPane() {

		A04_Caixa c1 = new A04_Caixa().ComTexto("1");
		

		/* Definimos esse método como true para podermos ver as linhas do grid */
		setGridLinesVisible(true);

		getColumnConstraints().addAll(co(), co(), co(), co(), co(), co());
		getRowConstraints().addAll(rc(), rc(), rc(), rc(), rc(), rc());

		add(c1, 2, 1, 2, 4);

		/*
		 * Criamos um novo backgroundfill ou em português (fundo completo) definimos
		 * suar cor como sendo cinza, seu CornerRadii como vazio e seus Insets como
		 * vazio.
		 */
		BackgroundFill fill = new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY);

		/*
		 * Logo após a criação do background acima setamos ele a nossa classe através do
		 * comando abaixo
		 */
		setBackground(new Background(fill));


	}

	private ColumnConstraints co() {
		ColumnConstraints co = new ColumnConstraints();

		co.setPercentWidth(20);
		co.setFillWidth(true);
		return co;

	}

	private RowConstraints rc() {

		RowConstraints rc = new RowConstraints();

		rc.setPercentHeight(20);
		rc.setFillHeight(true);
		return rc;

	}

}
