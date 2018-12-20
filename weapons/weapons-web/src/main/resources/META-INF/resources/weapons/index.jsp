<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>T�mad� fegyverek</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <jsp:include page="/user/menu.jsp"></jsp:include>
        
        <div class="container">
            <fieldset>
                <legend>Fegyver lista <a class="btn btn-primary" href="/weapons/create">�j fegyver</a></legend>
                
                <table class="table">
                    <thead>
                        <tr>
                            <th>N�v (le�r�s)</th>
                            <th>�r</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${weapons}" var="weapon">
                            <tr>
                                <td><span>${weapon.name} (${weapon.description})</span></td>
                                <td>
                                    ${weapon.price}
                                </td>
                                <td>
                                    <a class="btn btn-light" href="<c:url value="/weapons/edit">
                                           <c:param name="id" value="${weapon.id}"/>
                                       </c:url>"
                                       >Szerkeszt�s</a>
                                    <a class="btn btn-danger" href="<c:url value="/weapons/delete">
                                           <c:param name="id" value="${weapon.id}"/>
                                       </c:url>"
                                       >T�rl�s</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </fieldset>
        </div>
    </body>
</html>

