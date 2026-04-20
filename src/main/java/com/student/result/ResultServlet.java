package com.student.result;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String roll = request.getParameter("rollno");
        String name = request.getParameter("name");

        String s1 = request.getParameter("sub1");
        String s2 = request.getParameter("sub2");
        String s3 = request.getParameter("sub3");
        String s4 = request.getParameter("sub4");
        String s5 = request.getParameter("sub5");

        // Server-side validation
        if (roll.isEmpty() || name.isEmpty() || s1.isEmpty() || s2.isEmpty()
                || s3.isEmpty() || s4.isEmpty() || s5.isEmpty()) {

            response.getWriter().println("All fields are required!");
            return;
        }

        int sub1 = Integer.parseInt(s1);
        int sub2 = Integer.parseInt(s2);
        int sub3 = Integer.parseInt(s3);
        int sub4 = Integer.parseInt(s4);
        int sub5 = Integer.parseInt(s5);

        // Calculate average
        double avg = (sub1 + sub2 + sub3 + sub4 + sub5) / 5.0;

        // Result logic
        String result;
        if (sub1 > 40 && sub2 > 40 && sub3 > 40 && sub4 > 40 && sub5 > 40) {
            result = "PASS";
        } else {
            result = "FAIL";
        }

        // Send data to JSP
        request.setAttribute("roll", roll);
        request.setAttribute("name", name);
        request.setAttribute("sub1", sub1);
        request.setAttribute("sub2", sub2);
        request.setAttribute("sub3", sub3);
        request.setAttribute("sub4", sub4);
        request.setAttribute("sub5", sub5);
        request.setAttribute("avg", avg);
        request.setAttribute("result", result);

        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }
}