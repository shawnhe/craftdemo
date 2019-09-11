package demo.model;

// location of the center point of a cat on the frame, in terms of row and column
public class Location {
	private int row;
	private int col;
	
	public Location(int row, int col) {
		this.row = row;
		this.col = col;
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
	
	@Override
	public int hashCode() {
	    final int prime = 307;
	    int result = 1;
	    result = prime * result + row;
	    result = prime * result + col;
	    return result;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (obj == null)
	        return false;
	    if (getClass() != obj.getClass())
	        return false;
	    Location other = (Location) obj;
	    if (row != other.row)
	        return false;
	    if (col != other.col)
	        return false;
	    return true;
	}
}
