package setup;

import org.apache.commons.lang3.StringUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class LoadProperties {
    public static String getPropertyValue (String aProperty, String propertyKey) throws IOException {
        String result = "";
        Properties properties = new Properties();

        try {
            InputStream inputStream = LoadProperties.class.getClassLoader().getResourceAsStream(aProperty);
            properties.load(inputStream);
        } catch(FileNotFoundException e){
            System.out.println("Property could not be found " + propertyKey);

        } catch(IOException e){
            System.out.println("Property could not be loaded " + propertyKey);
        }

        Set<String> values = properties.stringPropertyNames();
        for(String value : values){
            if(StringUtils.equalsIgnoreCase(value, propertyKey)){
                result = properties.getProperty(value);
                break;
            }
        }

        return result;
    }
}
