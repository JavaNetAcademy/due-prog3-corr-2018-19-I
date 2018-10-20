<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Empires_Edit</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="edit" method="post" style="float:left;">
            <fieldset>
                <legend>Birodalom ${empires.name} Szerkesztés</legend>
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
                            <td><input type="text" value="${empires.name}" name="pname" /></td>
                        </tr>
                        <tr>
                            <td><label>Leírás</label></td>
                            <td><input type="text" value="${empires.description}" name="pdescription" /></td>
                        </tr>  
                        <tr>
                            <td><label>User</label></td>
                            <td><span>${empires.userid}</span></td>
                        </tr>
                        <tr>
                            <td><label>Szint</label></td>
                            <td><span>${empires.level}</span></td>
                        </tr>
                        <tr>
                            <td><label>Vagyon</label></td>
                            <td><span>${empires.property}</span></td>
                        </tr>
                    </tbody>
                </table>
                <input type="hidden" value="${empires.id}" name="empiresid" />

                <div>
                    <input type="submit" value="Mentés">
                    <a href="/empires">Vissza</a>

                </div>  

            </fieldset>
        </form>         
    </body>
</html>
