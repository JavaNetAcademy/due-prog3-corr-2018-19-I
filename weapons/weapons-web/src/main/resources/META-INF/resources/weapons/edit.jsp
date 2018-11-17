<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Támadó fegyverek</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Fegyver modositasa (${weapon.name})</h1>
        <form method="post" action="${pageContext.request.contextPath}/weapons/edit">
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
            
            <input type="hidden" value="${weapon.id}" name="id" />
            <input type="hidden" value="${weapon.name}" name="originalName" />
            
            <input type="submit" value="Mentes">
        </form>
    </body>
</html>

