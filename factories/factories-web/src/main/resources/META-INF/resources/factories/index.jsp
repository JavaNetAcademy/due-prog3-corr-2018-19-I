<%-- 
    Document   : index
    Created on : 0000.00.00., 00:00:00
    Author     : jrajmund
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gyárak</title>
    </head>
    <body>
        <form action="factories" method="post">
            <fieldset>
                <legend>Gyár létrehozás</legend>
                <div>
                    <label>Név:</label>
                    <input type="text" name="fname">
                </div>
                <div>
                    <label>Leírás:</label>
                    <input type="text" name="fdesc">
                </div>                
                <div>
                    <label>Birodalmi szint</label>
                    <input type="text" name="elevel">
                </div>
                <input type="submit" value="Hozzáad">
            </fieldset>
        </form>
    </body>
</html>
