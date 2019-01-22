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
                                    <th>Név (leírás)</th>
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
                                           >Szerkesztés</a>
                                        <a class="btn btn-danger" href="<c:url value="/vehicledelete">
                                               <c:param name="vehicleid" value="${item.id}"/>
                                           </c:url>"
                                           >Törlés</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </fieldset>
            </form>

            <form action="vehicles" method="post">
                <fieldset>
                    <legend>Új Vehicle  hozzáadása</legend>

                    <table class="table">
                        <thead>
                            <tr>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><label>Név</label></td>
                                <td><input type="textarea" name="pname" class="form-control" /></td>
                            </tr>
                            <tr>
                                <td><label>Leírás</label></td>
                                <td><input type="textarea" name="pdescription" class="form-control" /></td>
                            </tr>
                            <tr>
                                <td><label>Átlagsebesség</label></td>
                                <td><input type="textarea" name="pavgspeed" class="form-control" /></td>
                            </tr>
                            <tr>
                                <td><label>Legnagyobb sebesség</label></td>
                                <td><input type="textarea" name="pmaxspeed" class="form-control" /></td>
                            </tr>
                            <tr>
                                <td><label>Legnagyobb sebesség mennyi ideig tartható</label></td>
                                <td><input type="textarea" name="pmaxspeedtimeout" class="form-control" /></td>
                            </tr>
                            <tr>
                                <td><label>Maximum rakomány súlya</label></td>
                                <td><input type="textarea" name="pmaxload" class="form-control" /></td>
                            </tr>
                            <tr>
                                <td><label>Szükséges legénység létszáma</label></td>
                                <td><input type="textarea" name="pcrew" class="form-control" /></td>
                            </tr>
                            <tr>
                                <td><label>Ár</label></td>
                                <td><input type="textarea" name="pprice" class="form-control" /></td>
                            </tr>
                        </tbody>
                    </table>
                    <div><input type="submit" value="Hozzaad" class="btn btn-primary"></div>
            </form>
        </div>
    </body>
</html>
