package practice_question;
import java.util.*;
import java.io.*;

class Employee {
    String empName;
    int empID;
    String empRole;

    // No-argument constructor
    Employee() {
        empName = "Unknown";
        empID = 0;
        empRole = "Not Assigned";
    }

    // Constructor with empID and empName
    Employee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.empRole = "Employee"; 
    }

    // Constructor with empID, empName, empRole
    Employee(int empID, String empName, String empRole) {
        this.empID = empID;
        this.empName = empName;
        this.empRole = empRole;
    }

    // toString 
    public String toString() {
        return empID + " - " + empName + " (" + empRole + ")";
    }
}

public class EmployeeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> list = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n--- Employee Menu ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Show All Employees");
            System.out.println("4. Show Employees in Sorted Order (by ID)");
            System.out.println("5. Find Employee by Name");
            System.out.println("6. Save Employees to File");
            System.out.println("7. Quit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1 -> {
                    System.out.println("1. Default");
                    System.out.println("2. With ID and Name");
                    System.out.println("3. With ID, Name, and Role");
                    System.out.print("Enter option: ");
                    int op = sc.nextInt();
                    sc.nextLine();

                    Employee e = null;
                    if (op == 1) {
                        e = new Employee();
                    } else if (op == 2) {
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        e = new Employee(id, name);
                    } else if (op == 3) {
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Role: ");
                        String role = sc.nextLine();
                        e = new Employee(id, name, role);
                    } else {
                        System.out.println("Invalid option!");
                    }

                    if (e != null) {
                        list.add(e);
                        System.out.println("Employee added!");
                    }
                }

                case 2 -> {
                    System.out.print("Enter Employee ID to remove: ");
                    int id = sc.nextInt();
                    boolean removed = false;
                    for (Employee e : list) {
                        if (e.empID == id) {
                            list.remove(e);
                            removed = true;
                            break;
                        }
                    }
                    if (removed)
                        System.out.println("Employee removed!");
                    else
                        System.out.println("Employee not found!");
                }

                case 3 -> {
                    if (list.isEmpty())
                        System.out.println("No employees found!");
                    else {
                        System.out.println("\n--- All Employees ---");
                        for (Employee e : list)
                            System.out.println(e);
                    }
                }

                case 4 -> {
                    if (list.isEmpty())
                        System.out.println("No employees to sort!");
                    else {
                        list.sort(Comparator.comparingInt(e -> e.empID));
                        System.out.println("\n--- Sorted Employees ---");
                        for (Employee e : list)
                            System.out.println(e);
                    }
                }

                case 5 -> {
                    System.out.print("Enter name to search: ");
                    String name = sc.nextLine();
                    boolean found = false;
                    for (Employee e : list) {
                        if (e.empName.equalsIgnoreCase(name)) {
                            System.out.println("Found: " + e);
                            found = true;
                        }
                    }
                    if (!found)
                        System.out.println("No employee found!");
                }

                case 6 -> {
                    saveToFile(list);
                }

                case 7 -> System.out.println("Exiting program...");

                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 7);

        sc.close();
    }

    // save employees into a file
    public static void saveToFile(ArrayList<Employee> list) {
        try {
            FileWriter fw = new FileWriter("employees.txt");
            for (Employee e : list) {
                fw.write(e.empID + "," + e.empName + "," + e.empRole + "\n");
            }
            fw.close();
            System.out.println("Employees saved to file 'employees.txt' successfully!");
        } catch (IOException e) {
            System.out.println("Error while saving file: " + e.getMessage());
        }
    }
}
