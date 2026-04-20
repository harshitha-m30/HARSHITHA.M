package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/cookieServlet")
public class CookieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");

        int visitCount = 0;
        boolean found = false;

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("visitCount")) {
                    visitCount = Integer.parseInt(c.getValue());
                    visitCount++;

                    c.setValue(String.valueOf(visitCount));

                    // ⏳ Expiry (30 seconds)
                    c.setMaxAge(30);

                    response.addCookie(c);
                    found = true;
                }
            }
        }

        // First visit
        if (!found) {
            visitCount = 1;

            Cookie countCookie = new Cookie("visitCount", String.valueOf(visitCount));
            countCookie.setMaxAge(30);
            response.addCookie(countCookie);
        }

        // Store username cookie
        Cookie nameCookie = new Cookie("username", name);
        nameCookie.setMaxAge(30);
        response.addCookie(nameCookie);

        // Display greeting
        out.println("<h2>Welcome back " + name + "!</h2>");
        out.println("<h3>You have visited this page " + visitCount + " times.</h3>");

        // Display all cookies
        out.println("<h3>List of Cookies:</h3>");

        Cookie[] allCookies = request.getCookies();

        if (allCookies != null) {
            for (Cookie c : allCookies) {
                out.println("<p>" + c.getName() + " : " + c.getValue() + "</p>");
            }
        } else {
            out.println("<p>No cookies found.</p>");
        }

        out.println("<p><i>Note: Cookies expire in 30 seconds.</i></p>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}