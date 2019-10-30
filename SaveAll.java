package application;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveAll {
	
	private EmployeesList employeesList;
	private Employee employee;
	private int employeeCount = 0;
	private String name;
	private String dir = System.getProperty("user.dir");
	
	public SaveAll(EmployeesList el){
		//employeesList = new EmployeesList();
		employeesList = el;
		employeeCount = employeesList.getNumberOfEmployees();
			
		for(Employee emp : employeesList.getEmployeesList().values()) {
			name = emp.getFirstName() + " " + emp.getLastName();
			//System.out.println(emp.getFirstName() + " " + emp.getLastName());
			save(emp);
		}
	}
	public void save(Employee employ) {
		File file = new File(dir + "/" + name + ".txt");
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(file);
			pw.println(employ.getFirstName());
			pw.println(employ.getLastName());
			pw.println(employ.getIdNumber());
			pw.println(employ.getAddress());
			pw.println(employ.getDepartament());
			pw.println(employ.getPosition());
			pw.println(employ.getSalary());
			pw.println(employ.getBonus());
			pw.println(employ.getSalaryList());
			pw.println(employ.getBonusList());
			pw.println(employ.getComments());
			
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			pw.close();
		}
	}
}
