<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Támadó fegyverek</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <select name="hero">
            <option value="0">Válassz höst</option>
            <c:forEach items="${heroList}" var="x">
                <option value="${x.id}"><c:out value="${x.name}" /></option>
            </c:forEach>
        </select>
        
        <ul>
            <c:forEach items="${weapons}" var="weapon">
                <li>${weapon.name} (${weapon.price})</li>
            </c:forEach>
        </ul>
    </body>
</html>

