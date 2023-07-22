package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class ConfigurationProperties {

    static InputStream fileStream=null;
    static String fileName= "config.properties";
    static Properties properties=new Properties();

//    public static String getPropertyValueByKey(String inputKey){
//        String value=null;
//
//        try {
//            if(inputKey != null && !inputKey.equals("")){
//                fileStream=new Object(){}.getClass().getClassLoader().getResourceAsStream(fileName);
//                if(fileStream==null){
//                    throw new FileNotFoundException("Unable To Find Configuration File "+fileName);
//                }
//                properties.load(fileStream);
//                Enumeration<?> e = properties.propertyNames();
//                if(e != null){
//                    while (e.hasMoreElements()){
//                        String keyName = (String) e.nextElement();
//                        if(inputKey.equals(keyName)){
//                            value=properties.getProperty(keyName);
//                            break;
//                        }
//                    }
//                }
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        return value;
//    }

    public static String getPropertyValueByKey(String inputKey) {
        String value=null;
        try {
            Properties prop=new Properties();
            FileInputStream fis=new FileInputStream("src/test/resources/config.properties");

            prop.load(fis);

            prop.getProperty(inputKey);
            Enumeration<?> names = prop.propertyNames();

            while (names.hasMoreElements()){
                String name =(String) names.nextElement();
                if(inputKey.equals(name)){
                    value = prop.getProperty(name);
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
