<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Species_Edit</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="/speciesedit" method="post" style="float:left;">
            <fieldset>
                <legend>Species ${species.name} Szerkesztés</legend>
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
                            <td><input type="text" value="${species.name}" name="pname" /></td>
                        </tr>
                        <tr>
                            <td><label>Leírás</label></td>
                            <td><input type="text" value="${species.description}" name="pdescription" /></td>
                        </tr>  
                       
                    </tbody>
                </table>
                <input type="hidden" value="${species.id}" name="speciesid" />
                <input type="hidden" value="${species.name}" name="originalSpeciesName" />


                <div>
                    <input type="submit" value="Mentés">
                    <a href="/species">Vissza</a>

                </div>  

            </fieldset>
        </form>         
    </body>
</html>
