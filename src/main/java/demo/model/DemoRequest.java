package demo.model;

import javax.validation.constraints.NotNull;

public class DemoRequest {

	// default value
    private int threshold = 85;
	
	@NotNull
    private String frame;
    
    public DemoRequest() {}
    
    public DemoRequest(int threshold, String frame) {
        this.threshold = threshold;
        this.frame = frame;
    }

    public int getThreshold() {
        return threshold;
    }

    public String getFrame() {
        return frame;
    }
}
