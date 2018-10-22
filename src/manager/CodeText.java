package manager;
import static org.junit.Assert.*;
import org.junit.Test;
public class CodeText {

	@Test
	public void testProgram() {
		//check for correct construction of product
		Category testCategory = new Category("testing");
		
		assertEquals(testCategory.getName(),"testing");
		
		//check for correct storage of Category on Product
		Product p1 = new Product("test1","testing",10,10);
		
		assertEquals(p1.getCategory(),testCategory.getName());
		
		//check for the password encryption to be stable (always same output)
		assertEquals(User.encriptText("qwerty123"),User.encriptText("qwerty123"));
		
	}
}