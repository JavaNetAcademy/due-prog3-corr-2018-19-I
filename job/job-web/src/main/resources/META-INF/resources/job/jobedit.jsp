<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Job_Edit</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="/jobedit" method="post" style="float:left;">
            <fieldset>
                <legend>Job ${job.name} Szerkeszt�s</legend>
                <table>
                    <thead>
                        <tr>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><label>N�v</label></td>
                            <td><input type="text" value="${job.name}" name="pname" /></td>
                        </tr>
                        <tr>
                            <td><label>Le�r�s</label></td>
                            <td><input type="text" value="${job.description}" name="pdescription" /></td>
                        </tr>  
                       
                    </tbody>
                </table>
                <input type="hidden" value="${job.id}" name="jobid" />
                <input type="hidden" value="${job.name}" name="originalJobName" />


                <div>
                    <input type="submit" value="Ment�s">
                    <a href="/job">Vissza</a>

                </div>  

            </fieldset>
        </form>         
    </body>
</html>
