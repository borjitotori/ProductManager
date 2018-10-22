# Product Manager
## Description
This program allows for the storage of different products under the index of categories.

every user can have a personal profile with name, credentials, wallet and list of bought products.

## Classes

**Class Main**

The Main Class contains the functions required to get information from the user, prints to console the different list of items (Products, Categories).

Also contains the interface menu structure and the sub category menus.

And for this test the declarations of the categories the products and some default users.

**Class Category**

Contains basic Category information, a list of the products contains in said class and a global static list of categories which contains all the categories created.

also contains a couple of methods for getting a category from the global list and get a product from a specific category.

**Class Product**

Contains Product information, name, category, stock and price a list of products which contain all products created.

and some methods to manipulate the products like A boolean to check if there is stock available and functions decrease and increase the stock.

**Class User**

Contains user information, name, Email, password, wallet. List of products that the user has bought and also a list of all the users created. 
Methods for manipulating information of the user like purchasing products and adding founds.

The Password is not saved in plain text is encrypted using a function that doesn't do much but is better than nothing, before storing the password is encrypted using this function.

```
static private String encriptText(String text){
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

```
the code will convert a password  `encriptText("qwerty")` to `"1753C"` another string. And when is the time to verify the password at the time of login the string is input by the user and compare to the stored value, the password is never stored in the program.

## Development

In the development of the project most difficulties arrive from the fact that I didn't have access to a GUI so I had to manage to make a somewhat usable menu.

in respects to the hours expended is hard to say because of the nature of how I code this program, I had it open in the background and when I got some motivations I would write some lines, if I had to estimate a time frame I would say that it took around 4h scatter over a couple weeks.