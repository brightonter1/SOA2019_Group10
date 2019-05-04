package com.example.Cosmetic;

import com.example.Cosmetic.Repository.CosmeticRepository;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootApplication
public class CosmeticApplication {

	public static void main(String[] args) {
		SpringApplication.run(CosmeticApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}


	@Bean
	CommandLineRunner runner(CosmeticRepository cosmeticRepository){
		return args -> {
			Logger logger = LoggerFactory.getLogger(CosmeticApplication.class);
			logger.info("Loading.........................");
			String url = "https://makeup-api.herokuapp.com/api/v1/products.json?product_type=blush";
			URL obj = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

			conn.setRequestMethod("GET");
			int responseCode = conn.getResponseCode();

			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			logger.info("Fetch API From : " + url);
			logger.info("Method 'GET' response : " + responseCode);
			while ((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
			}

			reader.close();

			JSONParser jsonParser = new JSONParser();
			JSONArray json = new JSONArray();
			try {
				Object object = jsonParser.parse(String.valueOf(response));
				json = (JSONArray) object;
			} catch (ParseException e) {
				e.printStackTrace();
			}

//			ObjectMapper mapper = new ObjectMapper();
//			for (int i = 0; i < 30; i++) {
//				JSONObject data = (JSONObject) json.get(i);
//				String dataString = data.toString();
//				Cosmetic cosmetic = mapper.readValue(dataString, Cosmetic.class);
//				cosmetic.setName(cosmetic.getName().replaceAll("\\s", ""));
//				cosmeticRepository.save(cosmetic);
//			}

		};
	}


}
