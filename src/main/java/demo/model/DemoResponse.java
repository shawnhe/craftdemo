package demo.model;

import java.util.List;

public class DemoResponse {

	private List<MatchResult> catList;
	private int catCount;
	
	public DemoResponse() {}
	
	public DemoResponse(List<MatchResult> catList, int catCount) {
		this.catList = catList;
		this.catCount = catCount;
	}
	
	public List<MatchResult> getCatList() {
		return catList;
	}
	
	public void setCatList(List<MatchResult> catList) {
		this.catList = catList;
	}
	
	public int getCatCount() {
		return catCount;
	}
	
	public void setCatCount(int catCount) {
		this.catCount = catCount;
	}
}
