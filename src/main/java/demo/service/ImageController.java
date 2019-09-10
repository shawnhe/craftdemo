package demo.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.config.DemoConfig;
import demo.model.Cat;

@RestController
public class ImageController {
    Logger log = LoggerFactory.getLogger(ImageController.class);
    
    @Autowired
    private DemoConfig config;
    
    @PostMapping(value="/findTheCats", consumes = "application/json", produces = "application/json")
    public Image findTheCats(@RequestBody Image image) throws IOException {         
    	
        Cat cat = config.getCat();
        
    	log.info("cat row="+cat.getRow());
        return new Image(image.getThreshold(), image.getFrame());
    }
}
