/* Week 3, exercise 9:
- Method overloading
- Which methods are valid?
*/

import java.util.Date;

public class foobar{
    // Initial constructor
    public static void foobar( float a, Date b ){
        System.out.println("I am boss");
    }

    // Additional constructor #1 - OK
    /*public static void foobar( Date a, float b ){
        System.out.println("I am a");
    }*/

    // Additional constructor #2 - OK
    /*public static void foobar( float a, String b ){
        System.out.println("I am b");
    }*/

    // Additional constructor #3 - already defined
    /*public static int foobar( float a, Date b ){
        System.out.println("I am c");
        return 1;
    }*/

    // Additional constructor #4 - OK
    /*public static int foobar( float a, Date b, int c ){
        System.out.println("I am d");
        return 1;
    }*/

    // Additional constructor #5 - already defined
    /*public static void foobar( float x, Date y ){
        System.out.println("I am e");
    }*/

    // Additional constructor #6 - already defined
    public void foobar( float x, Date y ){
        System.out.println("I am f");
    }

}
