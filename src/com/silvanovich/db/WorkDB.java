package com.silvanovich.db;

public class WorkDB {

    public static  void createDB(String url, String name, String login, String password)
    {

        DB db = new DB(url, name, login, password);
        db.update("CREATE DATABASE " + name);
        db.update("USE " + name);
        db.update("CREATE TABLE users (id INT AUTO_INCREMENT,"
                + "login VARCHAR(255),"
                + "item VARCHAR(255),"
                + "count INT,"
                + "PRIMARY KEY(id))");

    }

    public static void deleteDB(String url, String name, String login, String password){
        DB db = new DB(url, name, login, password);
        db.update("DROP DATABASE " + name);
    }
}
