<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Pets</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="petedit" method="post" style="float:left;">
            <fieldset>
                <legend>Pet - ${pet.name} - Szerkesztés</legend>

                <table>
                    <thead>
                        <tr>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><label>Név</label></td>
                            <td><input type="text" value="${pet.name}" name="pname" /></td>
                        </tr>
                        <tr>
                            <td><label>Leírás</label></td>
                            <td><input type="text" value="${pet.description}" name="pdesc" /></td>
                        </tr>
                        <tr>
                            <td><label>Hös</label></td>
                            <td>
                                <select name="hero">
                                    <c:forEach items="${heroList}" var="x">
                                        <option value="${x.id}"><c:out value="${x.name}" /></option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><label>Szint</label></td>
                            <td><span>${pet.level}</span></td>
                        </tr>
                        <tr>
                            <td><label>Támadás</label></td>
                            <td><span>${pet.damage}</span></td>
                        </tr>
                        <tr>
                            <td><label>Védés</label></td>
                            <td><span>${pet.defense}</span></td>
                        </tr>
                    </tbody>
                </table>
                <input type="hidden" value="${pet.id}" name="petid" />

                <div><input type="submit" value="Mentés"></div>  
            </fieldset>
        </form>         
    </body>
</html>
