package demo.algorithm;

import java.util.ArrayList;
import java.util.List;

import demo.model.Cat;
import demo.model.Location;
import demo.model.MatchResult;
import demo.model.VideoFrame;

public class NativeMatch {

    static public List<MatchResult> matchFrame(VideoFrame frame, Cat cat, int threshold) {
    	List<MatchResult> list = new ArrayList<MatchResult>();

    	// frame sizes
    	int frame_row = frame.getRow();
    	int frame_col = frame.getCol();
    	
    	// cat sizes
    	int cat_row = cat.getRow();
    	int cat_col = cat.getCol();
    	
    	char[][] frames = frame.getFrame();
    	char[][] cats = cat.getCat();
    	int total = cat_row * cat_col;
    	
    	// scan through row by row and column by column
    	// compare against the cat data
    	for (int i = 0; i < frame_row - cat_row + 1; i++) {
    		for (int j = 0; j< frame_col - cat_col + 1; j++) {
    			int pts = 0;
    			// for each cat size area, match data with cat
    			// each pixel (or point) counts 1pt if matched
    			for (int row = i; row < i + cat_row -1; row++) {
    				for (int col = j; col < j+ cat_col -1; col++) {
    					if (frames[row][col]== cats[row-i][col-j]) {
    						pts ++;
    					}
    				}
    			}
    			
    			// if match percentage exceeds threshold, found a cat in the frame
    			int pct = pts*100/total;
    			if (pct >= threshold) {
    				Location location = new Location(i, j);
    				MatchResult rslt = new MatchResult(location, pct);
    				list.add(rslt);
    			}
    		}
    	}
    	return list;
    }
}
