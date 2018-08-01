<%-- 
    Document   : data
    Created on : Jul 31, 2018, 5:28:38 PM
    Author     : denys.prokopiuk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" isErrorPage="false" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="comp" scope="application" class="com.app.ch07.jpa.Computer"></jsp:useBean>
       
        <h1>Hello World!+<jsp:getProperty property="name" name="comp"/></h1>
        <jsp:setProperty property="name" value="test" name="comp"/>
         <h1>Hello World!+<jsp:getProperty property="name" name="comp"/></h1>
         <br>
         ${comp}
        
    </body>
</html>
