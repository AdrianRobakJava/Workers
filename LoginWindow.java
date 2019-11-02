package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginWindow {
	
	private Stage st;
	
	@FXML
	private Label correctLabel;
	@FXML
	private TextField loginField;
	@FXML
	private PasswordField passField;
	@FXML
	private Button loginButton;
	@FXML
	private Button closeButton;
	
	public LoginWindow() {
		
	}
	
	
	@FXML
	private void initialize() {
		initLoginButton();
		initCloseButton();
	}	
	private void initLoginButton() {
		loginButton.setOnAction((event)->{
			if(loginField.getText().equals("admin") && passField.getText().equals("admin")) {
				try {
					Parent root = FXMLLoader.load(getClass().getResource("PrimaryWindow.fxml"));
					Stage stage = new Stage();
					stage.setTitle("Główne okno");
					Scene scene = new Scene(root);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					stage.setScene(scene);
					stage.show();
					Stage stageLog = (Stage) loginButton.getScene().getWindow();
					stageLog.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			
				correctLabel.setText("Zalogowano");
			}else {
				correctLabel.setText("Błędne hasło lub login");
			}
		});
	}
	private void initCloseButton() {
		closeButton.setOnAction((event)->{
			Stage stage = (Stage) closeButton.getScene().getWindow();
			stage.close();
		});
	}

}
