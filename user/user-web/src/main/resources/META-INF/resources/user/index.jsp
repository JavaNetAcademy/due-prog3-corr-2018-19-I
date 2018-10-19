<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="/user/reg" method="post">
            <fieldset>
                <legend>Regisztráció</legend>
                <div>
                    <label>Felhasználó neve</label>
                    <input name="pname">
                </div>
                <div>
                    <label>Jelszó </label>
                    <input name="ppassword">
                </div>
                <div><input type="submit"></div>            
        </form>
        <form action="/user/login" method="post">
            <fieldset>
                <legend>Bejelentkezés</legend>
                <div>
                    <label>Felhasználó neve</label>
                    <input name="pname">
                </div>
                <div>
                    <label>Jelszó </label>
                    <input name="ppassword">
                </div>
                <div><input type="submit"></div>            
        </form>
    </body>
</html>
