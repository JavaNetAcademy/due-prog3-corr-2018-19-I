<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='webjars/bootstrap/4.1.3/css/bootstrap.min.css'>
    </head>
    <body>
        <div class="container">
            <div class="col-md-6 offset-md-3">
                <form action="/reg" method="post">
                    <fieldset>
                        <legend>Regisztr�ci�</legend>
                        <div class="form-group">
                            <label>Felhaszn�l� neve</label>
                            <input name="pname" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Jelsz� </label>
                            <input name="ppassword" class="form-control">
                        </div>
                        <div><input type="submit" value="Regisztr�l�s" class="btn btn-light"></div>            
                </form>
                <form action="/login" method="post">
                    <fieldset>
                        <legend>Bejelentkez�s</legend>
                        <div class="form-group">
                            <label>Felhaszn�l� neve</label>
                            <input name="pname" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Jelsz� </label>
                            <input name="ppassword" class="form-control">
                        </div>
                        <div><input type="submit" value="Bejelentkez�s" class="btn btn-primary"></div>            
                </form>
            </div>
        </div>
    </body>
</html>

<script type="text/javascript" src="webjars/jquery/2.2.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>