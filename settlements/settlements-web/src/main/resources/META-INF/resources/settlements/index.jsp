<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Települések</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="settlements" method="get" style="float:left;">
            <fieldset>
                <legend>Település lista</legend>

                <table>
                    <thead>
                        <tr>
                            <th>Név (leírás)</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="item" items="${settlementsList}">
                            <tr>
                                <td><span>${item.name} (${item.description})</span></td>
                                <td>
                                    <a href="<c:url value="/settlementsedit">
                                           <c:param name="settlementsid" value="${item.id}"/>
                                       </c:url>"
                                    >Szerkesztés</a>
                                     <a href="<c:url value="/settlementsdelete">
                                           <c:param name="settlementsid" value="${item.id}"/>
                                       </c:url>"
                                    >Törlés</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </fieldset>
        </form>

        <form action="settlements" method="post" style="float:left;">
            <fieldset>
                <legend>Település létrehozás</legend>

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
                            <td><input name="pname" /></td>
                        </tr>
                        <tr>
                            <td><label>Leírás</label></td>
                            <td><input type="textarea" name="pdesc" /></td>
                        </tr>
                        <tr>
                            <td><label>Birodalom</label></td>
                            <td>
                                <select name="empires">
                                    <c:forEach items="${empiresList}" var="x">
                                        <option value="${x.id}"><c:out value="${x.name}" /></option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <div><input type="submit" value="Hozzáad"></div>            
        </form>
    </body>
</html>
