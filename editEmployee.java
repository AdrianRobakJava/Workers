package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class editEmployee {
	@FXML
	private TextField idField;
	@FXML
	private TextField firstNameField;
	@FXML
	private TextField lastNameField;
	@FXML
	private TextField addressField;
	@FXML
	private TextField departamentField;
	@FXML
	private TextField positionField;
	@FXML
	private TextField salaryField;
	@FXML
	private TextField bonusField;
	@FXML
	private TextField infoField;
	@FXML
	private TextArea salaryArea;
	@FXML
	private TextArea bonusArea;
	@FXML
	private Button saveButton;
	@FXML
	private Button closeButton;
	@FXML
	private Button addBonusButton;
	@FXML
	private Button addSalaryButton;
	@FXML
	private Button showButton;
	@FXML
	private Label correctLabel;
	private EmployeesList employeesList;
	private Employee currentEmployee;
	private String info;
	
	public editEmployee() {
	}
	
	
	public void initData (Employee el) {
		currentEmployee = el;
		initTextFields();
	}
	@FXML
	private void initialize() {
		initsaveButton();
		initCloseButton();
		initShowButton();
		initAddBonusButton();
		initAddSalaryButton();
		salaryArea.setEditable(false);
		bonusArea.setEditable(false);
		
		
	}
	public void initTextFields() {
		firstNameField.setText(currentEmployee.getFirstName());
		lastNameField.setText(currentEmployee.getLastName());
		idField.setText(currentEmployee.getIdNumber());
		addressField.setText(currentEmployee.getAddress());
		departamentField.setText(currentEmployee.getDepartament());
		positionField.setText(currentEmployee.getPosition());
		salaryField.setText(currentEmployee.getSalary());
		bonusField.setText(currentEmployee.getBonus());
		salaryArea.setText(currentEmployee.getSalaryList());
		bonusArea.setText(currentEmployee.getBonusList());
	}
	public void initsaveButton() {
		saveButton.setOnAction((events)->{
			if(allImput()) {
				currentEmployee.setAddress(addressField.getText());
				currentEmployee.setDepartament(departamentField.getText());
				currentEmployee.setPosition(positionField.getText());
				currentEmployee.setSalary(salaryField.getText());
				currentEmployee.setBonus(bonusField.getText());
				
				if(infoField.getText() == null  || infoField.getText().isEmpty()) {
				}else {
					info = currentEmployee.getComments();
					currentEmployee.setComments(infoField.getText() + "\n " +  info);
					//System.out.println(currentEmployee.getComments());
				}
				correctLabel.setTextFill(Color.GREEN);
				correctLabel.setText("Gotowe");
			}else {
				correctLabel.setTextFill(Color.FIREBRICK);
				correctLabel.setText("Musisz podaæ imiê, nazwisko oraz numer identyfikacyjny");
			}
		});
	}
	public void initShowButton() {
		showButton.setOnAction((event)->{
			new InfoWindow(currentEmployee.getComments());
		});
	}
	public void initAddBonusButton() {
		addBonusButton.setOnAction((event)->{
			String str = new String();
			if(currentEmployee.getBonusList() == null) {
				str = bonusField.getText();
			}else{
				str = currentEmployee.getBonusList() + ", " + bonusField.getText();
			}
			currentEmployee.setBonusList(str);
			bonusArea.setText(str);
			
		});
	}
	public void initAddSalaryButton() {
		addSalaryButton.setOnAction((event)->{
			String str = new String();
			if(currentEmployee.getSalaryList() == null) {
				str = salaryField.getText();
			}else {
				str = currentEmployee.getSalaryList() + ", " + salaryField.getText();
			}
			currentEmployee.setSalaryList(str);
			salaryArea.setText(str);
		});
	}
	public void initCloseButton() {
		closeButton.setOnAction((event)->{
			Stage stage = (Stage) closeButton.getScene().getWindow();
			stage.close();
		});
	}
	
	private boolean allImput() {
		if(firstNameField.getText() != null && !firstNameField.getText().isEmpty()
				&& lastNameField.getText() != null && !lastNameField.getText().isEmpty()
				&& idField.getText() != null && !idField.getText().isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
}
 