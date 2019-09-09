package demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix="demo")
public class DemoConfig {
    private String modelFile;

    public String getModelFile() {
        return modelFile;
    }

    public void setModelFile(String modelFile) {
        this.modelFile = modelFile;
    }
}
