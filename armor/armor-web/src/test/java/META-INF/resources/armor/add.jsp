<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
<form method="post" action="${pageContext.request.contextPath}/hero/hero">
    <div>
        <span>Neve</span>
        <input type="text" name="pname">
    </div>
    <div>
        <span>Leírás</span>
        <textarea name="pdesc"></textarea>
    </div>
        <div>
        <input type="submit" value="felvitel">
    </div>
</form>
    </body>
</html>
