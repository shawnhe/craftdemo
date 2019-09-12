package demo.service;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.algorithm.NativeMatch;
import demo.config.DemoConfig;
import demo.model.Cat;
import demo.model.DemoResponse;
import demo.model.VideoFrame;
import demo.utils.Model;
import demo.model.MatchResult;

@RestController
public class ImageNativeController {
    Logger log = LoggerFactory.getLogger(ImageNativeController.class);
    
    @Autowired
    private DemoConfig config;
    
    //REST API to search for cat from an image file
    @PostMapping(value="/findTheCats/native", consumes = "application/json", produces = "application/json")
    public DemoResponse findTheCats(@Valid @RequestBody Image image) throws IOException {         
    	
    	// read out the server's cat file
        Cat cat = config.getCat();
            	    	
    	// read out the request's frame file
    	VideoFrame frame = Model.getFrame(image);
    	    	
    	// match frame with the cat
    	List<MatchResult> list = NativeMatch.matchFrame(frame, cat, image.getThreshold());
    	
    	// construct response with search results
    	DemoResponse response = new DemoResponse(list, list.size());
    	
        return response;
    }
}
