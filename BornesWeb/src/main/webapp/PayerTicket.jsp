<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Paiement ticket</title>
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

      <form action="SetPaiementServlet" method="get">
        <input type="hidden" name="ticketNum" value="${ticket.ticketNum}" />
        <button class="button is-warning" type="submit">Payez votre ticket !</button>
      </form>

    </div>
	<!-- 

		on initisalise a false OK 
		quand on clique sur le bouton on passe a true le a payer OK
		la div s'afficher  OK 
		et on affiche le prix OK 
		et on affiche le bouton de paiement OK 
		l'utilisateur rempli les infos OK 
		lorsquil a cliquer le bouton OK 
		on passe a false le a Payer OK 
		creer un paiement OK 
		et on afficher le bouton sortir renvoyer vers une servlet ou je change le apayer a false et ajoute dans la liste de paiement

	 -->

   <!-- show  aPayer attribute in p -->
   
	<c:if test="${ticket.aPayer == true}">
    <div class="columns mt-5">
      <div class="container">

        <p class="has-text-centered	">Formulaire de paiement</p>
      
      <form action="PaiementServlet" method="get">
        
        <div class="field">
          <label class="label">Type de paiement</label>
          <div class="control">
            <input type="hidden" name="ticketNum" value="${ticket.ticketNum}" />
            <p>Montant : ${montant}</p>
            <input type="hidden" name="montant" value="${montant}" />
            <input class="input" type="text" name="PaiementType" placeholder="Carte Bancaire">
          </div>
        </div>

        <button class="button is-warning" type="submit">Payer !</button>

      </form>



      </div>
    </div>
	</c:if>
	
	<!-- <c:if test="${ticket.estSorti == true}">
		<h1>je suis dynamique true</h1>
	</c:if> -->

  </body>
</html>
