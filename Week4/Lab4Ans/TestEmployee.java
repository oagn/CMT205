// Test program for the Employee class
public class TestEmployee {
   public static void main(String[] args) {
      Employee e1 = new Employee("Matt Morgan", 67485, "COMSC", "Lecturer");
      Employee e2 = new Employee("Tim Marshall", 78495, "BIOSI", "Professor");
      Employee e3 = new Employee("Richard Wright", 43637, "PHYSX", "Reader");
      System.out.print(e1);
      System.out.print(e2);
      System.out.print(e3);
   }
}