package demo.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// store frame data into a 2-D array for searching purpose
public class VideoFrame {
	
    Logger log = LoggerFactory.getLogger(VideoFrame.class);
     
    private int row;
    private int col;
    private char[][] frame;
    
    public VideoFrame(int row, int col, List<String> list) {
    	this.row = row;
    	this.col = col;
    	frame = new char[row][col];    
    	
    	for (int i=0; i< row; i++) {
    		for (int j=0; j<col; j++) {
    			frame[i][j] = ' ';
    		}
    	}
    	
    	for (int i = 0; i < row; i++) {
    		String str = list.get(i);
    		for (int j=0; j<str.length(); j++) {
    			frame[i][j] = str.charAt(j);
    		}
    	}
    }
    
    public int getRow() { 
    	return row;    	
    }
    
    public void setRow(int row) {
    	this.row = row;
    }
    
    public int getCol() {
    	return col;
    }
    
    public void setCol(int col) {
    	this.col = col;
    }
    
    public char[][] getFrame() {
    	return frame;
    }
    
    public void setFrame(char[][] frame) {
    	this.frame = frame;
    }
    
    public void printFrame() {
    	for (int i=0; i<row; i++) {
    		for (int j=0; j<col; j++ ) {
    			System.out.print(frame[i][j]);
    		}
    		System.out.println("");
    	}
    }
}
