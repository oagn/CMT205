// The Employee class definition
public class Employee {
   // Private member variables
   String name;
   int idNumber;
   String department;
   String position;

   // Constructors
   public Employee(){
      name = "";
      idNumber = 0;
      department = "";
      position = "";
   }

   public Employee(String name, int idNumber){
      this.name = name;
      this.idNumber = idNumber;
      department = "";
      position = "";
   }

   public Employee(String name, int idNumber, String department, String position){
      this.name = name;
      this.idNumber = idNumber;
      this.department = department;
      this.position = position;
   }
 
    // Public getter and setter for private variables
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getIdnumber() {
      return idNumber;
   }

   public String getDepartment() {
      return department;
   }

   public void setDepartment(String department) {
      this.department = department;
   }

   public String getPosition() {
      return position;
   }

   public void setPosition(String position) {
      this.position = position;
   }

   public String toString() {
      return getName() + "\t" + getIdnumber() + "\t" + getDepartment() + "\t" + getPosition() + "\n";
   }
 
}