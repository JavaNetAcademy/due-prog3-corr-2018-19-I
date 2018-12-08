<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Skills</title>
    </head>
    <body>
        <jsp:include page="/user/menu.jsp"></jsp:include>
            <div class="container">
                <fieldset>
                    <legend>A módositani kínánt képesség</legend>
                    <form action="/modskills" method="post">
                        <table class="table">
                            <thead class="thead-dark">
                                <tr>
                                    <th>Név</th>
                                    <th>Leíras</th>
                                    <th>Használat</th>
                                    <th>Tamadó/vedekező hatás</th>
                                    <th>A szükseges minimális hősszint</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><input type="text" name="pname" value="${modSk.name}"></td>
                                <td><input type="text" name="pdescription" value="${modSk.description}"></td>                            
                                <td>       
                                    <select name="poffensive">
                                        <c:choose>
                                            <c:when test="${modSk.offensive}">
                                                <option value="${true}" selected>támadás</option>
                                                <option value="${false}">védekezes</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${true}" >támadás</option>
                                                <option value="${false}" selected="">védekezes</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </select>
                                </td>
                                <td><input type="number" name="pvalueInCombat"value="${modSk.valueInCombat}"></td>
                                <td><input type="number" name="preqLevel" value="${modSk.reqLevel}"></td>
                            </tr>
                            <tr>
                                <td> <span class="error">${messages.pname}</span></td>
                                <td></td>
                                <td></td>
                                <td> <span class="error">${messages.pvalueInCombat}</span></td>
                                <td> <span class="error">${messages.preqLevel}</span></td>
                            </tr>
                        </tbody>                
                    </table>
                    <br>
                    <label>Azok a foglalkozások, ahol engedélyezett a képesseg:</label>         
                    <table class="table">
                        <thead class="thead-dark">
                            <tr>                   
                                <c:forEach var="job" items="${jobList}">
                                    <th>${job.name}</th>
                                    </c:forEach>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <c:forEach var="job" items="${jobList}">                
                                    <c:set var="van" value="${false}"></c:set>
                                    <c:forEach var="id" items="${modSk.reqJobIds}">
                                        <c:if test="${id==job.id}">
                                            <c:set var="van" value="${true}"></c:set>
                                        </c:if>                                   
                                    </c:forEach>
                                    <td>
                                        <c:choose>
                                            <c:when test="${van}"><input type="checkbox" name="JobIds" value="${job.id}" checked> </c:when>
                                            <c:otherwise><input type="checkbox" name="JobIds" value="${job.id}"> </c:otherwise>
                                        </c:choose>

                                    </td>
                                </c:forEach>  
                            </tr>
                            <tr>
                                 <td colspan="${fn:length(jobList)}"> <span class="error">${messages.JobIds}</span></td>                                
                            </tr>
                        </tbody>
                    </table>
                    <br>
                    <input type="hidden" value="${modSk.id}" name="skillId" />

                    <div class="row">                         
                        <div class="col-6 col-md-4">
                            <input type="submit" value="Módosit" class="btn btn-primary">
                        </div> 
                        <div class="col-12 col-md-8">
                            <label>${modMessage}</label>
                        </div>
                    </div>
                </form>
                <br>
                <form action="/delskill" method="post">
                    <input type="hidden" value="${modSk.id}" name="skillId" />
                    <div class="row">
                        <div class="col-6 col-md-4">   
                            <input type="submit" value="Töröl" class="btn btn-primary">
                        </div>
                        <div class="col-12 col-md-8">
                            <label>${delMessage}</label>
                        </div>
                    </div>
                </form>
                <div style="float: right;">
                    <a href="skills"><input type="submit" value="Vissza" class="btn btn-primary"></a>
                </div>  
            </fieldset>
        </div>
    </body>
</html>
