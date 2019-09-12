package demo.utils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import demo.model.ProcessedData;
import demo.service.Image;

public class Model {

    static public ProcessedData getFrame(Image image) throws IOException {

    	String [] strs = image.getFrame().split("\n");

    	for (int i=0; i< strs.length; i++) {
    		strs[i] = StringUtils.chomp(strs[i]);
    	}
    	
    	List<String> list = Arrays.asList(strs);

    	int row = list.size();
    	// not counting newline char
    	int col = list.get(0).length() ;

    	ProcessedData frame = new ProcessedData(row, col, list);
    	return frame;
    }
}
