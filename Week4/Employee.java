/* Week 4, exercise 1:
- Create an Employee class with the following fields
    name, idNumber, department, position
- Include the following constructors
    default, one that takes name and idNumber, one that takes values for all variables
- Write appropriate mutator and accessor methods
*/

public class Employee{
    private String name;
    private int idNumber;
    private String department;
    private String position;

    public Employee( ){
        // Default constructor
        name = "";
        idNumber = 0;
        department = "";
        position = "";
    }

    public Employee( String name, int idNumber ){
        // Constructor that takes name and idNumber
        this.name = name;
        this.idNumber = idNumber;
        department = "";
        position = "";
    }

    public Employee( String name, int idNumber, String department, String position ){
        // Constructor taking all instance variable values as input
        this.name = name;
        this.idNumber = idNumber;
        this.department = department;
        this.position = position;
    }

}
