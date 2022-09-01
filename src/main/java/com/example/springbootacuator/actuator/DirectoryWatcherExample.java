package com.example.springbootacuator.actuator;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.restart.RestartEndpoint;
import org.springframework.stereotype.Service;

@Service
public class DirectoryWatcherExample {
	
	
	private static RestartEndpoint restartEndpoint2;
	@Autowired
    private RestartEndpoint restartEndpoint;

    @PostConstruct
    public void init() {
    	DirectoryWatcherExample.restartEndpoint2 = restartEndpoint;
    }
	

	public static void watch() throws IOException, InterruptedException{
	WatchService watchService
    = FileSystems.getDefault().newWatchService();

  Path path = Paths.get("C:/testActuator");

  path.register(
    watchService, 
      StandardWatchEventKinds.ENTRY_CREATE, 
        StandardWatchEventKinds.ENTRY_DELETE, 
          StandardWatchEventKinds.ENTRY_MODIFY);

  WatchKey key;
  while ((key = watchService.take()) != null) {
      for (WatchEvent<?> event : key.pollEvents()) {
          System.out.println(
            "Event kind:" + event.kind() 
              + ". File affected: " + event.context() + ".");
      }
      key.reset();
     restartEndpoint2.restart();
  }
	
}
}
