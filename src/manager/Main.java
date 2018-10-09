package manager;

public class Main {
	// functions for printing
	
	static void printCategories() {	
		for(int i = 0; i < Category.getList().size();i++) {
			System.out.println(i+1 +": "+Category.getList().get(i).getName());
		}
	}
	
	static void printAllProducts() {
		for(int i = 0; i < Product.getList().size();i++) {
			System.out.println(i+1 + ": "+Product.getList().get(i).getName());
		}
	}
	
	static void printProducts(Category category) {
		for (int i = 0; i < category.getProductList().size();i++) {
			System.out.println(i+1 + ": " + category.getProductList().get(i).getName());
		}
	}
	
	
	public static void main(String[] args) {
		
		Category book = new Category("Book");
		Category video = new Category("Video");
		Category home = new Category("Home");
		Category music = new Category("Music");
		
		
		Product book1 = new Product("Ready player one","Book",100,20);
		Product book2 = new Product("Hunger Games","Book",80,25);
		Product book3 = new Product("El tipler","Book",500,30);
		
		Product video1 = new Product("the disappearance","Video",40,50);
		Product video2 = new Product("Iron Man","Video",26,30);
		Product video3 = new Product("V for vendetta","Video", 13, 40);
		
		
		Product home1 = new Product("Lamp","Home",30,35);
		Product home2 = new Product("Shower","Home",60,20);
		Product home3 = new Product("Door","Home",10,30);
		
		Product music1 = new Product("The now now","Music",30,15);
		Product music2 = new Product("Blurry face","Music",12,15);
		Product music3 = new Product("Joytime II", "Music",14,15);
		
		
		User test = new User("Santiago","santiago@gmail.es","Sads","qwerty",200);
		
		System.out.println(video.getProductList().get(0).getName());
		printProducts(video);
		//print categories
		//print a product list
		//print product Details
		//buy a product
		
		
		
	}
	/*Fixes
	 * when you set a wrong category it fails
	 * 
	 * */
}
