package manager;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String name;
	private String Email;
	private String login;
	private String password;
	private List<Product> purchase = new ArrayList<Product>();
	
	//constructor
	User(String new_name, String new_Email, String new_login, String new_password){
		//check for same user name
		name = new_name;
		Email = new_Email;
		login = new_login;
		password = new_password;
	}
	//get values
	//set values
	//methods
}
