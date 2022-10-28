<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Info ticket</title>
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css"
    />
    <link rel="stylesheet" type="text/css" href="css/base.css" />
  </head>
  <body>
    <h1>Facture Ticket</h1>
    <h2>Informations ticket :</h2>

    <!--  print date -->
    <p>
      Date entree :
      <fmt:formatDate value="${ticket.entryDate}" pattern="dd/MM/yyyy" />
    </p>

    <!-- print image -->
    <p><img src="${ticket.imagePath}" alt="image" /></p>
    <div
      style="
        display: flex;
        justify-content: center;
		flex-direction: row;
        align-items: center;
        align-content: center;
        margin-top: 25px;
		gap: 25px;
		
      "
    >
      <button class="button is-danger" >
        <a href="index.html" style="color: white"
          >Revenir a la page principale</a
        >
      </button>
      <button class="button is-danger">
        <a href="index.html" style="color: white">Payez votre ticket !</a>
      </button>
    </div>
	<!-- 

		on initisalise a false
		quand on clique sur le bouton on passe a true le a payer
		la div s'afficher 
		et on affiche le prix
		et on affiche le bouton de paiement
		l'utilisateur rempli les infos 
		lorsquil a cliquer le bouton
		on passe a false le a Payer
		creer un paiement
		et on afficher le bouton sortir renvoyer vers une servlet ou je change le apayer a false et ajoute dans la liste de paiement

	 -->
	<c:if test="${ticket.aPayer == true}">
		<p>Prix : ${ticket.estSorti}</p>
	</c:if>
	
	<c:if test="${ticket.estSorti == true}">
		<h1>je suis dynamique true</h1>
	</c:if>

  </body>
</html>
