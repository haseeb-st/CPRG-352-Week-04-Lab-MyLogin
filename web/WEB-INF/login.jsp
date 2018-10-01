<%-- 
    Document   : login
    Created on : Oct 1, 2018, 8:05:31 AM
    Author     : 687159
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Week 04 Lab - My Login</title>
    </head>
    <body>
        <h1>Remember Me Login Page</h1>
        <form method="POST" action="Login">
            Username: <input type="text" name="username"><br>
            Password: <input type="text" name="password">
            <br><input type="Submit" name="submit" value="Login">
            <br><input type="checkbox" name="rem"> Remember Me
        </form>
        ${errorM}
        ${logM}
    </body>
</html>
