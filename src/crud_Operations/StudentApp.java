package crud_Operations;

import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StudentLogin login=new StudentLogin();
		StudentDao dao=new StudentDao();
		System.out.println("-----First Login The Student Application-----");
		System.out.println("Enter The UserName:");
		String username=sc.next();
		System.out.println("Enter The Password:");
		String password=sc.next();
		boolean status=login.studentLogin(username, password);
		if(status) {
			System.out.println("Student Application Login Successfully..");
		}
		else {
			System.out.println("Invalid Credentials...");
		}
		while(true) {
			System.out.println("===Performing Crud Opertion====");
			System.out.println("1.Add Student\n2.View Student\n3.Update Student\n4.Delete Student\n5.Exit Student Application");
			System.out.println("Enter Your Choice:");
			int choice=sc.nextInt();
			switch(choice) {
			case 1 -> {
				System.out.println("Enter Student Name:");
				String name=sc.next();
				System.out.println("Enter Student Class(like1,2,3)");
				int Class=sc.nextInt();
				System.out.println("Enter Student Marks");
				double marks =sc.nextDouble();
				System.out.println("Enter Student Fee");
				double fee =sc.nextDouble();
				dao.addStudent(name, Class, marks, fee);
				}
			case 2->dao.viewStudent();
			case 3 -> {
				System.out.println("Enter Student name:");
				String name=sc.next();
				System.out.println("Enter Student roll number");
				int srollno=sc.nextInt();
				dao.updateStudent(name, srollno);
				}
			case 4 -> {
				System.out.println("Enter Student Roll.No(like 1,2,3)");
				int Class=sc.nextInt();
				dao.deleteStudent(Class);
				}
			case 5->{
				System.out.println("Application Closed..");
				System.exit(0);
				}
			default-> System.out.println("Your Choice Invalid..\nEnter a Valid Choice");
			}
			
		}
	}

}
