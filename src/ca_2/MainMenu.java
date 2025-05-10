/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_2;

/**
 *
 * @author HP
 */
import java.io.*;
import java.util.*;

public class MainMenu {
    private final List<Employee> employees;

    public MainMenu() {
        employees = new ArrayList<>();
        loadEmployeeDataFromFile("applicants_form.txt");
    }

    private void loadEmployeeDataFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Expecting format:
                // firstName,lastName,gender,email,salary,department,jobTitle,company
                String[] tokens = line.split(",");
                if (tokens.length == 8) {
                    String firstName = tokens[0];
                    String lastName = tokens[1];
                    String gender = tokens[2];
                    String email = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    DepartmentType department = DepartmentType.valueOf(tokens[5].toUpperCase().replace(" ", "_"));
                    String jobTitle = tokens[6];
                    String company = tokens[7];

                    Employee e = new Employee(firstName, lastName, gender, email, salary, department, jobTitle, company);
                    employees.add(e);
                }
            }
            System.out.println("Loaded " + employees.size() + " employees from file.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Placeholder for future menu interaction
    public void displayAllEmployees() {
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        menu.displayAllEmployees();
    }
}

