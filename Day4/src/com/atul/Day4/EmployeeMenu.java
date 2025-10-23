package com.atul.Day4;
import java.io.*;
import java.util.*;

public class EmployeeMenu {
    private static ArrayList<Employee> empList = new ArrayList<>();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n--- Employee Management Menu ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Show all Employees");
            System.out.println("4. Show Employees sorted by empID");
            System.out.println("5. Find Employee by Name");
            System.out.println("6. Save Employees to file");
            System.out.println("7. Quit");
            System.out.print("Enter choice: ");
            
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine(); // clear invalid input
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Employee Role: ");
                    String role = sc.nextLine();
                    empList.add(new Employee(id, name, role));
                    break;

                case 2:
                    System.out.print("Enter Employee ID to remove: ");
                    int remId = sc.nextInt();
                    sc.nextLine();
                    boolean removed = empList.removeIf(emp -> emp.getEmpID() == remId);
                    if (removed) {
                        System.out.println("Employee removed.");
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 3:
                    if (empList.isEmpty()) {
                        System.out.println("No employees to show.");
                    } else {
                        empList.forEach(System.out::println);
                    }
                    break;

                case 4:
                    empList.stream()
                           .sorted(Comparator.comparingInt(Employee::getEmpID))
                           .forEach(System.out::println);
                    break;

                case 5:
                    System.out.print("Enter Employee Name to search: ");
                    String findName = sc.nextLine();
                    empList.stream()
                           .filter(e -> e.getEmpName().equalsIgnoreCase(findName))
                           .forEach(System.out::println);
                    break;

                case 6:
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.ser"))) {
                        oos.writeObject(empList);
                        System.out.println("Employees saved to file.");
                    }
                    break;

                case 7:
                    System.out.println("Exiting program.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}