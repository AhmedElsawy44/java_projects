/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Scanner;
/**
 *
 * @author hp
 */
public class EmployeeSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManagementSystem system = new EmployeeManagementSystem();

        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. View All Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your Choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee Type (1 for Employee, 2 for Manager): ");
                    int type = scanner.nextInt();
                    System.out.print("Enter Name: ");
                    String name = scanner.next();
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Salary$: ");
                    double salary = scanner.nextDouble();
                    if (type == 1) {
                        system.addEmployee(new Employee(name, id, salary));
                    } else if (type == 2) {
                        System.out.print("Enter Department: ");
                        String department = scanner.next();
                        system.addEmployee(new Manager(name, id, salary, department));
                    }
                    break;
                case 2:
                    System.out.print("Enter Employee ID: ");
                    int viewId = scanner.nextInt();
                    system.viewEmployee(viewId);
                    break;
                case 3:
                    System.out.print("Enter Employee ID: ");
                    int deleteId = scanner.nextInt();
                    system.deleteEmployee(deleteId);
                    break;
                case 4:
                    system.viewAllEmployees();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
