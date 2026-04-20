<%@ page language="java" %>
<%@ page import="javax.servlet.http.Cookie" %>

<!DOCTYPE html>
<html>
<head>
    <title>Active Cookies</title>
</head>
<body>

<h2>Active Cookie List</h2>

<%
    Cookie[] cookies = request.getCookies();

    if (cookies != null) {
        for (Cookie c : cookies) {
%>
            <p>Name: <%= c.getName() %> | Value: <%= c.getValue() %></p>
<%
        }
    } else {
%>
        <p>No cookies found.</p>
<%
    }
%>

</body>
</html>