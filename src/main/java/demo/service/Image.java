package demo.service;

import javax.validation.constraints.NotNull;

public class Image {

	// default value
    private int threshold = 85;
	
	@NotNull
    private String frame;
    
    public Image() {}
    
    public Image(int threshold, String frame) {
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
