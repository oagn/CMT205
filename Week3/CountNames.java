/* Week 3, exercise 2:
- a) Count the number of times an actor's name is Jones.
- b) Modify to count all versions of Jones, also upper case. */

public class CountNames {
	public static void main( String args[] ) {

        String[] names = {"Tommy Lee Jones", "William Hurt", "Nicole Kidman",
            "Catherine Zeta-Jones", "JAMES EARL JONES", "Tom Hardy",
            "Judi Dench", "Sean Bean", "Carey Mulligan", "Toby Jones" };
        int count1 = 0;
				int count2 = 0;
				for (String name :names){
					if (name.contains("Jones")){
						count1++;
					}
					if (name.toUpperCase().contains("JONES")){
						count2++;
					}
				}
				System.out.println(count1);
				System.out.println(count2);
	}
}
