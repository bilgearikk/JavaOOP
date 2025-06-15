package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;

        try {
            connection = helper.getConnection();

            String sql = ("DELETE FROM city WHERE id = ?");
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 4086);

            int result = statement.executeUpdate();
            System.out.println(result + "row(s) deleted");

        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            if (connection != null) {
                try {
                    if (statement != null) statement.close();
                    if (connection != null) connection.close();
                } catch (SQLException e) {
                    System.out.println("Error " + e.getMessage());
                }
            }
        }
    }

//    public void delete() throws SQLException {
//        Connection connection = null;
//        DbHelper helper = new DbHelper();
//        PreparedStatement statement = null;
//
//        try {
//            connection = helper.getConnection();
//
//            String sql = ("UPDATE city SET population = 80000, DISTRICT='Düzce' WHERE id = ?");
//            statement = connection.prepareStatement(sql);
//            statement.setInt(1, 4084);
//
//            int result = statement.executeUpdate();
//            System.out.println(result + "row(s) deleted");
//
//        } catch (SQLException exception) {
//            helper.showErrorMessage(exception);
//        } finally {
//            if (connection != null) {
//                try {
//                    if (statement != null) statement.close();
//                    if (connection != null) connection.close();
//                } catch (SQLException e) {
//                    System.out.println("Error " + e.getMessage());
//                }
//            }
//        }
//    }
}