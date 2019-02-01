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
            <form class="form-inline" action="/modssproperty" method="post">
                <fieldset>
                    <table class="table">
                        <tbody>
                            <table class="table-striped">
                            <tr>
                                <th><h3>Fajok speciális képességének választása: </h3></th>
                                <th>
                                <select class="form-control" name="selectedSspId">
                                    <c:forEach items="${sspropertyList}" var="ssproperty">
                                        <c:choose>
                                            <c:when test="${preSelectedSspropertyId == ssproperty.id}">
                                                <option value="${ssproperty.id}" selected>${ssproperty.name}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${ssproperty.id}">${ssproperty.name}</option>
                                            </c:otherwise>
                                        </c:choose>    
                                    </c:forEach>
                                </select>
                                </th>
                                <th>
                                <input type="submit" name="selectSsp" value="Választ" class="btn btn-primary mb-2">
                                </th>
                            </tr>
                            </table>
                        <%--      <tr>
                                <table>
                                    <tr>
                                    <td><label name="s1">Id: ${siker1}</label></td>
                                    <td><label name="s2">Name: ${siker2}</label></td>
                                    <td><label name="s3">Desc: ${siker3}</label></td>
                                    <td><label name="s4">SpId: ${siker4}</label></td>
                                    <td><label name="s5">Level: ${siker5}</label></td>
                                    <td><label name="s6">Def: ${siker6}</label></td>
                                    <td><label name="s7">Dam: ${siker7}</label></td>
                                    </tr>
                                </table>
                            </tr> --%>
                            <tr>            
                                <c:if test="${not empty actualProperty}">
                                <table class="table-striped">
                                    <thead class="text-center">
                                        <tr><h4> A(z) ${actualProperty.name} speciális képesség adatai</h4></tr>    
                                    </thead>
                                </table>
                                <table class="table-striped">
                                    <thead class="text-center">
                                        <tr>
                                            <th>Id</th><th>Elnevezés</th><th>Leíras</th><th>Fajhoz rendelés</th><th>Level</th><th>Véderő</th><th>Támadási érték</th>
                                        </tr>
                                    </thead>
                                    <tbody class="text-center">
                                        <tr>
                                            <td><input name="sspid" value="${actualProperty.id}" disabled />
                                            <input name="hsspid" value="${actualProperty.id}" type="hidden" /></td>
                                            <td><input name="sspname" value="${actualProperty.name}" disabled />
                                            <input name="hsspname" value="${actualProperty.name}" type="hidden" /></td>
                                            <td><input name="sspdesc" value="${actualProperty.description}" /></td>
                                            <td>
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
                                            </td>
                                            <td><input name="ssplevel" value="${actualProperty.level}" /></td>
                                            <td><input name="sspdefense" value="${actualProperty.defense}" /></td>
                                            <td><input name="sspdamage" value="${actualProperty.damage}" /></td>
                                        </tr>
                                    </tbody>
                                </table>
                                <div><input type="submit" name="modifySsp" value="Módosít" class="btn btn-primary"></div>
                                </c:if>
                            </tr>
                        </tbody>
                    </table>
                </fieldset>
            </form>
        </div>
    </body>
</html>
