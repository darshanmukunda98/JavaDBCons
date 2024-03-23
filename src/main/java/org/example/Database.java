package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Database {
    private String getConnectionURL(){
        String propsPath = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "application.properties";
        Properties properties = new Properties();
        String connectionURL = "";
        try(FileInputStream fileInputStream = new FileInputStream(propsPath)){
            properties.load(fileInputStream);
            connectionURL = properties.getProperty("neonDB");
            System.out.println(connectionURL);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return connectionURL;
    }
}
