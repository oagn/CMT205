/* Week 3, exercise 3:
- a) Count and output the number of command line arguments
- b) Output the contents of the array args*/

public class ShowArgs{
  public static void main (String[] args){
    // Print the number of arguments
    System.out.println("Number of arguments: "+args.length);

    //Print the content of arguments
    System.out.println("\nArguments: ");
    for (String argument :args){
      System.out.println(argument);
    }
  }
}
