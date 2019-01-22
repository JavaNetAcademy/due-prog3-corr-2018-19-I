<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Vehicle</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <jsp:include page="/user/menu.jsp"></jsp:include>

            <div class="container">
                <form action="vehicledelete" method="post">
                    <fieldset>
                        <legend>Vehicle - ${vehicle.name} - Törlés</legend>

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
                                <td><span>${vehicle.name}</span></td>
                            </tr>
                            <tr>
                                <td><label>Leírás</label></td>
                                <td><span>${vehicle.description}</span></td>
                            </tr>
                            <tr>
                                <td><label>Átlagsebesség</label></td>
                                <td><span>${vehicle.avgSpeed}</span></td>
                            </tr>
                            <tr>
                                <td><label>Legnagyobb sebesség</label></td>
                                <td><span>${vehicle.maxSpeed}</span></td>
                            </tr>
                            <tr>
                                <td><label>Legnagyobb sebesség mennyi ideig tartható</label></td>
                                <td><span>${vehicle.maxSpeedTimeout}</span></td>
                            </tr>
                            <tr>
                                <td><label>Maximum rakomány súlya</label></td>
                                <td><span>${vehicle.maxLoad}</span></td>
                            </tr>
                            <tr>
                                <td><label>Szükséges legénység létszáma</label></td>
                                <td><span>${vehicle.crew}</span></td>
                            </tr>
                            <tr>
                                <td><label>Ár</label></td>
                                <td><span>${vehicle.price}</span></td>
                            </tr>
                        </tbody>
                    </table>
                    <input type="hidden" value="${vehicle.id}" name="vehicleid" />

                    <h4>Biztos törölni akarod?</h4>
                    <div style="display:block;">
                        <input type="submit" value="Törlés" class="btn btn-danger">
                        <a href="/vehicles" class="btn btn-light">Vissza</a>
                    </div>
                </fieldset>
            </form>
        </div>
    </body>
</html>
