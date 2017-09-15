package org;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperty {

    public static InputStream inputStream;
    public static Properties prop;

    public static Properties readConfigFile() throws IOException {
        try {
            prop = new Properties();
            String profilename = "config";
            inputStream = new FileInputStream("../EasyTest/src/test/resources/conf.properties");
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException(
                        "property file '" + profilename + "' not found in the classpath");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
        }
        return prop;
    }

    public static String getTestProperty(String key) throws Throwable {
        try {
            prop = readConfigFile();
            return prop.getProperty(key);
        } catch (Throwable e) {
            e.printStackTrace();
            throw e;
        }
    }

}
