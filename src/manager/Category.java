package manager;
import java.util.ArrayList;
import java.util.List;

public class Category {
	//Values
	private static List<Category> categoryList = new ArrayList<Category>();
	private String name;
	private List<Product> productList= new ArrayList<Product>();
	//maybe related categories
	
	//constructor
	Category(String new_name){
		name = new_name;
		categoryList.add(this);
	}
	
	//get values
	String getName() {
		return name;
	}
	
	static List<Category> getList() {
		return categoryList;
	}
	
	static int getNumberOfCategories() {
		return categoryList.size();
		
	}
	
	int getNumberOfProducts() {
		return productList.size();
	}
	
	List<Product> getProductList(){
		return productList;
	}
	
	
	//set values
	void setName(String new_name) {
		name = new_name;
	}
	
	void addProduct(Product new_product){
		//check for repeated name
		productList.add(new_product);
		
	}
	
	
	//methods
	static Category getCategory(String name) {
		Category search = null;
		for(int i = 0;i < categoryList.size();i++) {
			if(name.equals(categoryList.get(i).getName())){
				search = categoryList.get(i);
				break;
			}
			
		}
		
		return search;
	}
	
	Product getProduct(String name) {
		Product search = null;
		for(int i=0; i < productList.size();i++) {
			if(name.equals(productList.get(i).getName())) {
				search = productList.get(i);
				break;
			}	
		}
		return search;
	}
	

	
	
}
