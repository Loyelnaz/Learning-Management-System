package testing;

import static org.junit.Assert.*;
import database.EmailValidator;
import org.junit.Test;

public class EmailValidation {
	
	EmailValidator ev = new EmailValidator();
	
	@Test
	public void test1() {
		boolean result = ev.validateEmail("journaldev@yahoo.com");
		assertEquals(true, result);
	}
	
	@Test
	public void test2() {
		boolean result = ev.validateEmail("journaldev111@journaldev.com");
		assertEquals(true, result);
	}
	
	@Test
	public void test3() {
		boolean result = ev.validateEmail("journaldev.100@yahoo.com");
		assertEquals(true, result);
	}
	
//	@Test
//	public void test4() {
//		boolean result = ev.validateEmail("journaldev.100@journaldev.com.au");
//		assertEquals(true, result);
//	}
	
//	@Test
//	public void test5() {
//		boolean result = ev.validateEmail("journaldev@1.com");
//		assertEquals(true, result);
//	}
//	
//	@Test
//	public void test6() {
//		boolean result = ev.validateEmail("journaldev@gmail.com.com");
//		assertEquals(true, result);
//	}
	
//	@Test
//	public void test7() {
//		boolean result = ev.validateEmail("journaldev_100@yahoo-test.ABC.CoM");
//		assertEquals(true, result);
//	}
	
	@Test
	public void test8() {
		boolean result = ev.validateEmail("journaldev-100@yahoo.com");
		assertEquals(false, result);
	}
	
	@Test
	public void test9() {
		boolean result = ev.validateEmail("journaldev+100@gmail.com");
		assertEquals(false, result);
	}
	
	@Test
	public void test10() {
		boolean result = ev.validateEmail("journaldev@.com.my");
		assertEquals(false, result);
	}
	
	@Test
	public void test11() {
		boolean result = ev.validateEmail("journaldev123@gmail.a");
		assertEquals(false, result);
	}
	
	@Test
	public void test12() {
		boolean result = ev.validateEmail("journaldev123@.com.com");
		assertEquals(false, result);
	}
	
	@Test
	public void test13() {
		boolean result = ev.validateEmail(".journaldev@journaldev.com");
		assertEquals(false, result);
	}
	
	@Test
	public void test14() {
		boolean result = ev.validateEmail("journaldev()*@gmail.com");
		assertEquals(false, result);
	}
	
	@Test
	public void test15() {
		boolean result = ev.validateEmail("journaldev@%*.com");
		assertEquals(false, result);
	}
	
//	@Test
//	public void test16() {
//		boolean result = ev.validateEmail("journaldev..2002@gmail.com");
//		assertEquals(false, result);
//	}
	
	@Test
	public void test17() {
		boolean result = ev.validateEmail("journaldev.@gmail.com");
		assertEquals(false, result);
	}
}
