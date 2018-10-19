

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="oneempires" items="${empires}">
    - ${oneempires.name}<br>    
</c:forEach>

