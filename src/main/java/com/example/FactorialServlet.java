package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/factorialServlet")
public class FactorialServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int num = Integer.parseInt(request.getParameter("num"));

        long factorial = 1;

        for (int i = 1; i <= num; i++) {
            factorial = factorial * i;
        }

        out.println("<h2>Factorial of " + num + " is: " + factorial + "</h2>");
    }
}