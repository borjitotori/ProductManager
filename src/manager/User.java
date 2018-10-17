package manager;

import java.util.ArrayList;
import java.util.List;

public class User {
	//Values
	private String name;
	private String Email;
	private String password;
	private int wallet = 0;
	private List<Product> purchase = new ArrayList<Product>();
	
	//constructor
	User(String new_name, String new_Email, String new_password, int new_wallet){
		//check for same user name
		//add restrictions
		name = new_name;
		Email = new_Email;
		password = new_password;
		wallet = new_wallet;
	}
	//get values
	String getName() {
		return name;
	}
	
	String getEmail() {
		return Email;
	}
	
	int getWallet() {
		return wallet;
	}
	
	List<Product> getPurchaseList(){
		return purchase;
	}
	
	/*
	Product getProductOfList(int i) {
		Product aux= null;
		if(0 < i && i < getListSize()) {
			aux = purchase.get(i);
		}
		return aux;
	}
	*/
	int getListSize() {
		return purchase.size();
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
