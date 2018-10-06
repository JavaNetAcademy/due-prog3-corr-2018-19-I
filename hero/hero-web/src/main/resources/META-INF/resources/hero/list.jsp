

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="onehero" items="${heroes}">
    - ${onehero.name}<br>    
</c:forEach>

