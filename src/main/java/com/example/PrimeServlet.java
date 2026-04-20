package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/primeServlet")
public class PrimeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String input = request.getParameter("num");

        int num;

        try {
            // Try converting input to integer
            num = Integer.parseInt(input);

            boolean isPrime = true;

            if (num <= 1) {
                isPrime = false;
            } else {
                for (int i = 2; i <= num / 2; i++) {
                    if (num % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            if (isPrime) {
                out.println("<h2>" + num + " is a Prime Number</h2>");
            } else {
                out.println("<h2>" + num + " is NOT a Prime Number</h2>");
            }

        } catch (NumberFormatException e) {
            // ❌ Invalid input handling
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, 
                "Invalid input! Please enter a valid number.");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}