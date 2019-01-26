<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Species Special Property</title>                         
    </head>    
    <body>        
        <jsp:include page="/user/menu.jsp"></jsp:include>
 
        <div>
        <label>Species</label>
            <select name="species">
                <c:forEach items="${speciesList}" var="species">
                    <option value="${species.id}"><c:out value="${species.name}" /></option>
                </c:forEach>
            </select>
        </div>

        
        
    </body>
</html>
