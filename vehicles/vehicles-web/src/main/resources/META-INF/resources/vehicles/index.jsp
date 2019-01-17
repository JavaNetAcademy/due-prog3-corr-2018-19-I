<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Vehicles</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <jsp:include page="/user/menu.jsp"></jsp:include>

            <div class="container">
                <form action="vehicles" method="get">
                    <fieldset>
                        <legend>Vehicle lista</legend>

                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Nev (leiras)</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="item" items="${vehicleList}">
                                <tr>
                                    <td><span>${item.name} (${item.description})</span></td>
                                    <td>
                                        <a class="btn btn-light" href="<c:url value="/vehicleedit">
                                               <c:param name="vehicleid" value="${item.id}"/>
                                           </c:url>"
                                           >Szerkesztes</a>
                                        <a class="btn btn-danger" href="<c:url value="/vehicledelete">
                                               <c:param name="vehicleid" value="${item.id}"/>
                                           </c:url>"
                                           >Torles</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </fieldset>
            </form>

            <form action="vehicles" method="post">
                <fieldset>
                    <legend>Vehicle letrehozas</legend>

                    <table class="table">
                        <thead>
                            <tr>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><label>Nev</label></td>
                                <td><input name="pname" class="form-control" /></td>
                            </tr>
                            <tr>
                                <td><label>Leiras</label></td>
                                <td><input type="textarea" name="pdesc" class="form-control" /></td>
                            </tr>
                            <tr>
                                <td><label>Hos</label></td>
                                <td>
                                    <select name="hero" class="form-control">
                                        <c:forEach items="${heroList}" var="x">
                                            <option value="${x.id}"><c:out value="${x.name}" /></option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <div><input type="submit" value="Hozzáad" class="btn btn-primary"></div>
            </form>
        </div>
    </body>
</html>
