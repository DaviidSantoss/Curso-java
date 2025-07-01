module AplicaçõesFx {
	
	requires javafx.controls;
	requires javafx.fxml;
	requires org.controlsfx.controls;
	
	opens C01_basico;
	opens C03_fxml;
	opens C02_Layout;
}