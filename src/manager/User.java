package manager;

import java.util.ArrayList;
import java.util.List;

public class User {
	//Values
	private String name;
	private String Email;
	private String login;
	private String password;
	private int wallet = 0;
	private List<Product> purchase = new ArrayList<Product>();
	
	//constructor
	User(String new_name, String new_Email, String new_login, String new_password, int new_wallet){
		//check for same user name
		//add restrictions
		name = new_name;
		Email = new_Email;
		login = new_login;
		password = new_password;
		wallet = new_wallet;
	}
	//get values
	int getWallet() {
		return wallet;
	}
	
	//set values
	//methods
	
	void addFounds(int money) {
		//restrictions
		wallet += money;
	}
	
	boolean Purchase(Product product) {
		boolean succes = false;
		if(product.getPrice() <= wallet) {
			if (product.stockAvailable()) {
				product.decreaseStock();
				purchase.add(product);
				wallet -= product.getPrice();
				succes = true;
			}
		}
		return succes;
	}
	
}
