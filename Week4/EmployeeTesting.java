public class EmployeeTesting{

    public static void main( String[] args ){
        // Creating the first employee, emp1
        System.out.println("Using default constructor to create amployee");
        Employee emp1 = new Employee();
        System.out.println("Prior to values set for emp1: \n" + emp1 + "\n");

        // Setting variable values for emp1 using mutators
        emp1.setName("Matt Morgan");
        emp1.setIdNumber(67485);
        emp1.setDepartment("COMSC");
        emp1.setPosition("Lecturer");
        System.out.println("Post values set for emp1: \n" + emp1 + "\n");

        // Creating the second employee, emp2
        System.out.println("Using second constructor to create amployee");
        Employee emp2 = new Employee("Tim Marshall", 78495);
        System.out.println("Prior to values set for emp2: \n" + emp2 + "\n");

        // Setting variable values for emp2 using mutators
        emp2.setDepartment("BIOSI");
        emp2.setPosition("Professor");
        System.out.println("Post values set for emp2: \n" + emp2 + "\n");

        // Creating the third employee, emp3
        System.out.println("Using third constructor to create amployee");
        Employee emp3 = new Employee("Richard Wright", 78495, "PHYSX", "Reader");
        System.out.println("emp3: \n" + emp3 + "\n");

    }
}
