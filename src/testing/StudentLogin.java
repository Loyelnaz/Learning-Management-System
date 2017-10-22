package testing;
import database.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class StudentLogin {

	@Test
	public void test1() {
		DBLogin dbl = new DBLogin();
		
		// Check for 'correct user'
		int result = dbl.isLogged("mohit", "mohit", "user_table", "student");
		assertEquals(1, result);
	}
	
	@Test
	public void test2() {
		DBLogin dbl = new DBLogin();
		
		// Check for 'user does not exist' condition
		int result = dbl.isLogged("mohit123", "mohit", "user_table", "student");
		assertEquals(-1, result);
	}
	
	@Test
	public void test3() {
		DBLogin dbl = new DBLogin();
		
		// Check for 'password incorrect' condition
		int result = dbl.isLogged("mohit", "mohit123", "user_table", "student");
		assertEquals(0, result);
	}
	
}
