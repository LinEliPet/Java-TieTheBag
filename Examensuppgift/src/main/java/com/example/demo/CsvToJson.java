package com.example.demo;

import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONTokener;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

@RestController
public class CsvToJson {
	
	@RequestMapping(
			path = "/csv-converter", // localhost:8080/calc/operator/num1/num2
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)

	
	public String json (String s) {
        InputStream inputStream = CsvToJson.class.getClassLoader().getResourceAsStream("com/example/demo/CSVfolder/sample.csv");
        String csvAsString = new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining("\n"));
//        BufferedReader csvAsString = new BufferedReader(new InputStreamReader(inputStream));
        System.out.println(csvAsString);
//        String json = CDL.rowToJSONArray(new JSONTokener(csvAsString)).toString();
        JSONArray jsonArray = CDL.toJSONArray(csvAsString);        
        System.out.println(jsonArray);
//        System.out.println(json);
//        try {
//            Files.write(Path.of("output.json"), json.getBytes(StandardCharsets.UTF_8));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//		return json;
//		return "{ \"Games\":  [ \"tjena\" ] }";
        return jsonArray.toString();
    }
	
	
}
