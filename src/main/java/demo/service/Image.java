package demo.service;

public class Image {

    private int threshold;
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
