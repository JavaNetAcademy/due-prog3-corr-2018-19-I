<%-- 
    Author     : Szabó Viktor / mikulas975 / vts4gv
--%>

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
        <br>
        <nav class="nav nav-pills mb-2">
            <a class="nav-link active" href="#">Fajok speciális képességeinek listázása</a>
            <a class="nav-link" href="<c:url value="/newssproperty"></c:url>">Faj speciális képességének létrehozása</a>
            <a class="nav-link" href="<c:url value="/modssproperty"></c:url>">Faj speciális képességének módosítása</a>
            <a class="nav-link" href="<c:url value="/delssproperty"></c:url>">Faj speciális képességének törlése</a>
        </nav>
        <div class="container">
            <fieldset>
            <legend>Speciális képességek listázása fajok szerint</legend>
            <form>
                <br>
                <label>Faj választása: </label>
                <div>
                    <select name="species">
                        <c:forEach items="${speciesList}" var="species">
                            <option value="${species.id}"><c:out value="${species.name}" /></option>
                        </c:forEach>
                    </select>
                </div>
            </form>
        </div>
    </body>
</html>
