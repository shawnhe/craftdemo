package demo.utils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import demo.model.VideoFrame;
import demo.service.Image;

public class Model {

    static public VideoFrame getFrame(Image image) throws IOException {

    	String [] strs = image.getFrame().split("\n");
    	List<String> list = Arrays.asList(strs);

    	int row = list.size();
    	// not counting newline char
    	int col = list.get(0).length() -1 ;

    	VideoFrame frame = new VideoFrame(row, col, list);
    	return frame;
    }
}
