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
                        <legend>Vehicle - ${vehicle.name} - T�rl�s</legend>

                    <table class="table">
                        <thead>
                            <tr>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><label>N�v</label></td>
                                <td><span>${vehicle.name}</span></td>
                            </tr>
                            <tr>
                                <td><label>Le�r�s</label></td>
                                <td><span>${vehicle.description}</span></td>
                            </tr>
                            <tr>
                                <td><label>�tlagsebess�g</label></td>
                                <td><span>${vehicle.avgSpeed}</span></td>
                            </tr>
                            <tr>
                                <td><label>Legnagyobb sebess�g</label></td>
                                <td><span>${vehicle.maxSpeed}</span></td>
                            </tr>
                            <tr>
                                <td><label>Legnagyobb sebess�g mennyi ideig tarthat�</label></td>
                                <td><span>${vehicle.maxSpeedTimeout}</span></td>
                            </tr>
                            <tr>
                                <td><label>Maximum rakom�ny s�lya</label></td>
                                <td><span>${vehicle.maxLoad}</span></td>
                            </tr>
                            <tr>
                                <td><label>Sz�ks�ges leg�nys�g l�tsz�ma</label></td>
                                <td><span>${vehicle.crew}</span></td>
                            </tr>
                            <tr>
                                <td><label>�r</label></td>
                                <td><span>${vehicle.price}</span></td>
                            </tr>
                        </tbody>
                    </table>
                    <input type="hidden" value="${vehicle.id}" name="vehicleid" />

                    <h4>Biztos t�r�lni akarod?</h4>
                    <div style="display:block;">
                        <input type="submit" value="T�rl�s" class="btn btn-danger">
                        <a href="/vehicles" class="btn btn-light">Vissza</a>
                    </div>
                </fieldset>
            </form>
        </div>
    </body>
</html>
