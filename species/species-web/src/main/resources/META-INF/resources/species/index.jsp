<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Species</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="species" method="get" style="float:left;">      
            <fieldset>
                <legend>Species lista:</legend>

                <table>
                    <thead>
                        <tr>
                            <th>N�v (le�r�s)</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="onespecies" items="${speciesList}">
                            <tr>
                                <td><span>${onespecies.name} (${onespecies.description})</span></td>
                                <td>
                                    <a href="<c:url value="/speciesedit">
                                           <c:param name="speciesid" value="${onespecies.id}"/>
                                 </c:url>"
                                    >Szerkeszt�s</a>
                                </td>
                                <td>
                                    <a href="<c:url value="/speciesdel">
                                           <c:param name="speciesid" value="${onespecies.id}"/>
                                 </c:url>"
                                    >T�rl�s</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </fieldset>
        </form>
         <form action="species" method="post" style="float:left;">
            <fieldset>

                <legend>Species l�trehoz�sa</legend>
                <P>
                <div>
                    <label>Species neve</label>
                    <input name="pname">
                </div>
                <P>
                <div>
                    <label>Species le�r�sa</label>
                    <input name="pdescription">
                </div>
                <P>

                <div>
                    <input type="submit" value="L�trehoz">
                </div> 
        </form>
    </body>
</html>
