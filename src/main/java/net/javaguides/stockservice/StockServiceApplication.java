package net.javaguides.stockservice;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class StockServiceApplication {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded successfully!");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load driver: " + e.getMessage());
		}
		SpringApplication.run(StockServiceApplication.class, args);
	}

}
