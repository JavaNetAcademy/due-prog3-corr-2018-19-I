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
            <br>
            <nav class="nav nav-pills mb-2">
                <a class="nav-link active" href="#">Képességek szerkesztése</a>
                <a class="nav-link" href="<c:url value="/heroskills"></c:url>">Hős tanul</a>
            </nav>
            <div class="container">

                <br>
                <form action="/skills" method="post">
                    <h3>Új képesség felvitele</h3>
                    <br>
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
                                <td><input type="text" name="pname" value="${userinput.name}"></td>
                            <td><input type="text" name="pdescription" value="${userinput.description}"></td>                            
                            <td>                                                                                                                                                                                                                                   
                                <select name="poffensive">
                                    <c:choose>
                                        <c:when test="${userinput.offensive}">
                                            <option value="${true}" selected>támadás</option>
                                            <option value="${false}">védekezes</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${true}" >támadás</option>
                                            <option value="${false}" selected>védekezes</option>
                                        </c:otherwise>
                                    </c:choose>
                                </select>                                                                                                                                                                                    
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${userinput.valueInCombat==0}"><input type="number" name="pvalueInCombat"> </c:when>
                                    <c:otherwise><input type="number" name="pvalueInCombat" value="${userinput.valueInCombat}"> </c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${userinput.reqLevel==0}"><input type="number" name="preqLevel"></c:when>
                                    <c:otherwise><input type="number" name="preqLevel" value="${userinput.reqLevel}"></c:otherwise>
                                </c:choose>
                            </td>                                                              
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
                <h4>Azok a foglalkozások, ahol engedélyezett az új képesseg:</h4>         
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
                                <c:forEach var="id" items="${userinput.reqJobIds}">
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
                <div><input type="submit" value="Hozzáad" class="btn btn-primary"></div>            
            </form>
            <hr><br>
            <form action="/skills" method="get">                               
                <h3>Az eddigi tanulható kepessegek</h3>
                <table class="table table-striped">
                    <thead class="text-center">
                        <tr>
                            <th>Név</th>
                            <th>Leíras</th>
                            <th>Használat</th>
                            <th>Támadó/védekező hatas</th>
                            <th>A szükséges minimalis hősszint</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody class="text-center">
                        <c:forEach var="skill" items="${skillList}">
                            <tr>
                                <td>${skill.name}</td>
                                <td>${skill.description}</td>
                                <td><c:choose>
                                        <c:when test="${skill.offensive}">támadás</c:when>
                                        <c:otherwise>védekezes</c:otherwise>
                                    </c:choose></td>
                                <td>${skill.valueInCombat}</td>
                                <td>${skill.reqLevel}</td>
                                <td>
                                    <a href="<c:url value="/modskills"><c:param name="skillId" value="${skill.id}"/></c:url>">Szerkesztés</a>
                                    </td>
                                </tr>
                        </c:forEach>

                    </tbody>
                </table>
                <br>
                <h4>Foglalkozások engedélyezett képessegei</h4>
                <table class="table table-striped">
                    <thead class="text-center">
                        <tr>
                            <th></th>
                                <c:forEach var="job" items="${jobList}">
                                <th>${job.name}</th>
                                </c:forEach>
                        </tr>
                    </thead>
                    <tbody class="text-center">
                        <c:forEach var="skill" items="${skillList}">
                            <tr>
                                <td>${skill.name}</td>
                                <c:forEach var="job" items="${jobList}">
                                    <c:set var="van" value="${false}"></c:set>
                                    <c:forEach var="id" items="${skill.reqJobIds}">
                                        <c:if test="${id==job.id}">
                                            <c:set var="van" value="${true}"></c:set>
                                        </c:if>                                   
                                    </c:forEach>                               
                                    <td><c:choose>
                                            <c:when test="${van}">X</c:when>
                                            <c:otherwise></c:otherwise>
                                        </c:choose></td>
                                    </c:forEach>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </form>
        </div>
    </body>
</html>
