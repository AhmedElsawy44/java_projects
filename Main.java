package javaapplication4;
import java.util.ArrayList;
import java.util.Scanner;


interface EmployeeInterface {
    void viewEmployee();
}

class Employee implements EmployeeInterface {
    private String name;
    private int id;
    private double salary;
    public Employee(String name, int id,double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
     public double getsalary() {
        return salary;
    }

    @Override
    public void viewEmployee() {
        System.out.println("Employee ID: " + id + ", Name: " + name + ",salry:"+salary +"k$");
    }
}

// فئة المدير التي ترث من الموظف
class Manager extends Employee {
    private String department;

    public Manager(String name, int id, double salary,String department) {
        super(name, id,salary);
        this.department = department;
    }

    @Override
    public void viewEmployee() {
        System.out.println("Manager ID: " + getId() + ", Name: " + getName() + ",salry:"+getsalary() +"k$"+ ", Department: " + department);
    }
}

// نظام إدارة الموظفين
class EmployeeManagementSystem {
    private ArrayList<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void viewEmployee(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                emp.viewEmployee();
               
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public void deleteEmployee(int id) {
        employees.removeIf(emp -> emp.getId() == id);
    }

    public void viewAllEmployees() {
        for (Employee emp : employees) {
            emp.viewEmployee();
        }
    }
}

// الفئة الرئيسية لتشغيل النظام
public class Main {
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
                    System.out.print("Enter salary: ");
                    double salary = scanner.nextDouble();
                    if (type == 1) {
                        system.addEmployee(new Employee(name, id,salary));
                    } else if (type == 2) {
                        System.out.print("Enter Department: ");
                        String department = scanner.next();
                        system.addEmployee(new Manager(name, id,salary, department));
                     
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