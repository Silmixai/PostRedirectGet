package com.silvanovich.db;

import java.sql.*;

public class DB {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public DB(String url, String name, String login, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                connection = DriverManager.getConnection(url+name, login, password);
                statement = connection.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Problem with get connection");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Problem with Found class from DriverManager");
        }
    }

      public void insert( String login, String item,String count)
      {
          this.update("INSERT INTO users (login, item, count) VALUES ('"+login+
                  "','"+item+"',"+count+")");
      }




    public void update(String sql) {
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet query(String sql) {
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }


    public void showTable(ResultSet rs) throws SQLException {
      while (rs.next())
      {
          System.out.println("id = "+resultSet.getInt(1)+" login = "+resultSet.getString(2)+" item = "+
                  resultSet.getString(3)+" cont = "+resultSet.getString(4) );

      }
      resultSet.close();

    }

}
