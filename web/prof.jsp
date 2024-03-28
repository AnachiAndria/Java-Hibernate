<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.Prof" %>
<%@ page import="manager.ProfManager" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="En">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Projet 9</title>
    <link rel="stylesheet" href="assets/steel.css">
</head>
<body>
    <div class="leftPanel">
        <h2>Projet 9</h2>
        <div class="menu">
            <ul>
                <li><a href="/WebApplication1/Prof">Prof</a></li>
                <li><a href="/WebApplication1/Salle">Salle</a></li>
                <li><a href="/WebApplication1/occuper">Occuper</a></li> 
            </ul>
        </div>
    </div>
    <div class="content">
        <div class="header" style="margin-top: 14px;">
            <form action="/WebApplication1/Prof" method="get">
                <div class="recherche">
                    <div class="loup">&#128269;</div>
                    <input type="text" name="search" id="" placeholder="Recherche...">
                </div>
            </form>
        </div>
        <div class="panel">
            <div class="headerPanel">
                <div class="titre">
                    <h3>Prof</h3>
                </div>
            </div>
            <div class="panelContent">
                <div class="tab">
                    <table>
                        <thead>
                            <tr>
                                <th>N°</th>
                                <th>Nom</th>
                                <th>Prenom</th>
                                <th>Grade</th>
                                <th>
                                    Action
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Prof prof : (List<Prof>) request.getAttribute("listeProfs")) { %>
                                <tr>
                                    <td class="num">PRF<%= prof.getCodeprof()%></td>
                                    <td><%= prof.getNom()%></td>
                                    <td><%= prof.getPrenom() %></td>
                                    <td><%= prof.getGrade()%></td>
                                    <td class="actionB">
                                            <button class="buttonM" onclick="Myfunc('<%= prof.getCodeprof()%>' ,'<%= prof.getNom()%>', '<%= prof.getPrenom()%>', '<%= prof.getGrade()%>')">
                                                <input type="hidden" id="val1" value="<%= prof.getCodeprof()%>">
                                                <input type="hidden" id="val2" value="<%= prof.getNom()%>">
                                                <input type="hidden" id="val3" value="<%= prof.getPrenom()%>">
                                                <input type="hidden" id="val4" value="<%= prof.getGrade()%>">
                                                Modifier
                                            </button>
                                        <form action="/WebApplication1/Prof" method="POST" style="float: right;">
                                            <button class="buttonS">
                                                <input type="hidden" name="action" value="supprimer">
                                                <input type="hidden" name="idProfToDelete" id="1" value="<%= prof.getCodeprof()%>">
                                                Supprimer
                                            </button>
                                        </form>
                                    </td>
                                </tr>
                            <% } %>
                        </tbody><br>
                    </table>
                </div>
                <div class="form">
                    <form action="/WebApplication1/Prof" method="post">
                        <input type="hidden" id="imp0" name="id">
                        <div class="form-imp">
                            <label for="imp1">Nom</label><br>
                            <input id="imp1" name="nom" type="text"><br>
                        </div>
                        <div class="form-imp">
                            <label for="imp2">Prenom</label><br>
                            <input id="imp2" name="prenom" type="text"><br>
                        </div>
                        <div class="form-imp">
                            <label for="imp3">Grade</label><br>
                            <input id="imp3" name="grade" type="text"><br>
                        </div>
                        <div class="boutons" style="width: 336px;">
                            <button class="button">Enregistrer</button>
                            <button class="Annuler" type="button" onclick="clearImp()" >Annuler</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script src="assets/jquery/jquery.min.js"></script>
    <script>
        function Myfunc(id,Nom,Prenom,Grade) {
            // let id = $(this).find("#val1").val();
            // let Nom = $(this).find("#val2").val();
            // let Prenom = $(this).find("#val3").val();
            // let Grade = $(this).find("#val4").val();

            $("#imp0").val(id)
            $("#imp1").val(Nom)
            $("#imp2").val(Prenom)
            $("#imp3").val(Grade)
        }
        function clearImp(){
            $(".form input").val("")
        }
    </script>
</body>
</html>