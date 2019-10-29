package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LoadAll {
	private String dir = System.getProperty("user.dir");
	private EmployeesList employeesList;
	private Employee employee;
	private int lineNumber;
	//private String str;
	private String fn = "";
	private String ln = "";
	private String id = "";
	private String ad = "";
	private String de = "";
	private String po = "";
	private String sa = "";
	private String bo = "";
	private String sal = "";
	private String bol = "";
	private String co = "";
	
	
	public LoadAll() {
		try {
		employeesList = new EmployeesList();
		File file = new File(dir);
		
		for(File f : file.listFiles()) {
			lineNumber = 0;
			//System.out.println(f.getName());
			Scanner scan = new Scanner(f);
			while(scan.hasNextLine() && lineNumber <=60 ) {
				lineNumber++;
				if(lineNumber == 1) {
					fn = scan.nextLine();
				}
				if(lineNumber == 2) {
					ln = scan.nextLine();
				}
				if(lineNumber == 3) {
					id = scan.nextLine();
				}
				if(lineNumber == 4) {
					ad = scan.nextLine();
				}
				if(lineNumber == 5) {
					de = scan.nextLine();
				}
				if(lineNumber == 6) {
					po = scan.nextLine();
				}
				if(lineNumber == 7) {
					sa = scan.nextLine();
				}
				if(lineNumber == 8) {
					bo = scan.nextLine();
				}
				if(lineNumber == 9) {
					sal = scan.nextLine();
				}
				if(lineNumber == 10) {
					bol = scan.nextLine();
				}
				if(lineNumber >= 11 && lineNumber <=60) {
					co = co + scan.nextLine()  + "\n" ;
					
				}
			}
			scan.close();
			newEmployee();
			co = "";
		}
	}catch(IOException e) {}
	//employeesList.s
	}
	public void newEmployee() {
		
		employee = new Employee(fn, ln, id );
		if(!ad.equals("null")) {
			employee.setAddress(ad);
		}
		if(!de.equals("null")) {
			employee.setDepartament(de);
		}
		if(!po.equals("null")) {
			employee.setPosition(po);
		}
		if(!sa.equals("null")) {
			employee.setSalary(sa);
		}
		if(!bo.equals("null")) {
			employee.setBonus(bo);
		}
		if(!sal.equals("null")) {
			employee.setSalaryList(sal);
		}
		if(!bol.equals("null")) {
			employee.setBonusList(bol);
		}
		if(!co.equals("null")) {
			employee.setComments(co);
		}
		employeesList.addEmployee(employee);
	}
	

}
