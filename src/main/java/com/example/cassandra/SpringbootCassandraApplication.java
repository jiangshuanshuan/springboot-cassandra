package com.example.cassandra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringbootCassandraApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCassandraApplication.class, args);
	}

}
