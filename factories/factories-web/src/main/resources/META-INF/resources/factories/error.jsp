<%-- 
    Document   : index
    Created on : 0000.00.00., 00:00:00
    Author     : jrajmund
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Error</title>
    </head>
    <body>
        <%@ include file = "/user/menu.jsp" %>
        <div class="alert alert-danger" role="alert">
            <h1>Error!</h1>
            <p>${errormessage}</p>
        </div>
    </body>
</html>