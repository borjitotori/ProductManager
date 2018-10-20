package manager;

import java.util.Scanner;

public class Main {
	// Input Functions

	
	static int askNumber() {
		Scanner scM;
		int inputValue = 0;
		boolean exit = false;
		while (true) {
			System.out.print("Insert Number: ");
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
			scM.close();
		}

		return inputValue;
	}
	
	static String askString() {
		String input;
		Scanner scM = new Scanner(System.in);
		input = scM.nextLine();
		
		return input;
	}
	
	@SuppressWarnings("resource")
	static void waitForInput() {
		System.out.println("Press Any Key To Continue...");
		new java.util.Scanner(System.in).nextLine();
	}
	
	//Manager functions
	
	static void buyProduct(User id, Product actualProduct) {
		int input;
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
				buyProduct(id,actualProduct);
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
			actualProduct = Product.getList().get(input - 1);
			printProductDetails(actualProduct);

			//buy the product
			buyProduct(id,actualProduct);
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
		
		
		new Product("Ready player one","Book",100,20);
		new Product("Hunger Games","Book",80,25);
		new Product("El tipler","Book",500,30);
		
		new Product("the disappearance","Video",40,50);
		new Product("Iron Man","Video",26,30);
		new Product("V for vendetta","Video", 13, 40);
			
		new Product("Lamp","Home",30,35);
		new Product("Shower","Home",60,20);         
		new Product("Door","Home",10,30);
		
		new Product("The now now","Music",30,15);
		new Product("Blurry face","Music",12,15);
		new Product("Joytime II", "Music",14,15);
		
		
		User user1 = new User("Santiago","santiago@gmail.es","qwerty");
		User user2 = new User("Liam","Liam@gmail.es","123456");
		User user3 = new User("James","James@gmail.es","abc123");
		User user4 = new User("Lucas","Lucas@gmail.es","passw0rd");

		user1.addFounds(100);
		user2.addFounds(25);
		user3.addFounds(40);
		user4.addFounds(75);
		
		User logUser = null;
		
		while(true) {
			boolean exit = false;
			String user;
			String pass;
			System.out.print("Product Manger \nLogin \nUsername : ");
			user = askString();
			System.out.println("Pass : ");
			pass = askString();
			
			if(User.getUser(user,pass) != null) {
				exit=true;
				logUser = User.getUser(user,pass);
			}
			if(exit) {
				break;
			}
			
		}
		
		
		while(true) {			
			boolean exit = false;
			int input;
			System.out.println("Menu \n1: Category List \n2: Show All Products \n3: Profile \n4: Log Out");
			input = askNumber();
			
			switch(input) {
			case 1:
				//Category List
				subMenuCategoryList(logUser);
				break;
				
			case 2:
				subMenuAllProducts(logUser);
				break;
				
			case 3:
				subMenuProfile(logUser);
				break;
				
			case 4:
				exit = true;
				break;
			}
			

			if(exit) {
				break;
			}
			
			waitForInput();
		}
	}
	// To Add: password Manager; the dollars; some file manager; test functions
}
