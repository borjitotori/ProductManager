package manager;

import java.util.Scanner;

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
	
	static void printProduct(Product product) {
		String p = product.getCategory()+": "+product.getName()+" Price:"+product.getPrice()+"$ Stock:"+product.getStock();
		System.out.println(p);
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
		
		
		while(true) {
			boolean exit = false;
			Scanner sc;
			System.out.println("Menu \n1: Category List \n2: Browse Product \n3: Show All Products \n4: Log Out");
			sc = new Scanner(System.in);
			
			switch(sc.nextLine()) {
			case "1":
				sc = new Scanner(System.in);
				printCategories();
				System.out.println("E: Exit");	
					if(!(sc.nextLine().equals("E")||sc.nextLine().equals("e"))) {
						//get the exception if the number is not valid or gets out of the length of the products
						//fix for some reason this dosent work
							int i = Integer.valueOf(sc.nextLine()) - 1;
							printProducts(Category.getList().get(i));
					}
				
				break;
			case "2":
				break;
				
			case "3":
				break;
				
			case "4":
				exit = true;
				break;
			}
			
			if(exit) {
				break;
			}
		}
		
		
	}
	/*Fixes
	 * when you set a wrong category it fails
	 * 
	 * */
}
