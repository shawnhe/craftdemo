package demo.model;

public class MatchResult {
	private int row;
	private int col;
	private int matchPct;
	
	public MatchResult() {}
	
	public MatchResult(int row, int col, int matchPct) {
		this.row = row;
		this.col = col;
		this.matchPct = matchPct;
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
	
	public int getMatchPct() {
		return matchPct;
	}
	
	public void setMatchPct(int matchPct) {
		this.matchPct = matchPct;
	}
}
