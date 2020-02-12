/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maja
 */
public class PropertiesRead {
    private static PropertiesRead pr;
    Properties prop;

    private PropertiesRead() {
        prop = new Properties();
        try {
            prop.load(new FileInputStream("settings.properties"));
        } catch (IOException ex) {
            Logger.getLogger(PropertiesRead.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static PropertiesRead getPr() {
        if(pr == null)
            pr = new PropertiesRead();
        return pr;
    }
    public String getDriver(){
        return prop.getProperty("driver");
    }
    
    public String getUrl(){
        return prop.getProperty("url");
    }
    public String getUser(){
        return prop.getProperty("user");
    }
    
    public String getPassword(){
        return prop.getProperty("password");
    }
    
}
