<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="/reg" method="post">
            <fieldset>
                <legend>Regisztr�ci�</legend>
                <div>
                    <label>Felhaszn�l� neve</label>
                    <input name="pname">
                </div>
                <div>
                    <label>Jelsz� </label>
                    <input name="ppassword">
                </div>
                <div><input type="submit"></div>            
        </form>
        <form action="/login" method="post">
            <fieldset>
                <legend>Bejelentkez�s</legend>
                <div>
                    <label>Felhaszn�l� neve</label>
                    <input name="pname">
                </div>
                <div>
                    <label>Jelsz� </label>
                    <input name="ppassword">
                </div>
                <div><input type="submit"></div>            
        </form>
    </body>
</html>
