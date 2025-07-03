package employeedatabase;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Employee\n2. View Employees\n3. Update Employee\n4. Delete Employee\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter position: ");
                    String position = sc.nextLine();
                    System.out.print("Enter salary: ");
                    double salary = sc.nextDouble();
                    dao.addEmployee(new Employee(name, position, salary));
                    break;

                case 2:
                    List<Employee> employees = dao.getAllEmployees();
                    for (Employee e : employees) {
                        System.out.println(e);
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter new name: ");
                    name = sc.nextLine();
                    System.out.print("Enter new position: ");
                    position = sc.nextLine();
                    System.out.print("Enter new salary: ");
                    salary = sc.nextDouble();
                    dao.updateEmployee(id, name, position, salary);
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    id = sc.nextInt();
                    dao.deleteEmployee(id);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

