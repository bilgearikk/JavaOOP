package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement insertstatement = null;
        PreparedStatement checkStatement = null;
        ResultSet resultSet = null;
        try {
            connection = helper.getConnection();
            String checkSql = ("SELECT COUNT(*) FROM city WHERE Name = ? AND CountryCode = ?");
            checkStatement = connection.prepareStatement(checkSql);
            checkStatement.setString(1,"Eskisehir");
            checkStatement.setString(2,"TUR");
            resultSet = checkStatement.executeQuery();

            resultSet.next();

            if(resultSet.getInt(1) == 0) {
                String sql = ("INSERT INTO city (Name,CountryCode,District,Population) values(?,?,?,?)");
                insertstatement = connection.prepareStatement(sql);
                insertstatement.setString(1, "Eskisehir");
                insertstatement.setString(2, "TUR");
                insertstatement.setString(3, "Turkey");
                insertstatement.setInt(4, 2000000);
                int result = insertstatement.executeUpdate();
                System.out.println("Record added");
            } else {
                System.out.println("City already exist!");
            }

        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            if (connection != null) {
                try {
                    if(resultSet != null ) resultSet.close();
                    if(checkStatement != null) checkStatement.close();
                    if(insertstatement != null) insertstatement.close();
                    if(connection != null) connection.close();
                } catch (SQLException e) {
                    System.out.println("Error " + e.getMessage());
                }
            }
        }
    }
}