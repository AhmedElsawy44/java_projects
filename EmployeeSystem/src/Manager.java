/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hp
 */
// Manager.java
public class Manager extends Employee {
    private String department;

    public Manager(String name, int id, double salary, String department) {
        super(name, id, salary);
        this.department = department;
    }

    @Override
    public void viewEmployee() {
        System.out.println("Manager ID: " + getId() + ", Name: " + getName() + ", Salary: " + getSalary() + "k$" + ", Department: " + department);
    }
}
