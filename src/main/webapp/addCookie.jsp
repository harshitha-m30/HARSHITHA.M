<%@ page language="java" %>
<%@ page import="javax.servlet.http.Cookie" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add Cookie</title>
</head>
<body>

<%
    String name = request.getParameter("name");
    String value = request.getParameter("domain");
    int age = Integer.parseInt(request.getParameter("age"));

    // Create cookie
    Cookie cookie = new Cookie(name, value);

    // Set expiry time
    cookie.setMaxAge(age);

    // Add cookie to response
    response.addCookie(cookie);
%>

<h2>Cookie Added Successfully!</h2>
<p>Name: <%= name %></p>
<p>Value (Domain): <%= value %></p>
<p>Expiry Age: <%= age %> seconds</p>

<br>
<a href="showCookies.jsp">Go to Active Cookie List</a>

</body>
</html>