<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Pets</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <jsp:include page="/user/menu.jsp"></jsp:include>

            <div class="container">
                <form action="petedit" method="post">
                    <fieldset>
                        <legend>Pet - ${pet.name} - Szerkeszt�s</legend>

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
                                <td><input type="text" value="${pet.name}" name="pname" class="form-control" /></td>
                            </tr>
                            <tr>
                                <td><label>Le�r�s</label></td>
                                <td><input type="text" value="${pet.description}" name="pdesc" class="form-control" /></td>
                            </tr>
                            <tr>
                                <td><label>H�s</label></td>
                                <td>
                                    <select name="hero" class="form-control">
                                        <c:forEach items="${heroList}" var="x">
                                            <option value="${x.id}"><c:out value="${x.name}" /></option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td><label>Szint</label></td>
                                <td><span>${pet.level}</span></td>
                            </tr>
                            <tr>
                                <td><label>T�mad�s</label></td>
                                <td><span>${pet.damage}</span></td>
                            </tr>
                            <tr>
                                <td><label>V�d�s</label></td>
                                <td><span>${pet.defense}</span></td>
                            </tr>
                        </tbody>
                    </table>
                    <input type="hidden" value="${pet.id}" name="petid" />
                    <input type="hidden" value="${pet.name}" name="originalName" />

                    <div>
                        <input type="submit" value="Ment�s" class="btn btn-primary">
                        <a href="/pets" class="btn btn-light">Vissza</a>
                    </div>  
                </fieldset>
            </form>   
        </div>
    </body>
</html>
