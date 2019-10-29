package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AddEmployeeWindow {
	
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
	
	public AddEmployeeWindow() {
		
		//employeesList = new EmployeesList();
		//initData(employeesList);
	}
	
	
	public void initData (EmployeesList el) {
		employeesList = el;
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
	public void initsaveButton() {
		saveButton.setOnAction((events)->{
			if(allImput()) {
				Employee emp = new Employee(firstNameField.getText(), lastNameField.getText(), idField.getText());
				emp.setAddress(addressField.getText());
				emp.setDepartament(departamentField.getText());
				emp.setPosition(positionField.getText());
				emp.setSalary(salaryField.getText());
				emp.setBonus(bonusField.getText());
				if(infoField.getText() != null && !infoField.getText().isEmpty()) {
					emp.setComments(infoField.getText());
				}
				employeesList.addEmployee(emp);
				correctLabel.setTextFill(Color.GREEN);
				correctLabel.setText("Gotowe");
			}else {
				correctLabel.setTextFill(Color.FIREBRICK);
				correctLabel.setText("Musisz podaæ imiê, nazwisko oraz numer identyfikacyjny");
			}
		});
	}
	public void initShowButton() {
		showButton.setVisible(false);
		showButton.setOnAction((event)->{
			System.out.println("show");
		});
	}
	public void initAddBonusButton() {
		addBonusButton.setVisible(false);
		bonusArea.setVisible(false);
		addBonusButton.setOnAction((event)->{
			System.out.println("addBonus");
		});
	}
	public void initAddSalaryButton() {
		salaryArea.setVisible(false);
		addSalaryButton.setVisible(false);
		addSalaryButton.setOnAction((event)->{
			System.out.println("addSalary");
			
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
