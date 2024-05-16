<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="Beans.user" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
       
        table {
            width: 100%;
            border-collapse: collapse;
            border: 1px solid black;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid black;
        }
        th {
            background-color: #f2f2f2;
        }
     </style>
<title>Insert title here</title>
</head>
<body>
<div class="d-flex justify-content-center">
<h1>Liste des utilisateurs</h1>
</div>
<table >
<tr>
<th>Id User</th>
<th>Nom</th>
<th>Prenom</th>
<th>Email</th>
<th>Image</th>
<th>Effacer</th>
<th>Modifier</th>
</tr>
<%  List<user> users = (List<user>) request.getAttribute("allusers");
for(user user:users)
{
%>
<tr>
<td><%= user.getIdUser() %></td>
<td><%= user.getName() %></td>
<td><%= user.getPrenom() %></td>
<td><%= user.getEmail() %></td>
<td>
    <img src="images/aminb.jpg" alt="Image utilisateur">
</td>

<td>
  <form action="AllUsers" method="post">
    <input type="hidden" name="id" value="<%= user.getIdUser() %>">
    <button type="submit" class="btn btn-danger">Effacer</button>
  </form>
</td>
<td>
<form action="ModifierUser" methode="post">
<input type="hidden" name="userModifier" value="<%= user.getIdUser() %>">
<input type="hidden" name="nom" value="<%= user.getName() %>">
<input type="hidden" name="prenom" value="<%= user.getPrenom() %>">
<input type="hidden" name="mail" value="<%= user.getEmail() %>">
<button type="submit" class="btn btn-success">modifier</button>
</form>
</td>
</tr>
<%} %>
</table>
<div class="container">
    <div class="row">
        <div class="col">
            <div class="card text-white bg-primary mb-3" style="max-width: 18rem;margin-top: 20px;">
                <div class="card-header">le nombre d'utilisateur ont le nom amin</div>
                <div class="card-body">
                    <h5 class="card-title"><%= request.getAttribute("UserByName") %></h5>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card text-white bg-primary mb-3" style="max-width: 18rem;margin-top: 20px;">
                <div class="card-header">La nombre des noms commençant par la lettre a</div>
                <div class="card-body">
                    <h5 class="card-title"><%= request.getAttribute("UserNameByLetter") %></h5>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <div class="card text-white bg-primary mb-3" style="max-width: 18rem;margin-top: 20px;">
                <div class="card-header">La nombre des utilisateurs</div>
                <div class="card-body">
                    <h5 class="card-title"><%= request.getAttribute("count") %></h5>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="d-flex justify-content-end">
<a href="AjouterUtilisateur" class="btn btn-info">Ajouter Utilisateur</a>
</div>
</body>
</html>