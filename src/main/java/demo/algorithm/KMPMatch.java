package demo.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
    		//skip compare the three rows
    		if (i==2 || i==5 || i==10) continue;
    		String pattern = patternList.get(i);
    		KMP kmp = new KMP(pattern);

    		for (int j=i; j<textSize-patternSize+i; j++) {
    			String text = textList.get(j);

    			int offset = 0;
    			int index;
    			String toMatch = text;
    			while ((index=kmp.search(toMatch)) != -1) {
					int row = j-i;
					int col = index+offset;
					Location location = new Location(row, col);
					locations.add(location);

    				offset += index + cat_col;

    				if (offset >= frame_col-cat_col+1 || offset > text.length()-cat_col+1) break;

					toMatch = text.substring(offset);
    			}
    		}
    	}

    	// scan through row by row and column by column
    	// compare against the cat data
        Iterator<Location> it = locations.iterator();
        while(it.hasNext()){
        	int row = it.next().getRow();
        	int col = it.next().getCol();

        	int pts = 0;
        	for (int i=row; i< row+cat_row-1; i++) {
        		for (int j=col; j<col+cat_col-1; j++) {
					if (frames[row][col]== cats[i-row][j-col]) {
						pts ++;
					}
        		}
        	}

			// if match percentage exceeds threshold, found a cat in the frame
			int pct = pts*100/total;

			if (pct >= threshold) {;
				MatchResult rslt = new MatchResult(it.next(), pct);
				list.add(rslt);
			}
        }

    	return list;
    }
}
