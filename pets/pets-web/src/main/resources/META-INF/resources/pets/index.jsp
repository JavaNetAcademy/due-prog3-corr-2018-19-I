<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Pets</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <jsp:include page="/user/menu.jsp"></jsp:include>

            <div class="container">
                <form action="pets" method="get">
                    <fieldset>
                        <legend>Pet lista</legend>

                        <table class="table">
                            <thead>
                                <tr>
                                    <th>N�v (le�r�s)</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="item" items="${petList}">
                                <tr>
                                    <td><span>${item.name} (${item.description})</span></td>
                                    <td>
                                        <a class="btn btn-light" href="<c:url value="/petedit">
                                               <c:param name="petid" value="${item.id}"/>
                                           </c:url>"
                                           >Szerkeszt�s</a>
                                        <a class="btn btn-danger" href="<c:url value="/petdelete">
                                               <c:param name="petid" value="${item.id}"/>
                                           </c:url>"
                                           >T�rl�s</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </fieldset>
            </form>

            <form action="pets" method="post">
                <fieldset>
                    <legend>Pet l�trehoz�s</legend>

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
                                <td><input name="pname" class="form-control" /></td>
                            </tr>
                            <tr>
                                <td><label>Le�r�s</label></td>
                                <td><input type="textarea" name="pdesc" class="form-control" /></td>
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
                        </tbody>
                    </table>
                    <div><input type="submit" value="Hozz�ad" class="btn btn-primary"></div>            
            </form>
        </div>
    </body>
</html>
