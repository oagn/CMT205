import javafx.application.Application;
import javafx.stage.Stage;

import java.awt.Dialog;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javafx.stage.Stage;
import javafx.scene.control.TextInputDialog;
import java.util.Optional;

public class Login{
	
	private static Map<String, String> users; // map for user accounts
	
	
	// read username, password pairs from file
	private static void getAllUsers(String path) {
		users = new HashMap<String, String>();
		String line = "";
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(path));
			while ((line = reader.readLine()) != null)
			{
				String[] parts = line.split(" ", 2);
	        
	            String key = parts[0];
	            String value = parts[1];
	            users.put(key, value);
			}
			for (String key : users.keySet())
		    {
		        System.out.println(key + ":" + users.get(key));
		    }
		    reader.close();
		} 
		catch (IOException e) {
	            System.out.println("ignoring line: " + line);
	    }
	}
	
	
    // check if the username, password exists in the map
    private static void check_user(String username, String password)
    {
        if (!users.containsKey(username))
            System.out.println("User " + username + " does not exist");
        else if (users.get(username).equals(password))
            System.out.println("User " + username + " logged in");
        else 
            System.out.println("User " + username + " exists but the password is wrong.");
    }
    
    // create GUI to get username and password
    
        
        
    @Override
    public static void main(String [] args)  {
    		Application.launch(args);
     // add username, password pairs to the map
        getAllUsers("users.txt");
        
        // print the map
        System.out.println(users);
    }
}


