<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Támadó fegyverek</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Fegyver torlese (${weapon.name})</h1>
        <form method="post" action="${pageContext.request.contextPath}/weapons/delete">
            <div>
                <span>Fegyver neve ${weapon.name}</span>
            </div>
            <div>
                <span>Fegyver leirasa ${weapon.description}</span>
            </div>
            <div>
                <span>Fegyver ara: ${weapon.price}</span>
            </div>
            
            <input type="submit" value="Torles">
            <a href="/weapons">Vissza</a>
        </form>
    </body>
</html>

