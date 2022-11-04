<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"
prefix="fmt"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Info tickets</title>
    <link rel="stylesheet" type="text/css" href="css/base.css" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css"
    />
  </head>
  <body>
    <h1 class="title mb-6 mt-6">
      Affichage tickets ainsi que la listes paiements
    </h1>

    <div
      style="
        display: flex;
        flex-wrap: wrap;
        justify-content: space-between;
        align-items: center;
        align-content: center;
        margin-left: 3%;
        margin-right: 3%;
        margin-top: 25px;
      "
    >
      <c:forEach items="${tickets}" var="ticket">
        <div class="card">
          <p>
            Date entree :
            <fmt:formatDate value="${ticket.entryDate}" pattern="dd/MM/yyyy" />
          </p>
          <div class="card-image">
            <figure class="image is-4by3">
              <img src="${ticket.imagePath}" alt="image of car " />
            </figure>
          </div>
          <form
            action="AfficherAllPaiementServlet"
            method="get"
            style="
              display: flex;
              flex-direction: column-reverse;
              justify-content: center;
            "
          >
            <input type="hidden" name="ticketNum" value="${ticket.ticketNum}" />
            <button type="submit" value="Payer" class="button is-primary">
              Afficher tous les paiements
            </button>
          </form>
        </div>
      </c:forEach>
    </div>
    <div
      style="
        display: flex;
        justify-content: center;
        flex-direction: column;
        align-items: center;
        align-content: center;
        margin-top: 25px;
      "
    >
      <button class="button is-danger">
        <a href="index.html" style="color: white"
          >Revenir a la page principale</a
        >
      </button>
    </div>
  </body>
</html>
