package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Database {

    private final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS todos (" +
            "    task_id SERIAL PRIMARY KEY," +
            "    title VARCHAR(255) NOT NULL," +
            "    description TEXT," +
            "    done BOOLEAN NOT NULL DEFAULT FALSE," +
            "    task_date DATE," +
            "    priority INT," +
            "    deleted BOOLEAN NOT NULL DEFAULT FALSE)";
    private final String INSERT = "INSERT INTO todos (" +
            "title, " +
            "description, " +
            "task_date, " +
            "priority) VALUES (?,?,?,?)";
    private final String SELECT = "SELECT * FROM todos";
    private String getConnectionURL(){
        String propsPath = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "application.properties";
        Properties properties = new Properties();
        String connectionURL = "";
        try(FileInputStream fileInputStream = new FileInputStream(propsPath)){
            properties.load(fileInputStream);
            connectionURL = properties.getProperty("neonDB");
            System.out.println(connectionURL);
        }catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("ERROR: Something wrong with file!");
            e.printStackTrace();
        }
        return connectionURL;
    }
    private Connection getConnection() throws SQLException {
        String connectionURL = getConnectionURL();
        Connection connection = null;

        if(!connectionURL.isEmpty()) {
            System.out.println("Connecting...");
            connection = DriverManager.getConnection(connectionURL);
        }

        return connection;
    }
    public void executeCreateQuery(){
        try(Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(CREATE_TABLE)){
            if(connection == null){
                throw new SQLException("ERROR: Error getting connection.");
            }
            System.out.println("Established Connection.");
            statement.executeUpdate();
            System.out.println("TABLE CREATED");
        } catch (SQLException e) {
            System.out.println("SQL Error Occurred: "+ e.getMessage());
            e.printStackTrace();
        }finally {
            System.out.println("Closed connection.");
        }
    }
    public void executeInsertQuery(Todo todo){
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT)){
            if(connection == null){
                throw new SQLException("ERROR: Error getting connection.");
            }
            statement.setString(1, todo.getTitle());
            statement.setString(2, todo.getDescription());
            statement.setDate(3, todo.getTask_date());
            statement.setInt(4, todo.getPriority());
            System.out.println("Established Connection.");
            statement.executeUpdate();
            System.out.println("INSERTED");
        } catch (SQLException e) {
            System.out.println("SQL Error Occurred: "+ e.getMessage());
            e.printStackTrace();
        }finally {
            System.out.println("Closed connection.");
        }
    }
    public void executeSelectQuery(){
        try(Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(SELECT)){
            if(connection == null){
                throw new SQLException("ERROR: Error getting connection.");
            }
            System.out.println("Established Connection.");
            ResultSet resultSet = statement.executeQuery();
            List<Todo> todos = new ArrayList<>();
            while(resultSet.next()){
                   todos.add(new Todo(
                           resultSet.getInt("task_id"),
                           resultSet.getString("title"),
                           resultSet.getString("description"),
                           resultSet.getInt("priority"),
                           resultSet.getDate("task_date"),
                           resultSet.getBoolean("done"),
                           resultSet.getBoolean("deleted")));
            }
            System.out.println(todos);
            System.out.println("SELECT *");
        } catch (SQLException e) {
            System.out.println("SQL Error Occurred: "+ e.getMessage());
            e.printStackTrace();
        }finally {
            System.out.println("Closed connection.");
        }
    }
}
