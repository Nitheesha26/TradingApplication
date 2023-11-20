package com.signalHandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.signalHandler")
public class TradingApplication{

	public static void main(String[] args) {
		SpringApplication.run(TradingApplication.class, args);
	}

}

