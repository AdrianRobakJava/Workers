package application;

import java.io.File;
import java.io.IOException;
//import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PrimaryWindow {
	
	
	@FXML
	private Button addButton;
	@FXML
	private Button logoutButton;
	@FXML
	private Button closeButton;
	@FXML
	private Button editButton;
	@FXML
	private Button searchButton;
	@FXML
	private Button saveButton;
	@FXML
	private Button deleteButton;
	@FXML
	private Button loadButton;
	@FXML
	private TextField searchField;
	@FXML
	private ImageView imageView;
	@FXML
	private Label correctLabel;
	@FXML
	private Label firstNameLabel;
	@FXML
	private Label lastNameLabel;
	@FXML
	private Label departamentLabel;
	@FXML
	private Label positionLabel;
	@FXML
	private Label idNumberLabel;
	
	
	private EmployeesList employeesList;
	private Employee employee;
	@FXML
	private ListView<Employee> employeeListView;
	private ObservableList<Employee> employeeListViewData = FXCollections.observableArrayList();
	//private int employeeCount = 0;
	
	public PrimaryWindow() {
		employeesList = new EmployeesList();
		
	}
	
	@FXML
	private void initialize() {
		initAddButton();
		initCloseButton();
		initEditButton();
		initSearchButton();
		initLogoutButton();
		initListView();
		initListSelect();
		initSaveButton();
		initLoadButton();
		initDeleteButton();
	}	
	private void initEditButton() {
		editButton.setOnAction((event)->{
			try {
				if(employee != null) {
					showEditEmplyeeWindow(employee);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	private void initSearchButton() {
		searchButton.setOnAction((event)->{
			if(employeesList.getEmployeesList().get(searchField.getText()) != null) {	
				try {
					if(employeesList.getEmployeesList().get(searchField.getText()) != null) {
						showEditEmplyeeWindow(employeesList.getEmployeesList().get(searchField.getText()));
						searchField.setText("");
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}else {
				correctLabel.setTextFill(Color.FIREBRICK);
				correctLabel.setText("Nia ma pracownika o takim numerze!");
			}
		});
	}
	private void initLogoutButton() {
		logoutButton.setOnAction((event)->{
			Stage stageLog = (Stage) logoutButton.getScene().getWindow();
			stageLog.close();
			try {
				Parent root = FXMLLoader.load(getClass().getResource("LoginWindow.fxml"));
				Stage stage = new Stage();
				stage.setTitle("Okno logowania");
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage.setScene(scene);
				stage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		});
	}
	private void initAddButton() {
		addButton.setOnAction((event)->{
			try {
				showAddEmployeeWindow();
				//Parent root = FXMLLoader.load(getClass().getResource("AddEmployeeWindow.fxml"));
				//Stage stage = new Stage();
				//stage.setTitle("Okno dodawania pracownika");
				//Scene scene = new Scene(root);
				//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				//stage.setScene(scene);
				//stage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		});
		
	}
	private void initCloseButton() {
		closeButton.setOnAction((event)->{
			Stage stage = (Stage) closeButton.getScene().getWindow();
			stage.close();
		});
	}
	public Stage showEditEmplyeeWindow(Employee emp) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("editEmployee.fxml"));
		//Parent loader = FXMLLoader.load(getClass().getResource("editEmployee.fxml"));
		Stage stage = new Stage();
		stage.setTitle("Okno edycji pracownika");
		Scene scene = new Scene(loader.load());
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		editEmployee controller = loader.<editEmployee>getController();
		controller.initData(emp);
		stage.show();
		stage.setOnHiding((event)->{
			initListView();
		});
		return stage;
	}
	public Stage showAddEmployeeWindow() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("AddEmployeeWindow.fxml"));
		Stage stage = new Stage();
		stage.setTitle("Okno dodawania nowego pracownika");
		Scene scene = new Scene(loader.load());
		stage.setScene(scene);
		//stage.setScene(new Scene(loader.load()));
		AddEmployeeWindow controller = loader.<AddEmployeeWindow>getController();
		controller.initData(employeesList);
		stage.show();
		stage.setOnHiding((event)->{
			initListView();
		});
		return stage;
	}
	public void initListView() {
		employeeListViewData.clear();
		for(Employee emp : employeesList.getEmployeesList().values()) {
			employeeListViewData.add(emp);
		}
		employeeListView.setItems(employeeListViewData);
		employeeListView.setCellFactory((list) -> {
			return new ListCell<Employee>() {
				@Override
				protected void updateItem(Employee empl, boolean empty) {
					super.updateItem(empl, empty);
					if(empl == null || empty) {
						setText(null);
					}else {
						setText(empl.getFirstName() + " " + empl.getLastName());
					}
				}
			};
		});
		
	}
	public void initListSelect() {
		employeeListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->{
			if(newValue != null) {
				firstNameLabel.setText(newValue.getFirstName());
				lastNameLabel.setText(newValue.getLastName());
				idNumberLabel.setText(newValue.getIdNumber()); 
				positionLabel.setText(newValue.getPosition());
				departamentLabel.setText(newValue.getDepartament());
				employee = newValue;
			}
		});
	}
	public void initSaveButton() {
		saveButton.setOnAction((event)->{
			new SaveAll(employeesList);
		});
		
	}
	public void initDeleteButton() {
		deleteButton.setOnAction((event)->{
			employeesList.removeEmployee(employee.getIdNumber());
			initListView();
			//try {
				String fileName = employee.getFirstName() + " " + employee.getLastName();
				String dir = System.getProperty("user.dir");
				File file = new File(dir + "/" + fileName + ".txt");
				file.delete();
			//}catch(IOException e) {}
			
		});
		
	}
	public void initLoadButton() {
		loadButton.setOnAction((event)->{
			new LoadAll();
			initListView();
		});
		
	}
	

}
