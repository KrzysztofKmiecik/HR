public class HRApp {
    public static void main(String[] args) {
        System.out.println("HRApp");

        Employee employee1 = new Employee(1, "Kowalski", 10.0);
        Employee employee2 = new Employee(2, "Nowak", 20.0);
        Employee employee3 = new Employee(3, "Zielonka", 30.0);


        Employee[] employees1 = new Employee[10];
        employees1[0] = employee1;
        employees1[1] = employee2;
        employees1[2] = employee3;


        for (Employee employee : employees1) {

            if (employee != null) {

                System.out.println(employee);
            }
        }

        //  Department department1 = new Department("Eng", employees1);
        Department department1 = new Department("Eng");

        System.out.println("Department info: "+ department1.toString());

        System.out.println("Departament Name : " + department1.getName());

        department1.add(employee1);
        department1.add(employee2);
        department1.add(employee3);

    department1.removeById(1);
    department1.removeById(2);
    department1.removeById(3);

        System.out.println(department1);

        for (Employee employee : department1.getEmployees()) {
            System.out.println(employee);
        }


        System.out.println("Number of Employees: " + department1.getNumberOfEmployees());

        try {
            System.out.println("Employee z numerem Id  " + department1.getById(1));

        } catch (NullPointerException e) {
            System.out.println("No such a ID");
        }

        System.out.println("Total salary = "+department1.getTotalSalary());
        System.out.println("Avg salary = "+department1.getAvgSalary());
        System.out.println("Department info: "+ department1.toString());

    }
}
