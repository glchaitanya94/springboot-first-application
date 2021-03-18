package com.springboot.web.springboot.first.application.appTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;

import com.springboot.web.springboot.first.application.web.service.LoginService;

/* task
 * all class level methods must be static
 * read the documentation
 * */

public class LoginTest {
	//@beforeAll is an annotation and it is an interface
	//@beforeAll is a static method
	@BeforeAll
	static void beforeAll() {
		System.out.println("BeforeAll");		
	}
	
	//afterall is static method
	@AfterAll
	static void afterAll() {
		System.out.println("AfterAll");
	}
	
	@BeforeEach
	void beforeEach() {
		System.out.println("Before each test case");
	}
	
	@AfterEach
	void afterEach() {
		System.out.println("After each test case");
	}
	
	@Test
	public void passwordTest(){
		//check for result is 6
		//assertEquals(2, calculator.add(1, 1));
		System.out.println("test1 is executing");
		int result = 2;
		assertEquals(2, result);
		/*
		 * assertTrue(true); assertFalse(false);
		 */
		// two arrays are equal
		//assertArrayEquals(2, actuals);
	}

	@Test
	void test() {
		/* fail("Not yet implemented"); */
		//Absense of failure is success
		System.out.println("test2 is executed");
	}
}

/*
 * class DataServiceStub implements LoginService{
 * 
 * }
 */
