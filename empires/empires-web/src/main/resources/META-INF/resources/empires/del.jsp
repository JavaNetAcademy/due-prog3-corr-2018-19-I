

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Empires_Del</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <jsp:include page="/user/menu.jsp"></jsp:include>

            <div class="container">
                <div class="w-75 p-3" style="background-color: #eee;">
                    <form action="del" method="post">
                        <fieldset>
                            <legend>empires  ${empires.name}  Törlés</legend>

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
                                    <td><span>${empires.name}</span></td>
                                </tr>
                                <tr>
                                    <td><label>Leírás</label></td>
                                    <td><span>${empires.description}</span></td>
                                </tr>
                                <tr>
                                    <td><label>User</label></td>
                                     <td><span>${user.name}</span></td>                                    
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

                        <h4>Biztos törölni akarod a birodalmad?</h4>
                        <div style="display:block;">
                            <input type="submit" value="Törlés" class="btn btn-danger">
                            <a href="/empires" class="btn btn-light">Vissza</a>
                        </div>  
                    </fieldset>
                </form>   
            </div> 
        </div>
    </body>
</html>
