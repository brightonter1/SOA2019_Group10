package com.example.UserService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);



		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader("json/employees.json"))
		{
			//Read JSON file
			Object obj = null;
			try {
				obj = jsonParser.parse(reader);
			} catch (Exception e) {
				e.printStackTrace();
			}

			JSONArray employeeList = (JSONArray) obj;
			System.out.println(employeeList);

			//Iterate over employee array
			employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void parseEmployeeObject(JSONObject employee)
	{
		//Get employee object within list
		JSONObject employeeObject = (JSONObject) employee.get("employee");

		//Get employee first name
		String firstName = (String) employeeObject.get("firstName");
		System.out.println(firstName);

		//Get employee last name
		String lastName = (String) employeeObject.get("lastName");
		System.out.println(lastName);

		//Get employee website name
		String website = (String) employeeObject.get("website");
		System.out.println(website);
	}


}
