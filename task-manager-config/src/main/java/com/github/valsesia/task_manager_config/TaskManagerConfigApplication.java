package com.github.valsesia.task_manager_config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class TaskManagerConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagerConfigApplication.class, args);
	}

}
