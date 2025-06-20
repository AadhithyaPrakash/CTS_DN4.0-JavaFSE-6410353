class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int id, String name, String pos, double sal) {
        this.employeeId = id;
        this.name = name;
        this.position = pos;
        this.salary = sal;
    }
}

public class EmployeeManager {
    Employee[] employees = new Employee[100];
    int count = 0;

    void addEmployee(Employee e) {
        if (count < employees.length) {
            employees[count++] = e;
        }
    }

    Employee searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) return employees[i];
        }
        return null;
    }

    void deleteEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                break;
            }
        }
    }

    void displayEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println("ID: " + employees[i].employeeId + ", Name: " + employees[i].name +
                    ", Position: " + employees[i].position + ", Salary: ₹" + employees[i].salary);
        }
    }

    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        manager.addEmployee(new Employee(101, "Asha", "Developer", 50000));
        manager.addEmployee(new Employee(102, "Bala", "Tester", 40000));
        manager.displayEmployees();

        System.out.println("\nAfter deleting employee with ID 101:");
        manager.deleteEmployee(101);
        manager.displayEmployees();
    }
}

