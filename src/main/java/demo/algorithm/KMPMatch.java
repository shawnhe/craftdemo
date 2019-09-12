package demo.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import demo.model.Cat;
import demo.model.Location;
import demo.model.MatchResult;
import demo.model.VideoFrame;

public class KMPMatch {

    static public List<MatchResult> matchFrame(VideoFrame frame, Cat cat, int threshold) {
    	Set<Location> locations = new HashSet<>();
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

    	List<String> patternList = new ArrayList<String>();
    	List<String> textList = new ArrayList<String>();

    	for (int i=0; i< cat_row; i++) {
    		String pattern = new String(cats[i]);
			patternList.add(pattern);
    	}

    	for (int i=0; i< frame_row; i++) {
    		String text = new String(frames[i]);
    		textList.add(text);
    	}

    	int patternSize = patternList.size();
    	int textSize = textList.size();

    	// search all possible locations that resemble the cat pattern
    	for (int i = 0; i<patternSize; i++) {
    		int secondIndex = getRandomIndex(i, patternSize);
    		
    		String pattern = patternList.get(i);
    		String pattern2 = patternList.get(secondIndex);
    		
    		KMP kmp = new KMP(pattern);
    		KMP kmp2 = new KMP(pattern2);
    		
    		for (int j=i; j<textSize-patternSize+i; j++) {
    			String text = textList.get(j);
    			String text2 = textList.get(j-i+secondIndex);

    			int offset = 0;
    			int index1;
    			int index2;
    			String toMatch = text;
    			String toMatch2 = text2;
    			while ((index1=kmp.search(toMatch)) != -1 && (index2=kmp2.search(toMatch2)) != -1 && index1== index2) {
					int row = j-i;
					int col = index1+offset;
					
					Location location = new Location(row, col);
					locations.add(location);

    				offset += index1 + cat_col;

    				if (offset >= frame_col-cat_col+1 || offset > text.length()-cat_col+1) break;

					toMatch = text.substring(offset);
					toMatch2 = text2.substring(offset);
    			}
    		}
    	}

    	// scan through row by row and column by column
    	// compare against the cat data
        Iterator<Location> it = locations.iterator();
        while(it.hasNext()){
        	Location location = (Location)it.next();
        	int row = location.getRow();
        	int col = location.getCol();
        	
        	int pts = 0;
        	for (int i=row; i< row+cat_row-1; i++) {
        		for (int j=col; j<col+cat_col-1; j++) {
					if (frames[i][j]== cats[i-row][j-col]) {
						pts ++;
					}
        		}        		
        	}

			// if match percentage exceeds threshold, found a cat in the frame
			int pct = pts*100/total;

			if (pct >= threshold) {;
				MatchResult rslt = new MatchResult(location, pct);
				list.add(rslt);
			}
        }

    	return list;
    }
    
    static private int getRandomIndex(int myIndex, int size) {
    	Random rand = new Random();

    	int n = -1;
    	// Obtain a number between [0 - 49].
    	while (n==-1 || n== myIndex) {
    	 n = rand.nextInt(size);
    	}
    	
    	return n;
    }
}
