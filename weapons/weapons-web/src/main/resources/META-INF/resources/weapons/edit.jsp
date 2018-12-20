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
                <legend>Fegyver modositasa (${weapon.name})</legend>

                <form method="post" action="${pageContext.request.contextPath}/weapons/edit">
                    <div class="form-group">
                        <label for="name">Fegyver neve</label>
                        <input type="text" name="name" id="name" value="${weapon.name}" class="form-control" />
                    </div>
                    <div class="form-group">
                        <label for="description">Fegyver leirasa</label>
                        <textarea name="description" id="description" class="form-control">${weapon.description}</textarea>
                    </div>
                    <div class="form-group">
                        <label for="name">Fegyver ara</label>
                        <input type="number" name="price" id="price" class="form-control" value="${weapon.price}" />
                    </div>

                    <input type="hidden" value="${weapon.id}" name="id" />
                    <input type="hidden" value="${weapon.name}" name="originalName" />

                    <input type="submit" value="Mentes" class="btn btn-primary">
                </form>
            </fieldset>
        </div>
    </body>
</html>

