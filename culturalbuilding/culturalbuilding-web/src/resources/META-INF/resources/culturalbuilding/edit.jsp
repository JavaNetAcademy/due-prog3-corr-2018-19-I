<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Cultural Buildings</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="/buildings/cultural/edit" method="post" style="float:left;">
            <fieldset>
                <legend>Cultural Buildings - ${cbuilding.name} - Szerkesztés</legend>

                <table>
                    <thead>
                        <tr>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><label>Név</label></td>
                            <td><input type="text" value="${cbuilding.name}" name="pname" /></td>
                        </tr>
                        <tr>
                            <td><label>Leírás</label></td>
                            <td><input type="text" value="${cbuilding.description}" name="pdesc" /></td>
                        </tr>
                    </tbody>
                </table>
                <input type="hidden" value="${cbuilding.id}" name="cbuildingId" />
                <input type="hidden" value="${cbuilding.name}" name="originalName" />

                <div>
                    <input type="submit" value="Mentés">
                    <a href="/buildings/cultural">Vissza</a>
                </div>  
            </fieldset>
        </form>         
    </body>
</html>
