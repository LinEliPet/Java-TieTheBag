package com.example.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Image {

	String[] imgAddress = {"/com/example/demo/img/Linda Pettersson.jpg","/com/example/demo/img/Screenshot_20210909-143701_Gallery.jpg"}; 
	
	@RequestMapping(value = "/img", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	
	public @ResponseBody byte[] getImageWithMediaType() throws IOException {
	    int index = new Random().nextInt(0, 2);
		InputStream in = getClass()
	      .getResourceAsStream(imgAddress[index]);
	    System.out.println(index);
	    return IOUtils.toByteArray(in);
	}
}
