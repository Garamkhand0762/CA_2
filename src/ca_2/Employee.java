/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_2;

/**
 *
 * @author HP
 */
public class Employee {
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private double salary;
    private DepartmentType department;
    private String jobTitle;
    private String company;

    public Employee(String firstName, String lastName, String gender, String email, double salary,
                    DepartmentType department, String jobTitle, String company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.salary = salary;
        this.department = department;
        this.jobTitle = jobTitle;
        this.company = company;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public double getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    public DepartmentType getDepartment() {
        return department;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s, Email: %s, Gender: %s, Department: %s, Title: %s, Salary: %.2f, Company: %s",
                firstName, lastName, email, gender, department, jobTitle, salary, company);
    }
}
