<%
    String user = (String) session.getAttribute("user");
%>

<html>
<body>

<h2>Session Check</h2>

<%
    if(user != null){
%>
        <p><b>Hello <%= user %>! Your session is still active.</b></p>
<%
    } else {
%>
        <p><b>Session expired!</b></p>
        <a href="index.html">Enter Name Again</a>
<%
    }
%>

</body>
</html>