package com.demo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class readConfig {

    Properties properties;
    String path = "C:\\Users\\hp\\IdeaProjects\\Project_Demo\\Configuration\\config.properties";

    public readConfig() throws IOException {
        properties = new Properties();
        FileInputStream fis = new FileInputStream(path);
        properties.load(fis);
    }

    public String getBaseURL(){
        String value =  properties.getProperty("BaseURL");
        if (value!= null){
            return value;
        }else
            throw  new RuntimeException("url not specified in config file.");
    }
}
