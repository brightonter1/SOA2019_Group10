<<<<<<< HEAD
package com.example.CategoryService;
=======
package com.example.categoryService;
>>>>>>> front-end

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

<<<<<<< HEAD
@EnableEurekaClient
@SpringBootApplication
=======
@SpringBootApplication
@EnableEurekaClient

>>>>>>> front-end
public class CategoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CategoryServiceApplication.class, args);
	}

}
