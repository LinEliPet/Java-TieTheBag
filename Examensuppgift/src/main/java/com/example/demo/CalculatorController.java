package com.example.demo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

import org.json.CDL;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Adjust the URL accordingly:
 * Operator can be filled in as "add", "sub" or "multi".
 * num1 and num2 needs to be filled in as an integer.
 * @author linda
 *
 */


@RestController
public class CalculatorController {


	@RequestMapping(
			path = "/calc/{operator}/{num1}/{num2}", // localhost:8080/calc/operator/num1/num2
			method = RequestMethod.GET)
	public int calc(
			@PathVariable String operator,
			@PathVariable int num1,
			@PathVariable int num2) {

	    int result = 0;
	    
		switch (operator) {
		  case "add":
			  result = num1 + num2;
			  System.out.println(num1 + " + " + num2 + " = " + result);
		    break;
		  case "sub":
			  result = num1 - num2;
			  System.out.println(num1 + " - " + num2 + " = " + result);
		    break;
		  case "multi":
			  result = num1 * num2;
			  System.out.println(num1 + " * " + num2 + " = " + result);
			  break;
		  default:
			  System.out.println("Invalid operation.");
		}
		
		return result;
		
	}
	
	
		
}