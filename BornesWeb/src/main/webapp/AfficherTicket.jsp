<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"
prefix="fmt"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Info ticket</title>
    <link rel="stylesheet" type="text/css" href="css/base.css" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css"
    />
  </head>
  <body>
    <h1>Affichage Ticket</h1>
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
