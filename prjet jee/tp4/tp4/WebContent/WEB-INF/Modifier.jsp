<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="Beans.user" %>
<%@ page import= "DAO.UserDao" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Modifier User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        body {
            padding: 20px;
        }
        h1 {
            margin-bottom: 20px;
        }
        form {
            max-width: 400px;
            margin: auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border-radius: 3px;
            border: 1px solid #ccc;
        }
         input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border-radius: 3px;
            border: 1px solid #ccc;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        a {
            display: block;
            text-align: center;
            text-decoration: none;
            color: #007bff;
            margin-top: 20px;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="d-flex justify-content-center">
    <h1>Modifier User</h1>
    <% UserDao dao=new UserDao(); %>
    </div>
    <form action="ModifierUser" method="post">
        <input type="hidden" name="id" value="<%= request.getParameter("userModifier") %>">
        Nom: <input type="text" name="name" value="<%= request.getParameter("nom") %>"><br>
		Prenom: <input type="text" name="prenom" value="<%= request.getParameter("prenom") %>"><br>
        Email: <input type="text" name="email" value="<%= request.getParameter("mail") %>"><br>
        <input type="submit" value="Valider">
    </form>
    <div class="d-flex justify-content-end">
    <a href="AllUsers" class="btn btn-info">Tous les utilisateurs</a>
    </div>
</body>
</html>
