

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Hero_Del</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="herodel" method="post" style="float:left;">
            <fieldset>
                <legend>Hero  ${hero.name}  Törlés</legend>

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
                            <td><span>${hero.name}</span></td>
                        </tr>
                        <tr>
                            <td><label>Leírás</label></td>
                            <td><span>${hero.description}</span></td>
                        </tr>
                       
                    </tbody>
                </table>
                <input type="hidden" value="${hero.id}" name="heroid" />

                <h4>Biztos törölni akarod a hero-t?</h4>
                <div style="display:block;">
                    <input type="submit" value="Törlés">
                    <a href="/hero">Vissza</a>
                </div>  
            </fieldset>
        </form>         
    </body>
</html>
