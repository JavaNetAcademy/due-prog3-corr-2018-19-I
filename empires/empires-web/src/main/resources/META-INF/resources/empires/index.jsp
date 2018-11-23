<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Empires</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <jsp:include page="/user/menu.jsp"></jsp:include>

            <div class="w-75 p-3" style="background-color: #eee; text-align: center;" ><h1>Birodalmak</h1></div>
            </br>
            <div class="container">

                <div class="w-50 p-3" style="background-color: #eee;">
                    <form action="empires" method="post">
                        <fieldset>

                            <legend>Birodalom létrehozása</legend>
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><label>Birodalom neve:</label></td>
                                        <td><input name="pname" class="form-control" /></td>
                                    </tr>
                                <th></th>
                                <th></th>
                                <tr> 
                                    <td><label>Birodalom leírása:</label><td>
                                    <td><input type="textarea" name="pdescription" class="form-control"/></td>
                                </tr>                           
                                </tbody>
                            </table>       
                            <div><input type="submit" value="Létrehoz" class="btn btn-primary"></div> 
                    </form>
                </div> 
                </br>

                <div class="w-75 p-3" style="background-color: #eee;">
                    <form action="empires" method="get" >      
                        <fieldset>
                            <legend>Birodalom lista:</legend>

                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Név</th><th>Leírás</th><th>Felhasználó Név</th><th>UserId</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="oneempires" items="${empiresList}">
                                    <tr>
                                        <td><span>${oneempires.name} </span></td><td><span>${oneempires.description}</span></td><td><span>${user.name}</span></td><td><span>${oneempires.userid}</span></td>
                                        <td>
                                            <a class="btn btn-light" href="<c:url value="/edit"> 
                                                   <c:param name="empiresid" value="${oneempires.id}"/>
                                               </c:url>"
                                               >Szerkesztés</a>


                                            <a class="btn btn-danger" href="<c:url value="/del">
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
            </div>
         </div>
    </body>
</html>
