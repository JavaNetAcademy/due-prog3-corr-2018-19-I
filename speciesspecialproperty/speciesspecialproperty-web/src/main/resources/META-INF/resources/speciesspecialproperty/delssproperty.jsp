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
        <title>Species Special Property - Delete Page</title>
    </head>
    <body>        
        <jsp:include page="/user/menu.jsp"></jsp:include>
        <br>
        <nav class="nav nav-pills mb-2">
            <a class="nav-link" href="<c:url value="/speciesspecialproperty"></c:url>">Fajok speciális képességeinek listázása</a>
            <a class="nav-link" href="<c:url value="/newssproperty"></c:url>">Faj speciális képességének létrehozása</a>
            <a class="nav-link" href="<c:url value="/modssproperty"></c:url>">Faj speciális képességének módosítása</a>
            <a class="nav-link active" href="#">Faj speciális képességének törlése</a>
        </nav>
        <div class="container">
            <fieldset>
                <form class="form-inline" action="/delssproperty" method="post">
                    <div class="form-group mb-2">
                        <h3>Fajok speciális képességének választása: </h3>
                    </div>
                    <div class="form-group mx-sm-3 mb-2">
                        <select class="form-control" name="selectedSspId">
                            <c:forEach items="${sspropertyList}" var="ssproperty">
                                <option value="${ssproperty.id}">${ssproperty.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div><input type="submit" value="Töröl" class="btn btn-primary mb-2"></div>
                </form>
            </fieldset>
        </div>
    </body>
</html>
