<%-- 
    Author     : Szabó Viktor / mikulas975 / vts4gv
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Species Special Property - Create Page</title>
    </head>
    <body>        
    <jsp:include page="/user/menu.jsp"></jsp:include>
        <br>
        <nav class="nav nav-pills mb-2">
            <a class="nav-link" href="<c:url value="/speciesspecialproperty"></c:url>">Fajok speciális képességeinek listázása</a>
            <a class="nav-link active" href="#">Faj speciális képességének létrehozása</a>
            <a class="nav-link" href="<c:url value="/modssproperty"></c:url>">Faj speciális képességének módosítása</a>
            <a class="nav-link" href="<c:url value="/delssproperty"></c:url>">Faj speciális képességének törlése</a>
        </nav>
        <div class="container">
            <form action="/newssproperty" method="post">
                <fieldset>
                    <h3>Új speciális képesség létrehozása</h3>

                    <table class="table">
                        <thead>
                            <tr>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><label>Képesség neve</label></td>
                                <td><input type="text" name="sspname" class="form-control" /></td>
                            </tr>
                            <tr>
                                <td><label>Leírás</label></td>
                                <td><input type="textarea" name="sspdesc" class="form-control" /></td>
                            </tr>
                            <tr>
                                <td><label>Fajhoz rendelés</label></td>
                                <td>
                                    <select name="species" class="form-control">
                                        <c:forEach items="${speciesList}" var="sp">
                                            <option value="${sp.id}">${sp.name}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td><label>Level</label></td>
                                <td><input type="number" min="0" max="2147483647" name="ssplevel" class="form-control" /></td>
                            </tr>
                            <tr>
                                <td><label>Defense</label></td>
                                <td><input type="number" min="0" max="2147483647" name="sspdefense" class="form-control" /></td>
                            </tr>
                            <tr>
                                <td><label>Damage</label></td>
                                <td><input type="number" min="0" max="2147483647" name="sspdamage" class="form-control" /></td>
                            </tr>
                        </tbody>
                    </table>
                    <div><input type="submit" value="Létrehoz" class="btn btn-primary"></div>
                </fieldset>
            </form>
        </div>
    </body>
</html>

