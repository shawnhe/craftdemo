package demo.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

public class Cat {
	
    Logger log = LoggerFactory.getLogger(Cat.class);
     
    private int row;
    private int col;
    private char[][] cat;
        
    public Cat(int row, int col) {
    	this.row = row;
    	this.col = col;
    	cat = new char[row][col];             
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
}
