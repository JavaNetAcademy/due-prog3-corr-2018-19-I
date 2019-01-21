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
                    <legend>Uj Vehicle  hozzaadasa</legend>

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
                                <td><input type="textarea" name="pname" class="form-control" /></td>
                            </tr>
                            <tr>
                                <td><label>Leiras</label></td>
                                <td><input type="textarea" name="pdescription" class="form-control" /></td>
                            </tr>
                            <tr>
                                <td><label>Atlagsebesseg</label></td>
                                <td><input type="textarea" name="pavgspeed" class="form-control" /></td>
                            </tr>
                            <tr>
                                <td><label>Legnagyobb sebesseg</label></td>
                                <td><input type="textarea" name="pmaxspeed" class="form-control" /></td>
                            </tr>
                            <tr>
                                <td><label>Legnagyobb sebesseg mennyi ideig tarthato</label></td>
                                <td><input type="textarea" name="pmaxspeedtimeout" class="form-control" /></td>
                            </tr>
                            <tr>
                                <td><label>Maximum rakomany sulya</label></td>
                                <td><input type="textarea" name="pmaxload" class="form-control" /></td>
                            </tr>
                            <tr>
                                <td><label>Szukseges legenyseg letszama</label></td>
                                <td><input type="textarea" name="pcrew" class="form-control" /></td>
                            </tr>
                            <tr>
                                <td><label>Ar</label></td>
                                <td><input type="textarea" name="pprice" class="form-control" /></td>
                            </tr>
                        </tbody>
                    </table>
                    <div><input type="submit" value="Hozzaad" class="btn btn-primary"></div>
            </form>
        </div>
    </body>
</html>
