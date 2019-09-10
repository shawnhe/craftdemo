package demo.model;

public class MatchResult {

	private Location location;
	private int matchPct;
	
	public MatchResult() {}
	
	public MatchResult(Location location, int matchPct) {
		this.location = location;
		this.matchPct = matchPct;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public int getMatchPct() {
		return matchPct;
	}
	
	public void setMatchPct(int matchPct) {
		this.matchPct = matchPct;
	}
}
