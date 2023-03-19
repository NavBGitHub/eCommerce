package Utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class ConfigurationProperties {

    static InputStream fileStream=null;
    static String fileName="config.properties";
    static Properties properties=new Properties();

    public static String getPropertyValueByKey(String inputKey){
        String value=null;

        try {
            if(!inputKey.equals(null) && !inputKey.equals("")){
                fileStream=new Object(){}.getClass().getClassLoader().getResourceAsStream(fileName);
                if(fileStream==null){
                    throw new FileNotFoundException("Unable To Find Configuration File "+fileName);
                }
                properties.load(fileStream);
                Enumeration<?> e = properties.propertyNames();
                if(!e.equals(null)){
                    while (e.hasMoreElements()){
                        String keyName = (String) e.nextElement();
                        if(inputKey.equals(keyName)){
                            value=properties.getProperty(keyName);
                            break;
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return value;
    }
}
