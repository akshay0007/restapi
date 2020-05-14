package com.staxrt.tutorial.mainpkt;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class App1 {

    public static void main(String[] args) throws IOException {
        App1 app = new App1();
        Properties prop = app.loadPropertiesFile("db.properties");
        prop.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    public Properties loadPropertiesFile(String filePath) throws IOException {
        Properties prop = new Properties();
        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
            prop.load(resourceAsStream);
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + filePath);
        }
        return prop;
    }
}