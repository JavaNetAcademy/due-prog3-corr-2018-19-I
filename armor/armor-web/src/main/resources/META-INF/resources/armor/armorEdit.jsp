<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>P�nc�l szerkeszt�s</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <jsp:include page="/user/menu.jsp"></jsp:include>

            <div class="container"> 
                <div class="w-75 p-3" style="background-color: #eee;">
                    <form action="armor?operation=aUp" method="post">
                        <fieldset>
                            <legend> ${armor.name} p�nc�l szerkeszt�se</legend>
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
                                    <td><input type="text" value="${armor.name}" name="name" class="form-control"/></td>
                                </tr>
                                <tr>
                                    <td><label>Le�r�s</label></td>
                                    <td><input type="text" value="${armor.description}" name="description" class="form-control" /></td>
                                </tr>   
                                <tr>
                                    <td><label>�rt�k</label></td>
                                    <td><input type="text" value="${armor.price}" name="price" class="form-control" /></td>
                                </tr>
                            </tbody>
                        </table>
                        <input type="hidden" value="${armor.id}" name="armorId" /> 
                        <div>
                            <input type="submit" value="Ment�s" class="btn btn-primary">
                            <a href="/empires" class="btn btn-light">Vissza</a>

                        </div>  

                    </fieldset>
                </form>
            </div>
        </div>
    </body>
</html>
