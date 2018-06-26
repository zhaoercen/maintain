package com.jiebao.maintain.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@SpringBootApplication
public class MaintainClientStart {
	public static void main(String[] args) throws IOException {
		Properties properties = new Properties();
		InputStream in = MaintainClientStart.class.getClassLoader().getResourceAsStream("client.properties");
		properties.load(in);
		SpringApplication app = new SpringApplication(MaintainClientStart.class);
		app.setDefaultProperties(properties);
		app.run(args);


	}
}
