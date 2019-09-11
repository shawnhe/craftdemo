package demo.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// store cat file as a 2-D array data
public class Cat {
	
    Logger log = LoggerFactory.getLogger(VideoFrame.class);
     
    private int row;
    private int col;
    private char[][] cat;
        
    public Cat(int row, int col, List<String> list) {
    	this.row = row;
    	this.col = col;
    	cat = new char[row][col];    
    	
    	for (int i=0; i< row; i++) {
    		for (int j=0; j<col; j++) {
    			cat[i][j] = ' ';
    		}
    	}
    	
    	for (int i = 0; i < row; i++) {
    		String str = list.get(i);
    		for (int j=0; j<str.length(); j++) {
    			cat[i][j] = str.charAt(j);
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
    
    public char[][] getCat() {
    	return cat;
    }
    
    public void setCat(char[][] cat) {
    	this.cat = cat;
    }
    
    public void printCat() {
    	for (int i=0; i<row; i++) {
    		for (int j=0; j<col; j++ ) {
    			System.out.print(cat[i][j]);
    		}
    		System.out.println("");
    	}
    }
}
