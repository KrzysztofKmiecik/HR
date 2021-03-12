import java.util.Arrays;

public class Department {

    private String name;
    private Employee[] employees = new Employee[10];

    public Department(String name, Employee[] employees) {
        this.name = name;
        this.employees = employees;
    }

    public Department(String name) {
        this.name = name;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee[] getEmployees() {

        int size = 0;
        size = getNumberOfEmployees();


        Employee[] tempEmployees = new Employee[size];
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {

                for (int j = 0; j < tempEmployees.length; j++) {
                    if (tempEmployees[j] == null) {
                        tempEmployees[j] = employees[i];
                        break;
                    }
                }
            }
        }
        return tempEmployees;
    }

    public int getNumberOfEmployees() {
        int size = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                size++;
            }
        }
        return size;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public boolean isFreeSpaceInCapacity() {


        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                return true;

            }
        }
        return false;
    }


    public void add(Employee employee) {


        if (isFreeSpaceInCapacity()) {
            for (int i = 0; i < employees.length; i++) {

                if (employees[i] == null) {

                    employees[i] = employee;
                    break;
                }
            }
        } else {
            System.out.println("No Free Space to add");
        }

    }

    public Employee getById(int Id) {

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getID() == Id) {
                return employees[i];
            }
        }

        return null;
    }


    public void removeById(int Id) {

        int index;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getID() == Id) {
                index = i;
                employees[index] = null;
                break;
            }
        }

        removeEmpty();


    }


    private void removeEmpty() {

        Employee[] tempEmployees = new Employee[employees.length];

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {

                for (int j = 0; j < tempEmployees.length; j++) {
                    if (tempEmployees[j] == null) {
                        tempEmployees[j] = employees[i];
                        break;
                    }
                }

            }
        }
        employees = tempEmployees;


    }


    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", employeesNo=" + getNumberOfEmployees() +
                '}';
    }

    public double getTotalSalary() {

        double totalSalary = 0;

        for (Employee employee : employees) {
            if (employee != null) {
                totalSalary += employee.getSalary();

            }
        }
        return totalSalary;

    }

    public double getAvgSalary() {
        return (getTotalSalary()/getNumberOfEmployees());
    }
}
