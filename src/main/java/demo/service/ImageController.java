package demo.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.config.DemoConfig;
import demo.model.Cat;
import demo.model.Frame;
import demo.model.MatchResult;

@RestController
public class ImageController {
    Logger log = LoggerFactory.getLogger(ImageController.class);
    
    @Autowired
    private DemoConfig config;
    
    @PostMapping(value="/findTheCats", consumes = "application/json", produces = "application/json")
    public List<MatchResult> findTheCats(@RequestBody Image image) throws IOException {         
    	List<MatchResult> list = new ArrayList<MatchResult>();
    	
        Cat cat = config.getCat();
        
    	log.info("cat row="+cat.getRow());
    	
    	cat.printCat();
    	
    	MatchResult mrslt = new MatchResult(1, 1, 80);
    	list.add(mrslt);
    	
    	Frame frame = getFrame(image);
    	
    	frame.printFrame();
    	
        return list;
    }
    
    private Frame getFrame(Image image) throws IOException {
    	
    	String [] strs = image.getFrame().split("\n");
    	List<String> list = Arrays.asList(strs);
    	
    	int row = list.size();
    	int col = list.get(0).length();
    	
    	log.info("frame: row="+row+", col="+col);
    	Frame frame = new Frame(row, col, list);
    	return frame;
    }
}
