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
    <h1 class="title mb-6 mt-6">Affichage tickets ainsi que la liste de tous les paiements</h1>

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
      <c:forEach items="${allPaiements}" var="paiements">
        <li>
          ${paiements.toString()}
        </li>
      </c:forEach>
    </div>

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

    <form action="AfficherTicketsServlet" method="get">
      <input type="hidden" name="listPaiement" value="true" />
      <button class="button is-warning" type="submit">
        Afficher les tickets ainsi que la liste des paiements
      </button>
    </form>

  </div>



  </body>
</html>
