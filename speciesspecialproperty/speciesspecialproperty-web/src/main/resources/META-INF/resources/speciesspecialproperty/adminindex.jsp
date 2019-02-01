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
                <form class="form-inline" action="/speciesspecialproperty" method="post">
                    <div class="form-group mb-2">
                        <h3>Faj választása: </h3>
                    </div>
                    <div class="form-group mx-sm-3 mb-2">
                        <select class="form-control" name="selectedSpeciesId">
                            <c:forEach items="${speciesList}" var="species">
                                <c:choose>
                                    <c:when test="${preSelectedSpeciesId == species.id}">
                                        <option value="${species.id}" selected>${species.name}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${species.id}">${species.name}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                    <div><input type="submit" value="Választ" class="btn btn-primary mb-2"></div>
                </form>

            <%--   <label name="siker">-siker- </label>
                <label name="pre">-${preSelectedSpeciesId}-</label>
                <label name="nempre"> -${valami}-</label>
            --%>
                

                <c:if test="${not empty actualPropertys}">
                <h4> A(z) ${selectedSpecies.name} faj speciális képessegei</h4>    
                <table class="table-striped">
                    <thead class="text-center">
                        <tr>
                            <th>Elnevezés</th><th>Leíras</th><th>Level</th><th>Véderő</th><th>Támadási érték</th>
                        </tr>
                    </thead>
                    <tbody class="text-center">
                        <c:forEach items="${actualPropertys}" var="ssp">
                            <tr>
                                <td>${ssp.name}</td><td>${ssp.description}</td><td>${ssp.level}</td><td>${ssp.defense}</td><td>${ssp.damage}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                </c:if>
            </fieldset>
        </div>
    </body>
</html>
