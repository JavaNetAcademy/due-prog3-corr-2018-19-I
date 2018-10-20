<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Empires</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="empires" method="get" style="float:left;">      
            <fieldset>
                <legend>Birodalom lista:</legend>

                <table>
                    <thead>
                        <tr>
                            <th>Név (leírás)</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="oneempires" items="${empiresList}">
                            <tr>
                                <td><span>${oneempires.name} (${oneempires.description})</span></td>
                                <td>
                                    <a href="<c:url value="/edit">
                                           <c:param name="empiresid" value="${oneempires.id}"/>
                                 </c:url>"
                                    >Szerkesztés</a>
                                </td>
                                <td>
                                    <a href="<c:url value="/del">
                                           <c:param name="empiresid" value="${oneempires.id}"/>
                                 </c:url>"
                                    >Törlés</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </fieldset>
        </form>
         <form action="empires" method="post" style="float:left;">
            <fieldset>

                <legend>Birodalom létrehozása</legend>
                <P>
                <div>
                    <label>Birodalom neve</label>
                    <input name="pname">
                </div>
                <P>
                <div>
                    <label>Birodalom leírása</label>
                    <input name="pdescription">
                </div>
                <P>

                <div>
                    <input type="submit" value="Létrehoz">
                </div> 
        </form>
    </body>
</html>
