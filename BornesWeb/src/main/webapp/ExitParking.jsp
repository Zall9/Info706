<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="ISO-8859-1" />
        <title>Sortie Parking</title>
        <link
          rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css"
        />
        <link rel="stylesheet" type="text/css" href="css/base.css" />
      </head>
<body>
    <div class="has-text-centered">
       <h1>Paiement reussi</h1>
    </div>

    <div class="has-text-centered mt-6">
      <h4>to do list for this page</h4>
      <ul>
        <li>Creer la servlet de sortie</li>
        <li>Rediriger le user vers la page d'accueil </li>
        <li>Verifier la date dans la servlet avec l'ejb, si depasser repayer sinon page d'accueil</li>
        <li>Mettre en place la verification pour que le user ne peut pas re payer avant les 15 minutes</li>]
        <li>refactor le code clean</li>
        <li>Creer le README du github</li>
        <li>Add le prof dans le read me</li>
      </ul>
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

    <form action="..." method="get">
      <input type="hidden" name="ticketNum" value="${ticket.ticketNum}" />
      <button class="button is-warning" type="submit">Sortir du parking !</button>
    </form>

  </div>
</body>
</html>