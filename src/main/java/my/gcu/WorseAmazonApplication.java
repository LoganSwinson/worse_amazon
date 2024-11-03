package my.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "my.gcu" })
public class WorseAmazonApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(WorseAmazonApplication.class, args);
	}
}
