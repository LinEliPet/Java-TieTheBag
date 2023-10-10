package com.example.demo;

import org.springframework.http.MediaType;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RPSController {
	
	private static gameBean game = new gameBean();
	
	@RequestMapping(method = { RequestMethod.POST }, path = "/rps")
	public static String rps(String userInput) {
		
		System.out.println(userInput);
		
		ArrayList<String> compInput = new ArrayList<String>();
		compInput.add("Rock");
		compInput.add("Paper");
		compInput.add("Scissor");
		System.out.println(compInput.get(0));
		
           // generating the index using Math.random()
            int index = (int)(Math.random() * compInput.size());
            String compchoice = compInput.get(index);
            System.out.println("Random Element is :" + compchoice);
        
		
            if(userInput.equals(compchoice) ) {

	   			System.out.println("Tie");

	    		game.addResult("Tie");

	   			return "Tie";

            } else if(  userInput.equals("Rock") && compchoice.equals("Paper") ) {

            	System.out.println("You lose");

    			game.addResult("Loss");

  			    return "You lose";

            	

            } else if(  userInput.equals("Paper") && compchoice.equals("Scissor") ) {

            	System.out.println("You lose");

    			game.addResult("Loss");

  			    return "You lose";

            	

            } else if(  userInput.equals("Scissor") && compchoice.equals("Rock") ) {

            	System.out.println("You lose");

    			game.addResult("Loss");

  			    return "You lose";

            	

            }else {

            	System.out.println("You win");

   				game.addResult("Win");

  				return "You win";

            }
		
		
	}
	
	@RequestMapping(value = "/rps", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String showMatches() { 
		String result = "";
	
		result += game.toJsonString() + ",";
		
		if (result.length() > 2){
			result = result.substring(0, result.length() - 1);
		}
		
		result = "{ \"Games\":  [" + result + "] }";
		
		return result;
		
	}

}