<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Támadó fegyverek</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Fegyver letrehozasa</h1>
        <form method="post" action="${pageContext.request.contextPath}/weapons/create">
            <div>
                <span>Fegyver neve</span>
                <input type="text" name="name" />
            </div>
            <div>
                <span>Fegyver leirasa</span>
                <textarea name="description"></textarea>
            </div>
            <div>
                <span>Fegyver ara</span>
                <input type="number" name="price" />
            </div>
            <input type="submit" value="Mentes">
        </form>
    </body>
</html>

