package com.movieapi.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class GetPropertyValues {
    static public String getPropValues(String value) {
        String result = "";
        InputStream inputStream = null;
        try {
            Properties prop = new Properties();
            String propFileName = "application.properties";
            inputStream = GetPropertyValues.class.getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            // get the property value and print it out
            result = prop.getProperty(value);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                assert inputStream != null;
                inputStream.close();
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
        return result;
    }

}
