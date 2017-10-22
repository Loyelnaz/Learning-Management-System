package testing;
import database.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class StudentLogin {

	@Test
	public void test1() {
		DBLogin dbl = new DBLogin();
		
		// Check for the correct user
		int result = dbl.isLogged("mohit", "mohit", "user_table", "student");
		assertEquals(1, result);
	}
	
	@Test
	public void test2() {
		DBLogin dbl = new DBLogin();
		
		// Check for the user does not exist condition
		int result = dbl.isLogged("mohit123", "mohit", "user_table", "student");
		assertEquals(-1, result);
	}

}
