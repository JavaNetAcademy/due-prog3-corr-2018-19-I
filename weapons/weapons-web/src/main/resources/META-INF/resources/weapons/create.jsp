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
                <legend>Fegyver letrehozasa</legend>

                <form method="post" action="${pageContext.request.contextPath}/weapons/create">
                    <div class="form-group">
                        <label for="name">Fegyver neve</label>
                        <input type="text" name="name" id="name" class="form-control" />
                    </div>
                    <div class="form-group">
                        <label for="description">Fegyver leirasa</label>
                        <textarea name="description" id="description" class="form-control"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="price">Fegyver ara</label>
                        <input type="number" name="price" id="price" class="form-control" />
                    </div>
                    <input type="submit" value="Mentes" class="btn btn-primary">
                </form>
            </fieldset>
        </div>
    </body>
</html>

