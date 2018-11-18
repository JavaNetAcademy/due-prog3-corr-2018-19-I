<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Job_Edit</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="/jobedit" method="post" style="float:left;">
            <fieldset>
                <legend>Job ${job.name} Szerkesztés</legend>
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
                            <td><input type="text" value="${job.name}" name="pname" /></td>
                        </tr>
                        <tr>
                            <td><label>Leírás</label></td>
                            <td><input type="text" value="${job.description}" name="pdescription" /></td>
                        </tr>  
                       
                    </tbody>
                </table>
                <input type="hidden" value="${job.id}" name="jobid" />
                <input type="hidden" value="${job.name}" name="originalJobName" />


                <div>
                    <input type="submit" value="Mentés">
                    <a href="/job">Vissza</a>

                </div>  

            </fieldset>
        </form>         
    </body>
</html>
