<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Job</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="job" method="get" style="float:left;">      
            <fieldset>
                <legend>Munkakör lista:</legend>

                <table>
                    <thead>
                        <tr>
                            <th>Név (leírás)</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="onejob" items="${jobList}">
                            <tr>
                                <td><span>${onejob.name} (${onejob.description})</span></td>
                                <td>
                                    <a href="<c:url value="/jobedit">
                                           <c:param name="jobid" value="${onejob.id}"/>
                                 </c:url>"
                                    >Szerkesztés</a>
                                </td>
                                <td>
                                    <a href="<c:url value="/jobdel">
                                           <c:param name="jobid" value="${onejob.id}"/>
                                 </c:url>"
                                    >Törlés</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </fieldset>
        </form>
         <form action="job" method="post" style="float:left;">
            <fieldset>

                <legend>Munka létrehozása</legend>
                <P>
                <div>
                    <label>Munka neve</label>
                    <input name="pname">
                </div>
                <P>
                <div>
                    <label>Munka leírása</label>
                    <input name="pdescription">
                </div>
                <P>

                <div>
                    <input type="submit" value="Létrehoz">
                </div> 
        </form>
    </body>
</html>
