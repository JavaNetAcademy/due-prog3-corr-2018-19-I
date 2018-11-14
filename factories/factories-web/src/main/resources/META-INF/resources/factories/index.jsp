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
                    <input type="text" name="pname">                                                                   
                </div>
                <div>                                                                                                  
                    <label>Leírás:</label>                                                                             
                    <input type="text" name="pdesc">                                                                   
                </div>                                                                                                 
                <div>                                                                                                  
                    <label>Birodalom szint:</label>                                                                    
                    <select name="pemp">                                                                            
                        <c:forEach items="${empiresList}" var="x">                                                     
                            <option value="${x.id}"><c:out value="${x.level}" /></option>                              
                        </c:forEach>                                                                                   
                    </select>                                                                                          
                </div>
                <input type="submit" value="Hozzáad">                                                                  
            </fieldset>                                                                                                
        </form>                                                                                                        
    </body>                                                                                                            
</html>            
