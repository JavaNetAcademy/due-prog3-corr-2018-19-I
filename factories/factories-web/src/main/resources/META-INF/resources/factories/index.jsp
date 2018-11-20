<%-- 
    Document   : index
    Created on : 0000.00.00., 00:00:00
    Author     : jrajmund
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Gyárak</title>
    </head>
    <body>
        <!--<h1>${user.name} gyárai</h1>-->
        <form action="factories" method="post">
            <fieldset>
                <legend>Gyár létrehozás</legend>
                <div>
                    <label>Név:</label>
                    <input type="text" name="pname">
                </div>
                <div>
                    <label>Leírás:</label>
                    <input type="text" name="pdesc">
                </div>
                <div>
                    <label>Birodalom: </label>
                    <select name="pemp">
                        <c:forEach items="${empiresList}" var="x">
                            <option value="${x.id}"><c:out value="${x.name}" /></option>
                        </c:forEach>
                    </select>
                </div>
                <input type="submit" value="Hozzáad">
            </fieldset>
        </form>
    </body>
</html>  