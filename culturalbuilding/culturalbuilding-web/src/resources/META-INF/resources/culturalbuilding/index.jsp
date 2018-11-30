<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Cultural Buildings</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="/buildings/cultural" method="get" style="float:left;">
            <fieldset>
                <legend>Cultural building lista</legend>

                <table>
                    <thead>
                        <tr>
                            <th>N�v (le�r�s)</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="item" items="${cbuildingList}">
                            <tr>
                                <td><span>${item.name} (${item.description})</span></td>
                                <td>
                                    <a href="<c:url value="/building/cultural/edit">
                                           <c:param name="cbuildingId" value="${item.id}"/>
                                       </c:url>"
                                    >Szerkeszt�s</a>
                                     <a href="<c:url value="/building/cultural/delete">
                                           <c:param name="cbuildingId" value="${item.id}"/>
                                       </c:url>"
                                    >T�rl�s</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </fieldset>
        </form>

        <form action="/buildings/cultural" method="post" style="float:left;">
            <fieldset>
                <legend>Cultural building l�trehoz�s</legend>

                <table>
                    <thead>
                        <tr>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><label>N�v</label></td>
                            <td><input name="pname" /></td>
                        </tr>
                        <tr>
                            <td><label>Le�r�s</label></td>
                            <td><input type="textarea" name="pdesc" /></td>
                        </tr>
                    </tbody>
                </table>
                <div><input type="submit" value="Hozz�ad"></div>            
        </form>
    </body>
</html>
