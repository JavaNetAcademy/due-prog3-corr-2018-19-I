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
        <%@ include file = "/user/menu.jsp" %>
    <center>
        <div class="container">
            <div class="w-75 p-3" style="background-color: #eee;">
                <h1>${user.name} gyárak</h1>
            </div>
            </br>
            <div class="w-75 p-3" style="background-color: #eee;">
                <table class="table table-bordered">
                    <thead class="thead-light">
                        <tr>
                            <th>Név</th>
                            <th>Leírás</th>
                            <th>Birodalom szint</th>
                        </tr>
                    </thead>
                    <c:forEach var="fact" items="${factories}">
                        <tbody>
                            <tr>
                                <td>${fact.name}</td>
                                <td>${fact.description}</td>
                                <td></td>
                            </tr>
                        </tbody>
                    </c:forEach>
                </table>
            </div>
            </br>
            <div class="w-50 p-3" style="background-color: #eee;">
                <form action="factories" method="post">
                    <fieldset>
                        <legend>Új gyár</legend>
                        <div class="text-left">
                            <label>Név:</label>
                            <input type="text" name="pname" class="form-control">
                        </div>
                        <div class="text-left">
                            <label>Leírás:</label>
                            <input type="textarea" name="pdesc" class="form-control">
                        </div>
                        <div class="text-left">
                            <label>Birodalom: </label>
                            <select name="pemp" class="form-control">
                                <c:forEach items="${empiresList}" var="x">
                                    <option value="${x.id}"><c:out value="${x.name}" /></option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="text-left">
                            <label>Birodalom szint:</label><br/>
                            <input class="form-control" type="text" placeholder="1" readonly>
                        </div>
                        </br>
                        <div class="text-left">
                            <input type="submit" value="Hozzáadás" class="btn btn-primary">
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
        </br>
        <div class="container">
            <div class="w-50 p-3" style="background-color: #eee;">
                <form action="/factoriesedit" method="post">
                    <legend>Kiválasztott gyár törlése</legend>
                    <table class="table">
                        <tr>
                            <td>
                                <select name="selectedFactory" class="form-control">
                                    <c:forEach var="fact" items="${factories}">
                                        <option value="${fact.id}">${fact.name}</option>
                                    </c:forEach>
                                </select>
                            </td> 
                            <td>
                                <input type="submit" name="delete" value="Törlés" class="btn btn-primary" onclick="return confirm('Biztosan törlöd ezt a gyárat?')">
                            </td>
                        </tr>
                    </table>
                    </br>
                    <div>
                        <fieldset>
                            <legend>Kiválasztott gyár módosítása</legend>
                            <div class="text-left">
                                <label>Új név: </label>
                                <input type="text" name="newfname" class="form-control">
                            </div>
                            <div class="text-left">
                                <label>Új leírás: </label>
                                <input type="textarea" name="newfdesc" class="form-control">
                            </div>
                            </br>
                            <div class="text-left">
                                <input type="submit" name="modify" value="Módosítás" class="btn btn-primary" onclick="return confirm('Biztosan módosítod ezt a gyárat?')">
                            </div>
                        </fieldset>
                    </div>
                </form>
            </div>
        </div>
    </center>
</body>
</html>  