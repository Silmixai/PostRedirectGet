package com.silvanovich.servlets;

import com.silvanovich.db.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SecondServlet extends HttpServlet {
    private DB db;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        out.print("<!DOCTYPE html><html><head>");
        out.print("<meta charset=\"UTF-8\">");
        out.print("<title>First response page</title>");
        out.print("</head><body>");
        out.print("<p>Спасибо, ваш заказ добавлен!</p>");
        HttpSession ses = request.getSession(true);
        DB db = new DB("jdbc:mysql://localhost:3306/", "testPRG", "root", "root");
        ResultSet rs = db.query("SELECT * FROM users WHERE login='"+String.valueOf(ses.getAttribute("login"))+"'");

        try {
            if(rs.next()){
                out.print("<p>Login:" + rs.getString("login") + "</p>");
                out.print("<p>Item: " + rs.getString("item") + "</p>");
                out.print("<p>Count: "+rs.getInt("count") + "</p>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.print("</body></html>");

    }


}
