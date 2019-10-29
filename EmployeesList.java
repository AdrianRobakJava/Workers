package application;

import java.util.HashMap;

public class EmployeesList {
	private static HashMap<String, Employee> employeesList;
	private static int size;
	
	public EmployeesList() {
		employeesList = new HashMap<>();
	}
	public boolean addEmployee(Employee employee) {
		if(employeesList.get(employee.getIdNumber()) == null) {
			employeesList.put(employee.getIdNumber(), employee);
			size++;
			return true;
		}else {
			return false;
		}
		
	}
	public boolean removeEmployee(String id) {
		if(employeesList.get(id) != null) {
			employeesList.remove(id);
			size--;
			return true;
		}else {
			return false;
		}
	}
	public Employee getEmployee(String id) {
		return employeesList.get(id);
	}
	public int getNumberOfEmployees() {
		return size;
	}
	public HashMap<String, Employee> getEmployeesList(){
		return employeesList;
	}


}
