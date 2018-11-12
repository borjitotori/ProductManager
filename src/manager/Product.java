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
	Product(String new_name, String new_category, int new_stock, int new_price) throws MyException{
		
		//set the name
		name = new_name;

		//set the stock and price
		this.setNewStock(new_stock);
		
		this.setNewPrice(new_price);

		//add the product to the list of all products
		productList.add(this);
		
		//set the category of the product
		Category auxCategory = null;
		auxCategory = Category.getCategory(new_category);
		
		if(auxCategory == null) {
			throw new MyException("Category doesn't exist");
		}else {
			productCategory = Category.getCategory(new_category);
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
		if (new_price >= 0) {
			price = new_price;
		}else {
			price = 0;
		}
	}
	
	void setNewStock(int new_Stock) {
		if (new_Stock >= 0) {
			stock = new_Stock;
		}else {
			stock = 0;
		}
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
