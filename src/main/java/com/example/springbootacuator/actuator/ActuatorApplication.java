package com.example.springbootacuator.actuator;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ActuatorApplication {
	
	
	private static ConfigurableApplicationContext context;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		context=SpringApplication.run(ActuatorApplication.class, args);
		DirectoryWatcherExample.watch();
	}

//	public static void restart() {
//        ApplicationArguments args = context.getBean(ApplicationArguments.class);
// 
//        Thread thread = new Thread(() -> {
//            context.close();
//            context = SpringApplication.run(ActuatorApplication.class, args.getSourceArgs());
//            System.out.println("system restarted");
//        });
// 
//        thread.setDaemon(false);
//        thread.start();
//    }
}
