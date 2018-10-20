package manager;

import java.util.ArrayList;
import java.util.List;

public class User {
	//Values
	private static  List<User> UserList = new ArrayList<User>();
	private String name;
	private String Email;
	private String password;
	private int wallet = 0;
	private List<Product> purchase = new ArrayList<Product>();
	
	//constructor
	User(String new_name, String new_Email, String new_password){
		//check for same user name
		//add restrictions
		name = new_name;
		Email = new_Email;
		password = encript(new_password);
		UserList.add(this);
		
		System.out.println(password);
	}
	//get values
	static User getUser(String in_Email, String in_Password) {
		User aux = null;
		for (int i=0;i<UserList.size();i++) {
			if(UserList.get(i).getEmail().equals(in_Email)) {
				if(UserList.get(i).getPassword().equals(encript(in_Password))){
					aux = UserList.get(i);
					break;
				}
				
			}
		}
		return aux;
	}
	
	String getName() {
		return name;
	}
	
	String getEmail() {
		return Email;
	}
	
	protected String getPassword() {
		return password;
	}
	
	int getWallet() {
		return wallet;
	}
	
	List<Product> getPurchaseList(){
		return purchase;
	}
	
	int getListSize() {
		return purchase.size();
	}
	
	
	//set values
	
	//methods
	
	static private String encript(String text){
		int aux = 0;
		char[] rLetters = {'N','C','Y','E','C','L','X','N'};
		int letterSelect = 0;
		char[] ch = text.toCharArray();
		for (int i = 0; i < text.length();i++) {
			aux += ch[i] * i + 1 + i;
		}
		letterSelect = aux % 8;
		return (Integer.toString(aux)+rLetters[letterSelect]);
	}
	
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
