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
    <h1 class="title mb-6 mt-6">Affichage tickets</h1>
    <!-- bulma table with 4 items per line -->
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
      <c:choose>
        <c:when test="${tickets.size() == 0}">
          <!-- center div -->
          <div class="columns is-centered">
            <div class="column">
              <article class="message is-warning">
                <div class="message-header">
                  <p>Warning</p>
                </div>
                <div class="message-body">Aucun ticket n'est enregistre.</div>
              </article>
            </div>
          </div>
        </c:when>
        <c:when test="${tickets.size()  != 0}">
          <h2 class="subtitle mb-6 mr-2">Informations tickets :</h2>
          <c:forEach items="${tickets}" var="ticket">
            <div class="card mb-5">
              <p>
                Date entree :
                <fmt:formatDate
                  value="${ticket.entryDate}"
                  pattern="dd/MM/yyyy HH:mm:ss"
                />
              </p>

              <div class="card-image">
                <figure class="image is-4by3">
                  <img src="${ticket.imagePath}" alt="image of car " />
                </figure>
              </div>
              <form
                action="PayerServlet"
                method="get"
                style="
                  display: flex;
                  flex-direction: column-reverse;
                  justify-content: center;
                "
              >
                <input
                  type="hidden"
                  name="ticketNum"
                  value="${ticket.ticketNum}"
                />
                <button type="submit" value="Payer" class="button is-primary">
                  Payer
                </button>
              </form>
            </div>
          </c:forEach>
        </c:when>
        <c:otherwise> ... </c:otherwise>
      </c:choose>
    </div>
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
