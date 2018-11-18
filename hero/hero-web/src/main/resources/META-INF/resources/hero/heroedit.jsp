<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Hero_Edit</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="/heroedit" method="post" style="float:left;">
            <fieldset>
                <legend>Hero ${hero.name} Szerkesztés</legend>
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
                            <td><input type="text" value="${hero.name}" name="pname" /></td>
                        </tr>
                        <tr>
                            <td><label>Leírás</label></td>
                            <td><input type="text" value="${hero.description}" name="pdescription" /></td>
                        </tr>  
                       
                    </tbody>
                </table>
                <input type="hidden" value="${hero.id}" name="heroid" />


                <div>
                    <input type="submit" value="Mentés">
                    <a href="/hero">Vissza</a>

                </div>  

            </fieldset>
        </form>         
    </body>
</html>
