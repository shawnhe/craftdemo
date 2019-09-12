package demo.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import demo.model.Cat;

@Component
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix="demo")
public class DemoConfig {
    private String modelFile;

    BufferedReader reader;
    
    Logger log = LoggerFactory.getLogger(DemoConfig.class);

    public String getModelFile() {
        return modelFile;
    }

    public void setModelFile(String modelFile) {
        this.modelFile = modelFile;
    }
    
    // singleton cat data from a disk file
    @Bean
    public Cat getCat() throws IOException {
    	int row = 0;
    	int col = 0;
    	
    	List<String> list = new ArrayList<String>();
    	
    	reader = new BufferedReader (new FileReader(modelFile));
    	
    	String line = reader.readLine();
    	col = line.length();
    	row ++;
    	list.add(line);
    	
    	while(line != null) {
    		line = reader.readLine();
    		row ++;   		
        	list.add(line);
    	}
    	
    	row --;
    	
    	Cat cat = new Cat(row, col, list);
    	return cat;
    }
}
