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
        <title>Species Special Property - Modify Page</title>
    </head>
    <body>        
        <jsp:include page="/user/menu.jsp"></jsp:include>
        <br>
        <nav class="nav nav-pills mb-2">
            <a class="nav-link" href="<c:url value="/speciesspecialproperty"></c:url>">Fajok speciális képességeinek listázása</a>
            <a class="nav-link" href="<c:url value="/newssproperty"></c:url>">Faj speciális képességének létrehozása</a>
            <a class="nav-link active" href="#">Faj speciális képességének módosítása</a>
            <a class="nav-link" href="<c:url value="/delssproperty"></c:url>">Faj speciális képességének törlése</a>
        </nav>
        <div class="container">
            <fieldset>
                <form class="form-inline" action="/modssproperty" method="post">
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
                    <div><input type="submit" value="Választ" class="btn btn-primary mb-2"></div>
                </form>
                
                <c:if test="${not empty actualProperty}">
                <h4> A(z) ${actualProperty.name} adatai</h4>    
                <table class="table-striped">
                    <thead class="text-center">
                        <tr>
                            <th>Elnevezés</th><th>Leíras</th><th>Fajhoz rendelés</th><th>Level</th><th>Véderő</th><th>Támadási érték</th>
                        </tr>
                    </thead>
                    <tbody class="text-center">
                        <tr>
                            <td><input name="sspname" value="${actualProperty.name}" disabled /></td>
                            <td><input name="sspdesc" value="${actualProperty.description}" /></td>
                            <td>
                                <select class="form-control" name="selectedSpeciesId">
                                    <c:forEach items="${speciesList}" var="species">
                                        <option value="${species.id}">${species.name}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td><input name="ssplevel" value="${actualProperty.level}" /></td>
                            <td><input name="sspdefese" value="${actualProperty.defense}" /></td>
                            <td><input name="sspdamage" value="${actualProperty.damage}" /></td>
                        </tr>
                    </tbody>
                </table>
                <div><input type="submit" value="Módosít" class="btn btn-primary"></div>
                </c:if>
                
            </fieldset>
        </div>
    </body>
</html>
