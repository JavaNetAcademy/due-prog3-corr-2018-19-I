<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Skills fo heroes</title>
    </head>
    <body>
        <jsp:include page="/user/menu.jsp"></jsp:include>
            <br>
            <nav class="nav nav-pills mb-2">               
                <a class="nav-link" href="<c:url value="/skills"></c:url>">Képességek szerkesztése</a>
                <a class="nav-link active" href="#">Hős tanul</a>
            </nav>
            <div class="container">
                <form  class="form-inline" action="/heroskills" method="post">
                    <div class="form-group mb-2">
                        <h3>Válassz hőst: </h3>
                    </div>
                    <div class="form-group mx-sm-3 mb-2"> 
                        <select class="form-control" name="selectedHeroId">
                        <c:forEach items="${heroList}" var="hero">                                                                
                            <option value="${hero.id}">${hero.name}</option>                                              
                        </c:forEach>
                    </select>
                </div>
                <div><input type="submit" value="Választ" class="btn btn-primary mb-2"></div>    
            </form>
            <c:if test="${not empty actualSkills}">   
                <h4> ${selectedHero.name} eddigi képessegei</h4>
                <table class="table table-striped">
                    <thead class="text-center">
                        <tr>
                            <th>Név</th>
                            <th>Leíras</th>
                            <th>Használat</th>
                            <th>Támadó/védekező hatas</th>
                            <th>A kepesseg szintje</th>
                        </tr>
                    </thead>
                    <tbody class="text-center">
                        <c:forEach var="skill" items="${actualSkills}">
                            <tr>
                                <td>${skill.name}</td>
                                <td>${skill.description}</td>
                                <td><c:choose>
                                        <c:when test="${skill.offensive}">támadás</c:when>
                                        <c:otherwise>védekezes</c:otherwise>
                                    </c:choose></td>
                                <td>${skill.valueInCombat}</td>
                                <td>${skill.skillLevel}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <br>                
                <form class="form-inline" action="/forgetskill" method="post">   
                    <div class="form-group mb-2">
                        <h4>A törölni kívánt képesség:</h4>
                    </div>
                    <div class="form-group mx-sm-3 mb-2"> 
                        <select class="form-control" name="selectedSkillId">
                            <c:forEach items="${actualSkills}" var="skill">                                                                
                                <option value="${skill.id}">${skill.name}</option>                                              
                            </c:forEach>
                        </select>
                    </div>
                    <div>
                        <input type="hidden" value="${selectedHero.id}" name="selectedHeroId" />
                        <input type="submit" value="Elfelejt" class="btn btn-primary mb-2"></div>            
                </form>
                <br>
                <form class="form-inline" action="/improveskill" method="post">   
                    <div class="form-group mb-2">
                        <h4>A fejleszteni kívánt képesség:</h4>
                    </div>
                    <div class="form-group mx-sm-3 mb-2"> 
                        <select class="form-control" name="selectedSkillId">
                            <c:forEach items="${actualSkills}" var="skill">                                                                
                                <option value="${skill.id}">${skill.name}</option>                                              
                            </c:forEach>
                        </select>
                    </div>
                    <div>
                        <input type="hidden" value="${selectedHero.id}" name="selectedHeroId" />
                        <input type="submit" value="Fejleszt" class="btn btn-primary mb-2"></div>            
                </form>     
                <br>
            </c:if>
            <c:if test="${not empty availableSkills}">   
                <h3>Tanulás</h3>
                <h4>${selectedHero.name} számára elérhető képességek</h4>

                <table class="table table-striped">
                    <thead class="text-center">
                        <tr>
                            <th>Név</th>
                            <th>Leíras</th>
                            <th>Használat</th>
                            <th>Támadó/védekező hatas</th>                                          
                        </tr>
                    </thead>
                    <tbody class="text-center">                                
                        <c:forEach var="skill" items="${availableSkills}">
                            <tr>
                                <td>${skill.name}</td>
                                <td>${skill.description}</td>
                                <td><c:choose>
                                        <c:when test="${skill.offensive}">támadás</c:when>
                                        <c:otherwise>védekezes</c:otherwise>
                                    </c:choose></td>
                                <td>${skill.valueInCombat}</td>                                        
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <br>
                <form class="form-inline" action="/learnskill" method="post">   
                    <div class="form-group mb-2">
                        <h4>Az új képesseg:</h4>
                    </div>
                    <div class="form-group mx-sm-3 mb-2"> 
                        <select class="form-control" name="selectedSkillId">
                            <c:forEach items="${availableSkills}" var="skill">                                                                
                                <option value="${skill.id}">${skill.name}</option>                                              
                            </c:forEach>
                        </select>
                    </div>
                    <div>
                        <input type="hidden" value="${selectedHero.id}" name="selectedHeroId" />
                        <input type="submit" value="Tanul" class="btn btn-primary mb-2"></div>            
                </form>                       
            </c:if>
        </div>
    </body>
</html>
