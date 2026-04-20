<%@ page import="java.util.*" %>

<%
    // Get name from form
    String name = request.getParameter("username");

    // Create session
    session.setMaxInactiveInterval(60); // 1 minute

    if(name != null){
        session.setAttribute("user", name);
    }

    String user = (String) session.getAttribute("user");
%>

<html>
<body>

<h2>Session Management using JSP</h2>

<%
    if(user != null){
%>
        <p><b>Hello <%= user %>!</b></p>

        <p>Session will expire in 1 minute.</p>

        <p>
            <a href="check.jsp">Click here to check session</a>
        </p>

        <p>Or wait for 1 minute and refresh to see session expiry.</p>

<%
    } else {
%>
        <p>Session expired! Please enter your name again.</p>
        <a href="index.html">Go Back</a>
<%
    }
%>

</body>
</html>