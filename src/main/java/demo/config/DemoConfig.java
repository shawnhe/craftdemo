package demo.config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import demo.Application;
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
    
    @Bean
    public Cat getCat() throws IOException {
    	int row = 0;
    	int col = 0;
    	
    	reader = new BufferedReader (new FileReader(modelFile));
    	
    	String line = reader.readLine();
    	col = line.length();
    	row ++;
    	
    	while(line != null) {
    		line = reader.readLine();
    		row ++;   		
    	}
    	
    	log.info("row="+row+", col="+col);
    	Cat cat = new Cat(row, col);
    	return cat;
    }
}
