package com.example.springbootacuator.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.restart.RestartEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@Autowired
	FileReadService fileReadService;
	
	 @Autowired
	    private RestartEndpoint restartEndpoint;
	
	@PostMapping("/restart/{id}")
    public void restart(@PathVariable String id) {
		if(id.equalsIgnoreCase("restart"))
		{
		//fileReadService.testRead();
			restartEndpoint.restart();
		}
		
		
    }  
}
