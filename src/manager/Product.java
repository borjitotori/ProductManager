package manager;
import java.util.ArrayList;
import java.util.List;

public class Product {
	//Values
	private static List<Product> productList = new ArrayList<Product>();
	private String name;
	private Category productCategory;
	private int stock = 0;
	private int price = 0;
	
	//constructor
	Product(String new_name, String new_category, int new_stock, int new_price){
		//check for another product called the same
		name = new_name;
		stock = new_stock;
		price = new_price;
		productList.add(this);
		productCategory = Category.getCategory(new_category);
		if(productCategory != null) {
			productCategory.addProduct(this);
		}
	}
	
	//get values
	String getName() {
		return name;
	}
	
	int getStock() {
		return stock;
	}
	
	int getPrice() {
		return price;
	}
	
	String getCategory() {
		return productCategory.getName();
	}
	
	static List<Product> getList(){
		return productList;
	}
	
	static int getProductSize() {
		return productList.size();
	}
	
	
	//set values
	void setNewPrice(int new_price) {
		price = new_price;
	}
	
	//methods
	boolean stockAvailable() {
		return (stock > 0);
	}
	
	boolean decreaseStock() {
		boolean value = false;
		if (stockAvailable()) {
			stock--;
			value = true;
		}
		return value;
	}
}
