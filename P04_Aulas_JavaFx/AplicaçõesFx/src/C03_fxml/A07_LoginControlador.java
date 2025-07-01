package C03_fxml;

import org.controlsfx.control.Notifications;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class A07_LoginControlador {

	@FXML
	private TextField campoEmail;

	@FXML
	private PasswordField campoSenha;

	/* Metodos que iremos usar dentro da nossa aplicação fxml */
	public void entrar() {

		boolean emailValido = campoEmail.getText().equals("david@gmail.com");
		boolean senhaValida = campoSenha.getText().equals("123");

		if (emailValido && senhaValida) {
			Notifications.create().title("Login FXML").text("Login Efetuado !").showInformation();


		} else {
			Notifications.create().title("Login FXML").text("Ocorreu um erro.Tente Novamente!").showError();
		}
	}


}
