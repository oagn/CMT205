/* Week 3, exercise 1:
- Create an array cotaining integers 3,5,7,9,10.
- Use a for loop to calculate and print their sum. */

public class ArraySumming{
  public static void main (String[] args){
    int[] forSumming = {3,5,7,9,10};
    int theSum = 0;
    for(int number :forSumming){
      theSum += number;
    }
    System.out.println(theSum);  
  }
}
