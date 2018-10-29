package com.epam.lab7;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertySettings {
    static Properties prop = new Properties();

    static public String openPrprtFile(String str) {
        try {
            prop.load(new FileInputStream(PropertySettings.class.getClassLoader().getResource("config.properties").getFile()));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop.getProperty(str);
    }
}