<%-- 
    Document   : enter-protein
    Created on : Aug 6, 2017, 7:51:40 PM
    Author     : Denis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Enter Protein</h1>
    <s:form>
        <s:textfield name="enteredProtein" />
        <s:submit />
    </s:form>
        <div>Last amount entered:<s:property value="enteredProtein" /></div>    
        <div>Total for the day: 100 grams</div>
        <div><s:property value="goalText" /></div>
    </body>
</html>
