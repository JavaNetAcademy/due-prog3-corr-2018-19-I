<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Támadó fegyverek</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>        
        <ul>
            <c:forEach items="${weapons}" var="weapon">
                <li>${weapon.name} (${weapon.price})</li>
            </c:forEach>
        </ul>
    </body>
</html>

