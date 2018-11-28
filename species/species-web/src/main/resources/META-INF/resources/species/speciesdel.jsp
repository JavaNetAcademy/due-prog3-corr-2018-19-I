

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Species_Del</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="speciesdel" method="post" style="float:left;">
            <fieldset>
                <legend>species  ${species.name}  Törlés</legend>

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
                            <td><span>${species.name}</span></td>
                        </tr>
                        <tr>
                            <td><label>Leírás</label></td>
                            <td><span>${species.description}</span></td>
                        </tr>
                       
                    </tbody>
                </table>
                <input type="hidden" value="${species.id}" name="speciesid" />

                <h4>Biztos törölni akarod a speciest?</h4>
                <div style="display:block;">
                    <input type="submit" value="Törlés">
                    <a href="/species">Vissza</a>
                </div>  
            </fieldset>
        </form>         
    </body>
</html>
