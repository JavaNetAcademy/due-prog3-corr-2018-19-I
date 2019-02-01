<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Armor</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<jsp:include page="/user/menu.jsp"></jsp:include>

	<div class="w-75 p-3"
		style="background-color: #eee; text-align: center;">
		<h1>P�nc�lok</h1>
	</div>
	</br>
	<div class="container">

		<div class="w-50 p-3" style="background-color: #eee;">
			<form action="armor?operation=aNew" method="post">
				<fieldset>

					<legend>P�nc�l l�trehoz�sa</legend>
					<table class="table">
						<thead>
							<tr>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<th></th>
							<th></th>
							<tr>
								<td><label>P�nc�l neve:</label></td>
								<td><input type="text" name="name" class="form-control" /></td>
							</tr>
							<th></th>
							<th></th>
							<tr>
								<td><label>P�nc�l le�r�sa:</label></td>
								<td><input type="text" name="description"
									class="form-control" /></td>
							</tr>
							<th></th>
							<th></th>
							<tr>
								<td><label>P�nc�l �rt�ke:</label></td>
								<td><input type="text" name="price"
									class="form-control" /></td>
							</tr>
						</tbody>
					</table>
					<div>
						<input type="submit" value="L�trehoz" class="btn btn-primary">
					</div>
			</form>
		</div>
		</br>

		<div class="w-75 p-3" style="background-color: #eee;">
			<form action="armor?operation=aAll" method="get">
				<fieldset>
					<legend>P�nc�l lista:</legend>

					<table class="table">
						<thead>
							<tr>
								<th>N�v</th>
								<th>Le�r�s</th>
								<th>�rt�k</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="onearmor" items="${armors}">
								<tr>
									<td><span>${onearmor.name} </span></td>
									<td><span>${onearmor.description}</span></td>
									<td><span>${onearmor.price}</span></td>
									<td><a class="btn btn-light"
										href="<c:url value="/armor?operation=aUp"> 
                                                   <c:param name="armorId" value="${onearmor.id}"/>
                                               </c:url>">Szerkeszt�s</a>


										<a class="btn btn-danger"
										href="<c:url value="armor?operation=aDel">
                                                   <c:param name="armorId" value="${onearmor.id}"/>
                                               </c:url>">T�rl�s</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>


