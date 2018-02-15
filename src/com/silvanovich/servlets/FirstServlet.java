package com.silvanovich.servlets;

import com.silvanovich.db.DB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;


public class FirstServlet extends HttpServlet {

    private DB db;
    private static int count = 0;
    private ResultSet rs;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        DB db = new DB("jdbc:mysql://localhost:3306/", "testPRG", "root", "root");
        ResultSet query = db.query("SELECT * FROM USERS");




        String login = request.getParameter("login");
        String item = request.getParameter("item");
        String count = request.getParameter("count");

        System.out.println("login=" + login + " item=" + item + " count " + count);

        rs = db.query("SELECT * FROM users WHERE login='" + login + "'");
        try {
            if (rs.next())
            {db.update("UPDATE users SET count=" + (rs.getString("count") + request.getParameter("count"))
                        + " WHERE login='" + request.getParameter("login") + "'");

            }
            else
            {  db.insert(login, item, count);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (request.getParameter("prg").equals("prg"))
        {
            HttpSession ses = request.getSession(true);
            ses.setAttribute("login", request.getParameter("login"));
            response.sendRedirect("/SecondServlet");

        }




        PrintWriter out = response.getWriter();

        out.print("<!DOCTYPE html><html><head>");
        out.print("<meta charset=\"UTF-8\">");
        out.print("<title>First response page</title>");
        out.print("</head><body>");
        out.print("<p>Спасибо, ваш заказ добавлен!</p>");
        rs = db.query("SELECT * FROM users WHERE login='" + request.getParameter("login") + "'");
        try {
            if (rs.next()) {
                out.print("<p>Login: " + rs.getString("login") + "</p>");
                out.print("<p>Item: " + rs.getString("item") + "</p>");
                out.print("<p>Count: " + rs.getInt("count") + "</p>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.print("</body></html>");
    }


}
