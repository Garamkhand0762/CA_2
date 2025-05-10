/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author HP
 */
 
import java.io.*;
import java.util.*;

public class CA_2{
    private List<Employee> employees;
    

    public CA_2() {
        employees = new ArrayList<>();
        loadEmployeeDataFromFile("C:\\Users\\HP\\OneDrive\\Documents\\NetBeansProjects\\CA_2\\src\\ca_2\\Applicants_Form.txt");
    }

     private void loadEmployeeDataFromFile(String filename) {
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            reader.readLine(); // Skip header line

            String line = "";
            while ((line = reader.readLine()) != null) {
                // Expecting format:
                // firstName,lastName,gender,email,salary,department,jobTitle,company
                String[] tokens = line.split(",");
                if (tokens.length == 9) {
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

    private static Scanner scanner = new Scanner(System.in);
    private static CA_2 menu;
    public static void main(String[] args) {
        // Create an instance of CA_2 to load employee data and display it
         menu = new CA_2();

        // Read user input for menu options
        
        System.out.println("Do you wish to sort or search?");
        System.out.println("1. SORT");
        System.out.println("2. SEARCH");
        System.out.println("3. ADD RECORD");
        System.out.println("4. EXIT");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("SORT SELECTED");
                menu.SortEmployeesByName();
                menu.Display20Employees();
                break;
            case 2:
                System.out.println("SEARCH SELECTED");
                menu.SearchEmployeesByName();
                break;
            case 3:
                System.out.println("ADD RECORD SELECTED");
                menu.AddRecordsSelected();
                break;
            case 4:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    private void SearchEmployeesByName() {
        scanner.nextLine();
        System.out.println("Enter the name to search:");
        String name = scanner.nextLine();
        for (Employee employee : employees) {
            if (employee.getFullName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(employee);
            }
        }
    }

    private List<String> randomFirstNames = Arrays.asList("John", "Jane", "Michael", "Sarah", "David", "Emily");
    private List<String> randomLastNames = Arrays.asList("Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia");
    
    private void AddRecordsSelected(){
        System.out.println("1. Add Employee");
        System.out.println("2. Generate Random Employee");
        switch (scanner.nextInt()){
            case 1:
                System.out.println("Add Employee");
                menu.AddEmployee();
                break;
            case 2:
                System.out.println("Generate Random Employee");
                Random random = new Random();
                String firstName = randomFirstNames.get(random.nextInt(randomFirstNames.size()));
                String lastName = randomLastNames.get(random.nextInt(randomLastNames.size()));
                Employee randomEmployee = new Employee(firstName, lastName, "male", "", 0.0, DepartmentType.IT_DEVELOPMENT, "Developer", "Random Company");
                employees.add(randomEmployee);
                System.out.println("Random Employee added: " + randomEmployee);
                break;
        }
    }

    private void AddEmployee() {
         scanner.nextLine();
        System.out.println("Please input the Player Name:");
        String name = scanner.nextLine();
        String[] nameParts = name.split(" ");
        String firstName = nameParts[0];
        String lastName = nameParts[1];
        
        System.out.println("Please select from the following Management Staff:");
        System.out.println("1. Manager");
        System.out.println("2. Assistant Manager");
        System.out.println("3. Team Lead");

        int choice = scanner.nextInt();
        String jobTitle = "";
        switch (choice) {
            case 1:
                jobTitle = "Manager";
                break;
            case 2:
                jobTitle = "Assistant Manager";
                break;
            case 3:
                jobTitle = "Team Lead";
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                return;
        }

        

        // Gender selection
        scanner.nextLine();
        System.out.println("Please select gender:");
        String gender = scanner.nextLine();

        // Company selection
        System.out.println("Please enter your compay:");
        String company = scanner.nextLine();

        // Email selection
        System.out.println("Please enter your email:");
        String email = scanner.nextLine();

        // Salary selection
        System.out.println("Please enter your salary:");
        String salary = scanner.nextLine();
        double salaryValue = Double.parseDouble(salary);

        // Department selection
        System.out.println("Please select the Department:");
        System.out.println("1. Customer Service");
        System.out.println("2. Technical Support"); 
        System.out.println("3. HR");
        choice = scanner.nextInt();
        
        DepartmentType department = null;
        switch (choice) {
            case 1:
                department = DepartmentType.CUSTOMER_SERVICE;
                break;
            case 2:
                department = DepartmentType.TECHNICAL_SUPPORT;
                break;
            case 3:
                department = DepartmentType.HR;
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                return;
        }

        //Add to list
        Employee employee = new Employee(firstName, lastName, gender, email, salaryValue, department, jobTitle, company);
        employees.add(employee);
        System.out.println("Employee added successfully." + employee);
    }

    private void SortEmployeesByName() {
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getFullName().compareTo(e2.getFullName());
            }
        });
    }

    public void Display20Employees() {
        for (int i = 0; i < 20; i++) {
            System.out.println(employees.get(i));
        }
    }
}

         

    

