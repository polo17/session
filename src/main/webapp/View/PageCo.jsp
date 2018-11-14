<%-- 
    Document   : Page
    Created on : 14 nov. 2018, 13:19:35
    Author     : pedago
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Connecté</title>
    </head>
    <body>

	<hr>
	<h2>${joueurs} joueur(s) connecté(s)</h2>
	<hr>
	<h3>Hello ${playerName}, Devine mon nombre</h3>
        
        Essai n° <b>${testNum}</b><br/>
        ${guess} : <b>trop ${hautbas}</b>		
        
        <h2>je pense à un nombre compris entre 0 et 100</h2>
 
		<form name="guessForm" method="POST" accept-charset="UTF-8" >
			<label>Ta proposition : <input type="number" min="0" max="100" required name="guess"></label> 
			<input type="SUBMIT" name="action" value="Deviner"><br/>
		</form>
		<form method="POST">
			<input type="SUBMIT" name="action" value="Déconnexion">
		</form>

		<hr>
		
	<h2>Score à battre : 3 essais par Francisco</h2>  


    </body>
</html>
