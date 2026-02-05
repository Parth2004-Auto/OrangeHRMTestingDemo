package com.orangehrmdemo.utils;

import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try (java.io.InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                throw new RuntimeException("config.properties not found in classpath");
            }
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file.");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getUrl() {
        return getProperty("url");
    }

    public static String getBrowser() {
        return getProperty("browser");
    }
}
