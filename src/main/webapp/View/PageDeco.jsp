<%-- 
    Document   : PageDeco
    Created on : 14 nov. 2018, 13:44:39
    Author     : pedago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Non connecté</title>
    </head>
    <body>
        <h1>Bienvenue dans notre jeu !</h1>
            <hr>
            <h2>${joueurs} joueur(s) connecté(s)</h2>
            <hr>
            <form method="POST">
                <label>Ton prénom : <input name="playerName"></label>
                <input name="action" value="Connexion" type="SUBMIT">
            </form>

    </body>
</html>
