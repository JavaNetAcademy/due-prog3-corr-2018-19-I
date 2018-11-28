<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Species_Edit</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="/speciesedit" method="post" style="float:left;">
            <fieldset>
                <legend>Species ${species.name} Szerkeszt�s</legend>
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
                            <td><input type="text" value="${species.name}" name="pname" /></td>
                        </tr>
                        <tr>
                            <td><label>Le�r�s</label></td>
                            <td><input type="text" value="${species.description}" name="pdescription" /></td>
                        </tr>  
                       
                    </tbody>
                </table>
                <input type="hidden" value="${species.id}" name="speciesid" />
                <input type="hidden" value="${species.name}" name="originalSpeciesName" />


                <div>
                    <input type="submit" value="Ment�s">
                    <a href="/species">Vissza</a>

                </div>  

            </fieldset>
        </form>         
    </body>
</html>
