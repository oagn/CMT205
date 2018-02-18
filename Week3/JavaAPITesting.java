/* Week 3, exercise 8:
Use Java API to identify relevant fields/methods to output:
- sine of 15
- 63^(2.5)
- square root of 2498
- random number [0,1)
- pi
*/

public class JavaAPITesting{
    public static void main(String[] args){
        // Sine of 15
        double angle = Math.toRadians(15f);
        double sinus = Math.sin(angle);
        System.out.println("The sine of 15 is: "+ sinus);

        // 63^(2.5)
        double exponent = Math.pow(63f,2.5);
        System.out.println("63^(2.5) is: "+ exponent);

        // square root of 2498
        double squart = Math.sqrt(2498);
        System.out.println("The square root of 2498 is: "+ squart);

        // raddom number [0,1)
        double randy = Math.random();
        System.out.println("Here is a random number between 0 and 1: "+ randy);

        // pi
        double thePi = Math.PI;
        System.out.println("Pi is:" + thePi);
    }
}
