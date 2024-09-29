package my.gcu.worse_amazon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("my.gcu.worse_amazon")
@SpringBootApplication
@ComponentScan({ "my.gcu" })
public class WorseAmazonApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorseAmazonApplication.class, args);
	}

}
