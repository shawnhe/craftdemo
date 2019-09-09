package demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import demo.config.DemoConfig;

@SpringBootApplication
public class Application {
	
    Logger log = LoggerFactory.getLogger(Application.class);
    
    @Autowired
    private DemoConfig config;
    
    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(Application.class);
        app.run();
    }

    public void run(String... args) throws Exception {
        String modelFile = config.getModelFile();
        log.info("modelFile="+modelFile); 
    }
    
}

