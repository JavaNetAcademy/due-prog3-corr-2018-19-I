<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Hero</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="heroedit" method="get" style="float:left;">      
            <fieldset>
                <legend>Munkak�r lista:</legend>

                <table>
                    <thead>
                        <tr>
                            <th>N�v (le�r�s)</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="onehero" items="${heroList}">
                            <tr>
                                <td><span>${onehero.name} (${onehero.description})</span></td>
                                <td>
                                    <a href="<c:url value="/heroedit">
                                           <c:param name="heroid" value="${onehero.id}"/>
                                            <c:param name="heroname" value="${onehero.name}"/>
                                 </c:url>"
                                    >Szerkeszt�s</a>
                                </td>
                                <td>
                                    <a href="<c:url value="/herodel">
                                           <c:param name="heroid" value="${onehero.id}"/>
                                 </c:url>"
                                    >T�rl�s</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </fieldset>
        </form>
         <form action="/hero" method="post" style="float:left;">
            <fieldset>

                <legend>Hero l�trehoz�sa</legend>
                <P>
                <div>
                    <label>Hero neve</label>
                    <input name="pname">
                </div>
                <P>
                <div>
                    <label>Hero le�r�sa</label>
                    <input name="pdescription">
                </div>
                <P>
                <div>
                    <label>Hero munkak�re</label>
                                <select name="job">
                                    <c:forEach items="${jobList}" var="job">
                                        <option value="${job.id}"><c:out value="${job.name}" /></option>
                                    </c:forEach>
                                </select>
                </div>
                <div>
                    <input type="submit" value="L�trehoz">
                </div> 
        </form>
    </body>
</html>
