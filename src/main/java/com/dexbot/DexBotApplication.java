package com.dexbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.dexbot.portal.home.HomeController;

@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement(proxyTargetClass=true)
public class DexBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(DexBotApplication.class, args);
		System.out.println("============================================");
		HomeController homeController = new HomeController();
		homeController.initSettings();
	}
}
