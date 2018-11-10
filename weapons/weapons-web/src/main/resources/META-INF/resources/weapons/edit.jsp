<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>T�mad� fegyverek</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Fegyver modositasa (${weapon.name})</h1>
        <form method="post" action="${pageContext.request.contextPath}/weapons/create">
            <div>
                <span>Fegyver neve</span>
                <input type="text" name="name" value="${weapon.name}" />
            </div>
            <div>
                <span>Fegyver leirasa</span>
                <textarea name="description">${weapon.description}</textarea>
            </div>
            <div>
                <span>Fegyver ara</span>
                <input type="number" name="price" value="${weapon.price}" />
            </div>
            <input type="submit" value="Mentes">
        </form>
    </body>
</html>

