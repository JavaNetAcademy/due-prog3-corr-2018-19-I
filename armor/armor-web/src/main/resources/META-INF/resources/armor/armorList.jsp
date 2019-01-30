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
		<h1>Páncélok</h1>
	</div>
	</br>
	<div class="container">

		<div class="w-50 p-3" style="background-color: #eee;">
			  <form action="armor?operation=aNew" method="post">
				<fieldset>

					<legend>Páncél létrehozása</legend>
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
								<td><label>Páncél neve:</label></td>
								<td><input type="textarea" name="name"
									class="form-control" /></td>
							</tr>
							<th></th>
							<th></th>
							<tr>
								<td><label>Páncél leírása:</label>
								<td>
								<td><input type="textarea" name="description"
									class="form-control" /></td>
							</tr>
							<th></th>
							<th></th>
							<tr>
								<td><label>Páncél értéke:</label>
								<td>
								<td><input type="textarea" name="price"
									class="form-control" /></td>
							</tr> 
						</tbody>
					</table>
					<div>
						<input type="submit" value="Létrehoz" class="btn btn-primary">
					</div>
			</form>  
		</div>
		</br>

		<div class="w-75 p-3" style="background-color: #eee;">
			<form action="armor?operation=aAll" method="get">
				<fieldset>
					<legend>Páncél lista:</legend>

					<table class="table">
						<thead>
							<tr>
								<th>Név</th>
								<th>Leírás</th>
								<th>Ár</th>
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
										href="<c:url value="/armor?operation=aAll"> 
                                                   <c:param name="armorid" value="${onearmor.id}"/>
                                               </c:url>">Szerkesztés</a>


										<a class="btn btn-danger"
										href="<c:url value="armor?operation=aAll">
                                                   <c:param name="armorid" value="${onearmor.id}"/>
                                               </c:url>">Törlés</a>
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


