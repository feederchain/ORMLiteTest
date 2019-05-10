/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpledb;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author gregbeauregard
 */
public class Parser {
    
    private Properties properties;
    
    public Parser() {
        properties = new Properties();
        try {
            try (InputStream inStream = new FileInputStream("resources/database.properties")) {
                properties.load(inStream);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public String parseDriver() {
        return properties.getProperty("driver");
    }
    
    public String parseUrl() {
        return properties.getProperty("url");
    }
    
    public String parseUser() {
        return properties.getProperty("username");
    }
    
    public String parsePassword() {
        return properties.getProperty("password");
    }
}
