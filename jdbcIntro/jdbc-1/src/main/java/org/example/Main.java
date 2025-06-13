package org.example;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        Connection connection  = null;
        DbHelper helper = new DbHelper();

        try {
            connection = helper.getConnection();
            System.out.println("Connected!");
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
