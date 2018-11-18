

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Job_Del</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="jobdel" method="post" style="float:left;">
            <fieldset>
                <legend>job  ${job.name}  Törlés</legend>

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
                            <td><span>${job.name}</span></td>
                        </tr>
                        <tr>
                            <td><label>Leírás</label></td>
                            <td><span>${job.description}</span></td>
                        </tr>
                       
                    </tbody>
                </table>
                <input type="hidden" value="${job.id}" name="jobid" />

                <h4>Biztos törölni akarod a munkakört?</h4>
                <div style="display:block;">
                    <input type="submit" value="Törlés">
                    <a href="/job">Vissza</a>
                </div>  
            </fieldset>
        </form>         
    </body>
</html>
