package manager;
import java.util.ArrayList;
import java.util.List;

public class Product {
	private static List<Product> productList = new ArrayList<Product>();
	private String name;
	private Category productCategory;
	private int stock;
	private int price;
	
	//constructor
	Product(String new_name, String new_category, int new_stock, int new_price){
		//check for another product called the same
		name = new_name;
		stock = new_stock;
		price = new_price;
		productList.add(this);
		productCategory = Category.getCategory(new_category);
		productCategory.addProduct(this);
	}
	
	//get values
	String getName() {
		return name;
	}
	
	//set values
	//methods
	
}
