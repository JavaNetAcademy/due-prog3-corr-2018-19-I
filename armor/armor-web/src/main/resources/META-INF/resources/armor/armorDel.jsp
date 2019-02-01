<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>P�nc�l t�rl�s</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <jsp:include page="/user/menu.jsp"></jsp:include>

            <div class="container">
                <div class="w-75 p-3" style="background-color: #eee;">
                    <form action="armor?operation=aDel" method="post">
                        <fieldset>
                            <legend> ${armor.name} p�nc�l t�rl�se</legend>

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
                                    <td><span>${armor.name}</span></td>
                                </tr>
                                <tr>
                                    <td><label>Le�r�s</label></td>
                                    <td><span>${armor.description}</span></td>
                                </tr> 
                                <tr>
                                    <td><label>�rt�k</label></td>
                                    <td><span>${armor.price}</span></td>
                                </tr>
                            </tbody>
                        </table>
                        <input type="hidden" value="${armor.id}" name="armorId" />

                        <h4>Biztos t�r�lni akarod a p�nc�lt?</h4>
                        <div style="display:block;">
                            <input type="submit" value="T�rl�s" class="btn btn-danger">
                            <a href="/armor" class="btn btn-light">Vissza</a>
                        </div>  
                    </fieldset>
                </form>   
            </div> 
        </div>
    </body>
</html>
