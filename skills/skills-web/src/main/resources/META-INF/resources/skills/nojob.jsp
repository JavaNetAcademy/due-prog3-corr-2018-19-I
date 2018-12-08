
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <jsp:include page="/user/menu.jsp"></jsp:include>
         <br>
        <div class="alert alert-danger" role="alert">
            <h1 class="text-center">A képességek használata foglalkozásokhoz kötött. Így legalább egy munkának léteznie kell. </h1>
        </div>        
    </body>
</html>
