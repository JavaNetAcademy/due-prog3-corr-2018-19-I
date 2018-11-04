

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="onegood" items="${goods}">
    - ${onegood.name}<br>    
</c:forEach>

