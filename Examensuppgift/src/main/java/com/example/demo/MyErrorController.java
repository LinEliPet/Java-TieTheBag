package com.example.demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyErrorController implements ErrorController {
	
	    @RequestMapping("/error")

	    public String handleError() {

	        //do something like logging
//	    	System.out.println("felmeddelanden och sånt");

	        return "error";

	    }

	}
	
//	@RequestMapping("/error")
//	  @ResponseBody
//	  public String handleError(HttpServletRequest request) {
//		System.out.println("detta är ett felmeddelande");
//
//	      Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
//
//	      Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
//
//	      return String.format("<html><body><h2>Error Page</h2><div>Status code: <b>%s</b></div>"
//
//	                      + "<div>Exception Message: <b>%s</b></div><body></html>",
//
//	              statusCode, exception==null? "N/A": exception.getMessage());
//
//	  }
//
//	 
//
//	  public String getErrorPath() {
//
//	      return "/error";
//
//	  }

//    @RequestMapping("/error")
//    public String handleError(HttpServletRequest request) {
//        // get error status
//        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
//
//        // TODO: log error details here
//
//        if (status != null) {
//            int statusCode = Integer.parseInt(status.toString());
//
//            // display specific error page
//            if (statusCode == HttpStatus.NOT_FOUND.value()) {
//                return "Page not found, try: http://localhost:8080/rps";
//            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
//                return "500";
//            } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
//                return "403";
//            }
//        }
//
//        // display generic error
//        return "error";
//    }
