package manager;

import java.util.Scanner;

public class Main {
	// Input Functions

	@SuppressWarnings("resource")
	static int askNumber() {
		Scanner scM;
		int inputValue = 0;
		boolean exit = false;
		while (true) {
			System.out.print("Insert a Number: ");
			scM = new Scanner(System.in);
			String input = scM.nextLine();
			
			try {
				inputValue = Integer.valueOf(input);
				System.out.println();
				exit = true;
				
			}catch(NumberFormatException e) {
				System.out.println("Please Insert An integer Value");
			}
			
			if(exit) {
				break;
			}
		}

		return inputValue;
	}
	
	@SuppressWarnings("resource")
	static void waitForInput() {
		System.out.println("Press Any Key To Continue...");
		new java.util.Scanner(System.in).nextLine();
	}
	
	//print Functions
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
	
	static void printProductDetails(Product product) {
		String p = product.getCategory()+": "+product.getName()+" Price:"+product.getPrice()+"$ Stock:"+product.getStock();
		System.out.println(p);
	}
	
	// Sub Menu Functions
	static void subMenuCategoryList(User id) {
		int input;
		int nCategories = Category.getNumberOfCategories();
		int nProducts;
		Category actualCategory;
		Product actualProduct;
		
		//Select the category
		printCategories();
		System.out.println(nCategories + 1 +": Exit"); 		
		input = askNumber();
		
		if(input <= nCategories && input > 0) {
			actualCategory = Category.getList().get(input-1);
			nProducts = actualCategory.getNumberOfProducts();
			
			//Select the product
			printProducts(actualCategory);
			System.out.println(actualCategory.getNumberOfProducts()+1 + ": Exit");
			input = askNumber();
			
			if(input <= nProducts && input > 0) {
				actualProduct = actualCategory.getProductList().get(input-1);
				printProductDetails(actualProduct);
				//buy the product
				System.out.println("Do you wish to buy the product? Yes:1 No:0");
				input = askNumber();
				if(input == 1 ) {
					if(id.Purchase(actualProduct)) {
						System.out.println("Product Purchase successfully");
					}else {
						System.out.println("Product Purchase Faliaure");
					}
				}
			}
		}
	}
	
	static void subMenuAllProducts(User id) {
		Product actualProduct;
		int input;
		int nProducts = Product.getProductSize();
		
		printAllProducts();
		System.out.println(nProducts + 1 +": Exit");
		input = askNumber();
		
		if(0 < input && input <= nProducts) {
			actualProduct = Product.getList().get(input);
			printProductDetails(actualProduct);
		
			//buy the product
			System.out.println("Do you wish to buy the product? Yes:1 No:0");
			input = askNumber();
			if(input == 1 ) {
				if(id.Purchase(actualProduct)) {
					System.out.println("Product Purchase successfully");
				}else {
					System.out.println("Product Purchase Faliaure");
				}
			}
		}
	}
	
 	static void subMenuCompareProducts() {
	}
	
 	static void subMenuProfile(User id) {
 		System.out.println("Name: "+ id.getName() + " Email: "+id.getEmail() + " Wallet: "+id.getWallet()+"€");
 		System.out.println("Purchased Products");
 		for (int i = 0; i< id.getListSize();i++) {
 			if(id.getPurchaseList().get(i) != null) {
 				System.out.println(id.getPurchaseList().get(i).getCategory() + ": "+id.getPurchaseList().get(i).getName());
 			}
 			System.out.println();
 		}
 	}
 	
 	//main
	@SuppressWarnings("unused")
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
		
		
		User test = new User("Santiago","santiago@gmail.es","qwerty",100);
		
		
		while(true) {			
			boolean exit = false;
			int input;
			System.out.println("Menu \n1: Category List \n2: Show All Products \n3: Compare Products \n4: Profile \n5: Log Out");
			input = askNumber();
			
			switch(input) {
			case 1:
				//Category List
				subMenuCategoryList(test);
				break;
				
			case 2:
				subMenuAllProducts(test);
				break;
				
			case 3:
				subMenuCompareProducts();
				break;
				
			case 4:
				subMenuProfile(test);
				break;
				
			case 5:
				exit = true;
				break;
			}
			

			if(exit) {
				break;
			}
			
			waitForInput();
		}
	}
	// To Fix: don't return Lists;
	// To Add: password Manager; the dollars; some file manager; test functions
}
