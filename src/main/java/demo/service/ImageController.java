package demo.service;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {

    @PostMapping(value="/findTheCats", consumes = "application/json", produces = "application/json")
    public Image findTheCats(@RequestBody Image image) {    	
        return new Image(image.getThreshold(), image.getFrame());
    }
}
