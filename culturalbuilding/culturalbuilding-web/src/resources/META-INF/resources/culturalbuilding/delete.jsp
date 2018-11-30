<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Cultural Buildings</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="/buildings/cultural/delete" method="post" style="float:left;">
            <fieldset>
                <legend>Cultural Buildings - ${cbuilding.name} - T�rl�s</legend>

                <table>
                    <thead>
                        <tr>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><label>N�v</label></td>
                            <td><span>${cbuilding.name}</span></td>
                        </tr>
                        <tr>
                            <td><label>Le�r�s</label></td>
                            <td><span>${cbuilding.description}</span></td>
                        </tr>
                    </tbody>
                </table>
                <input type="hidden" value="${cbuilding.id}" name="cbuildingId" />

                <h4>Biztos t�r�lni akarod az �p�letet?</h4>
                <div style="display:block;">
                    <input type="submit" value="T�rl�s">
                    <a href="/buildings/cultural/">Vissza</a>
                </div>  
            </fieldset>
        </form>         
    </body>
</html>
