package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        Connection connection  = null;
        DbHelper helper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;
        try {
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT Code, Name, Continent, Region from country");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("Name"));
            }
        }
        catch (SQLException exception){
            helper.showErrorMessage(exception);
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error " + e.getMessage());
                }
            }
        }
    }
}