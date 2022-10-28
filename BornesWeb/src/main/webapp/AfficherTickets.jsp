<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Info tickets</title>
	<link rel="stylesheet" type="text/css" href="css/base.css" >
</head>
<body>
	<h1>Affichage tickets</h1>
	<h2>Informations tickets :</h2>
	<table>
		<thead><tr><th>Date entree</th></tr></thead>
		<tbody>
			<c:forEach items="${tickets}"  var="ticket">
				<tr>
					<td>
						<p>Date entree : <fmt:formatDate value="${ticket.entryDate}" pattern="dd/MM/yyyy" /></p>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p><a href="index.html">Revenir a la page principale</a></p>
</body>
</html>