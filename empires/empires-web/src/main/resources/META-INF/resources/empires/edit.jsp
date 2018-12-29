<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Empires_Edit</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <jsp:include page="/user/menu.jsp"></jsp:include>

            <div class="container"> 
                <div class="w-75 p-3" style="background-color: #eee;">
                    <form action="edit" method="post">
                        <fieldset>
                            <legend>Birodalom ${empires.name} Szerkesztés</legend>
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
                                    <td><input type="text" value="${empires.name}" name="pname" class="form-control"/></td>
                                </tr>
                                <tr>
                                    <td><label>Leírás</label></td>
                                    <td><input type="text" value="${empires.description}" name="pdescription" class="form-control" /></td>
                                </tr>  
                                <tr>
                                    <td><label>User</label></td>
                                    <td><span>${user.name}</span></td> 

                                </tr>
                                <tr>
                                    <td><label>Szint</label></td>
                                    <td><input type="text" value="${empires.level}" name="plevel" class="form-control" /></td>
                                </tr>
                                <tr>
                                    <td><label>Vagyon</label></td>
                                    <td><input type="text" value="${empires.property}" name="pproperty" class="form-control" /></td>
                                </tr>
                            </tbody>
                        </table>
                        <input type="hidden" value="${empires.id}" name="empiresid" />
                        <input type="hidden" value="${empires.name}" name="originalName" />
                        <div>
                            <input type="submit" value="Mentés" class="btn btn-primary">
                            <a href="/empires" class="btn btn-light">Vissza</a>

                        </div>  

                    </fieldset>
                </form>
            </div>
        </div>
    </body>
</html>
