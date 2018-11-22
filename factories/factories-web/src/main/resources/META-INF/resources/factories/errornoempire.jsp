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
    <center>
        <div class="container">
            <div class="w-75 p-3">
                <div class="alert alert-warning" role="alert">
                    <h1>${user.name} nincs még birodalmad!</h1>
                </div>
            </div>
        </div>
    </center>
</body>
</html>