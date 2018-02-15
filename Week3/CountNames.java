/* Week 3, exercise 2:
- a) Count the number of times an actor's name is Jones.
- b) Modify to count all versions of Jones, also upper case. */

public class CountNames {
	public static void main( String args[] ) {

        String[] names = {"Tommy Lee Jones", "William Hurt", "Nicole Kidman",
            "Catherine Zeta-Jones", "JAMES EARL JONES", "Tom Hardy",
            "Judi Dench", "Sean Bean", "Carey Mulligan", "Toby Jones" };
        int count = 0;
				for (String name :names){
					if (name.contains("Jones")){
						count++;
					}
				}
				System.out.println(count);
	}
}
