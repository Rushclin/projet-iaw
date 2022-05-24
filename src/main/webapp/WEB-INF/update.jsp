<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="/info" method="POST">
      <br>  Nom :<Input name="nom" type="text"/>
       <br> Prenom :<input name="prenom" type="text"/>
       <br> Email :<input name="email" type="email" placeholder="yyyy@gmail"/>
       <br> Telephone :<input name='tel' type="tel"/>
       <br> Adresse :<input name='adresse' type="text"/>
       <br><input type="submit" value="Enregistrer"> <input type="reset" value="annuler">
    </form>
</body>
</html>