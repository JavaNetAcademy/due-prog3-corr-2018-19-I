<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Auth Error Page</title>
    </head>
    <body>
         <jsp:include page="/user/menu.jsp"></jsp:include>
         <br>
        <div class="alert alert-danger" role="alert">
            <h3>Ön nincs bejelentkezve!</h3>
        </div>        
    </body>
</html>