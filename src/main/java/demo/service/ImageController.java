package demo.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.config.DemoConfig;
import demo.model.Cat;
import demo.model.DemoResponse;
import demo.model.Location;
import demo.model.VideoFrame;
import demo.model.MatchResult;

@RestController
public class ImageController {
    Logger log = LoggerFactory.getLogger(ImageController.class);
    
    @Autowired
    private DemoConfig config;
    
    @PostMapping(value="/findTheCats", consumes = "application/json", produces = "application/json")
    public DemoResponse findTheCats(@Valid @RequestBody Image image) throws IOException {         
    	
        Cat cat = config.getCat();
        
    	log.info("cat row="+cat.getRow());
    	
    	cat.printCat();
    	
    	VideoFrame frame = getFrame(image);
    	
    	frame.printFrame();
    	
    	List<MatchResult> list = matchFrame(frame, cat, image.getThreshold());
    	
    	DemoResponse response = new DemoResponse(list, list.size());
    	
        return response;
    }
    
    private VideoFrame getFrame(Image image) throws IOException {
    	
    	String [] strs = image.getFrame().split("\n");
    	List<String> list = Arrays.asList(strs);
    	
    	int row = list.size();
    	int col = list.get(0).length();
    	
    	log.info("frame: row="+row+", col="+col);
    	VideoFrame frame = new VideoFrame(row, col, list);
    	return frame;
    }
    
    private List<MatchResult> matchFrame(VideoFrame frame, Cat cat, int threshold) {
    	List<MatchResult> list = new ArrayList<MatchResult>();

    	int frame_row = frame.getRow();
    	int frame_col = frame.getCol();
    	
    	int cat_row = cat.getRow();
    	int cat_col = cat.getCol();
    	
    	char[][] frames = frame.getFrame();
    	char[][] cats = cat.getCat();
    	int total = cat_row * cat_col;
    	
    	for (int i = 0; i < frame_row - cat_row + 1; i++) {
    		for (int j = 0; j< frame_col - cat_col + 1; j++) {
    			int pts = 0;
    			for (int row = i; row < i + cat_row -1; row++) {
    				for (int col = j; col < j+ cat_col -1; col++) {
    					if (frames[row][col]== cats[row-i][col-j]) {
    						pts ++;
    					}
    				}
    			}
    			
    			int pct = pts*100/total;
    			if (pct >= threshold) {
    				int x = i + cat_row/2;
    				int y = j + cat_col/2;
    				Location location = new Location(x, y);
    				MatchResult rslt = new MatchResult(location, pct);
    				list.add(rslt);
    			}
    		}
    	}
    	return list;
    }
}
