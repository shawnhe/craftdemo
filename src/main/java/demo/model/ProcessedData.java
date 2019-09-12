package demo.model;

import java.util.List;

public class ProcessedData {

    private int row;
    private int col;
    private char[][] data;
        
    public ProcessedData (int row, int col, List<String> list) {
    	this.row = row;
    	this.col = col;
    	data = new char[row][col];    
    	
    	for (int i=0; i< row; i++) {
    		for (int j=0; j<col; j++) {
    			data[i][j] = ' ';
    		}
    	}
    	
    	for (int i = 0; i < row; i++) {
    		String str = list.get(i);    		
    		for (int j=0; j<str.length(); j++) {
    			data[i][j] = str.charAt(j);
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
    
    public char[][] getData() {
    	return data;
    }
    
    public void setData(char[][] data) {
    	this.data = data;
    }
    
    public void printData() {
    	for (int i=0; i<row; i++) {
    		for (int j=0; j<col; j++ ) {
    			System.out.print(data[i][j]);
    		}
    		System.out.println("");
    	}
    }
}