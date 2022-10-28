<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Info ticket</title>
	<link rel="stylesheet" type="text/css" href="css/base.css" >
</head>
<body>
	<h1>Affichage Ticket</h1>
	<h2>Informations ticket :</h2>

	<!--  print date -->
	<p>Date entree : <fmt:formatDate value="${ticket.entryDate}" pattern="dd/MM/yyyy" /></p>

	
	<a href="index.html">Revenir a la page principale</a>
</body>
</html>