<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Támadó fegyverek</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <jsp:include page="/user/menu.jsp"></jsp:include>
        
        <div class="container">
            <fieldset>
                <legend>Fegyver torlese (${weapon.name})</legend>
            
                <form method="post" action="${pageContext.request.contextPath}/weapons/delete">
                    <div>
                        <span>Fegyver neve: ${weapon.name}</span>
                    </div>
                    <div>
                        <span>Fegyver leirasa: ${weapon.description}</span>
                    </div>
                    <div>
                        <span>Fegyver ara: ${weapon.price}</span>
                    </div>

                    <input type="submit" value="Torles" class="btn btn-danger">
                    <a href="/weapons" class="btn btn-light">Vissza</a>
                </form>
            </fieldset>
        </div>
    </body>
</html>

