<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Pets</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <jsp:include page="/user/menu.jsp"></jsp:include>

            <div class="container">
                <form action="petdelete" method="post">
                    <fieldset>
                        <legend>Pet - ${pet.name} - Törlés</legend>

                    <table class="table">
                        <thead>
                            <tr>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><label>Név</label></td>
                                <td><span>${pet.name}</span></td>
                            </tr>
                            <tr>
                                <td><label>Leírás</label></td>
                                <td><span>${pet.description}</span></td>
                            </tr>
                            <tr>
                                <td><label>Hös</label></td>
                                <td><span>${heroName}</span></td>
                            </tr>
                            <tr>
                                <td><label>Szint</label></td>
                                <td><span>${pet.level}</span></td>
                            </tr>
                            <tr>
                                <td><label>Támadás</label></td>
                                <td><span>${pet.damage}</span></td>
                            </tr>
                            <tr>
                                <td><label>Védés</label></td>
                                <td><span>${pet.defense}</span></td>
                            </tr>
                        </tbody>
                    </table>
                    <input type="hidden" value="${pet.id}" name="petid" />

                    <h4>Biztos törölni akarod a pet-et?</h4>
                    <div style="display:block;">
                        <input type="submit" value="Törlés" class="btn btn-danger">
                        <a href="/pets" class="btn btn-light">Vissza</a>
                    </div>  
                </fieldset>
            </form>  
        </div>
    </body>
</html>
