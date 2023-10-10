package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class CalculatorControllerTest {
	private static CalculatorController calculator;
	private static String baseUrl = "http://localhost:8080";

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	calculator = new CalculatorController();
	}

	
	@Test
	@Timeout(value = 1, unit = TimeUnit.MILLISECONDS)
	void testCalc() {
		CalculatorController calculator = new CalculatorController();
		
		String operator = "add";
		int result = calculator.calc(operator, 1, 2);
		assertEquals(3, result);
		
		operator = "sub";
		result = calculator.calc(operator, 1, 2);
		assertEquals(-1, result);
		
		operator = "multi";
		result = calculator.calc(operator, 2, 2);
		assertEquals(4, result);
		
		operator = "hej";
		result = calculator.calc(operator, 2, 2);
		assertEquals(0, result);
		
		operator = "add";
		result = calculator.calc(operator, -2, -2);
		assertEquals(-4, result);
		
	}
	
	@Test
	void testWebService() {
		String url = baseUrl;
		try {
			String actual = httpHelper.UrlResponse("http://localhost:8080/calc/add/1/2", "get", null);
			assertEquals("3", actual);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}

	}

}
