<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.Salle" %>
<%@ page import="manager.SalleManager" %>
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
            <form action="####" method="get">
                <div class="recherche">
                    <div class="loup">&#128269;</div>
                    <input type="text" id="" placeholder="Recherche...">
                </div>
            </form>
        </div>
        <div class="panel">
            <div class="headerPanel">
                <div class="titre">
                    <h3>Salle</h3>
                </div>
            </div>
            <div class="panelContent">
                <div class="tab">
                    <table>
                        <thead>
                            <tr>
                                <th>Salle</th>
                                <th>Designation</th>
                                <th>
                                    Action
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Salle salle : (List<Salle>) request.getAttribute("listeSalle")) { %>
                                <tr>
                                    <td class="num">S<%= salle.getCodesal() %></td>
                                    <td><%= salle.getDesignation() %></td>
                                    <td class="actionB" style="width: 252px;">
                                        
                                            <button class="buttonA" type="button" onclick="Myfunction('<%= salle.getCodesal() %>',`<%= salle.getDesignation() %>`)">
                                                Affectation
                                            </button>
                                            <button class="buttonM" type="button" onclick="modify(`<%= salle.getCodesal() %>`,`<%= salle.getDesignation() %>`)">
                                                Modifier
                                            </button>
                                            <form action="/WebApplication1/Salle" method="POST" style="float: right;">
                                                <button class="buttonS">
                                                    <input type="hidden" name="action" value="supprimer">
                                                    <input type="hidden" id="1" name="idSalleToDelete" value="<%= salle.getCodesal() %>">
                                                    Supprimer
                                                </button>
                                            </form>
                                        
                                    </td>
                                </tr>
                            <% } %>
                        </tbody><br>
                    </table>
                </div>
                <div id="form1" class="form">
                    <form action="/WebApplication1/Salle" method="post">
                        <input type="hidden" id="imp0" name="id">
                        <div class="form-imp">
                            <label for="imp1">Description</label><br>
                            <input id="imp1" name="description" type="text"><br>
                        </div>
                        <div class="boutons" style="width: 336px;">
                            <button class="button">Enregistrer</button>
                            <button class="Annuler" type="button" onclick="annuler()" >Annuler</button>
                        </div>
                    </form>
                </div>
                <div id="form2" class="form">
                    <form action="/WebApplication1/occuper" method="post">
                        <input type="hidden" id="imp02" name="id">
                        <input type="hidden" id="maj" name="maj"> <!-- manisy id ato ra anao maj -->
                        <div class="form-imp">
                            <label for="description">Description</label><br>
                            <input id="description" name="description" type="text"><br>
                        </div>

                        <l id="datee">
                            <div class="form-imp">
                                <label for="imp2">Date</label><br>
                                <input id="imp2" name="datee" type="date"><br>
                            </div>
                            
                            <div class="form-imp" style="width: 150px;float: left;">
                                <label for="heur1">1<sup>er</sup> heure</label><br>
                                <select id="heur1" name="heur1" class="heure">
                                    <option value="" selected></option>
                                    <% for (Prof prof : (List<Prof>) request.getAttribute("listeProfs1")) { %>
                                        <option value="<%= prof.getCodeprof()%>">PRF<%= prof.getCodeprof()%></option>
                                    <% } %>
                                </select>
                                  
                                <br>
                            </div>
                            <div class="form-imp" style="width: 150px;float: right;">
                                <label for="heur2">2<sup>eme</sup> heure</label><br>
                                <select id="heur2" name="heur2" class="heure">
                                    <option value="" selected></option>
                                    <% for (Prof prof : (List<Prof>) request.getAttribute("listeProfs1")) { %>
                                        <option value="<%= prof.getCodeprof()%>">PRF<%= prof.getCodeprof()%></option>
                                    <% } %>
                                </select>
                                <br>
                            </div>
                            <div class="form-imp" style="width: 150px;float: left;">
                                <label for="heur3">3<sup>eme</sup> heure</label><br>
                                <select id="heur3" name="heur3" class="heure">
                                    <option value="" selected></option>
                                    <% for (Prof prof : (List<Prof>) request.getAttribute("listeProfs1")) { %>
                                        <option value="<%= prof.getCodeprof()%>">PRF<%= prof.getCodeprof()%></option>
                                    <% } %>
                                </select>
                                <br>
                            </div>
                            <div class="form-imp" style="width: 150px;float: right;">
                                <label for="heur4">4<sup>eme</sup> heure</label><br>
                                <select id="heur4" name="heur4" class="heure">
                                    <option value="" selected></option>
                                    <% for (Prof prof : (List<Prof>) request.getAttribute("listeProfs1")) { %>
                                        <option value="<%= prof.getCodeprof()%>">PRF<%= prof.getCodeprof()%></option>
                                    <% } %>
                                </select>
                                <br>
                            </div>
                            <div class="form-imp" style="width: 150px;float: left;">
                                <label for="heur5">5<sup>eme</sup> heure</label><br>
                                <select id="heur5" name="heur5" class="heure">
                                    <option value="" selected></option>
                                    <% for (Prof prof : (List<Prof>) request.getAttribute("listeProfs1")) { %>
                                        <option value="<%= prof.getCodeprof()%>">PRF<%= prof.getCodeprof()%></option>
                                    <% } %>
                                </select>
                                <br>
                            </div>
                            <div class="form-imp" style="width: 150px;float: right;">
                                <label for="heur6">6<sup>eme</sup> heure</label><br>
                                <select id="heur6" name="heur6" class="heure">
                                    <option value="" selected></option>
                                    <% for (Prof prof : (List<Prof>) request.getAttribute("listeProfs1")) { %>
                                        <option value="<%= prof.getCodeprof()%>">PRF<%= prof.getCodeprof()%></option>
                                    <% } %>
                                </select>
                                <br>
                            </div>
                        </l>

                        <div class="boutons" style="width: 336px;">
                            <button class="button" id="">Enregistrer</button>
                            <button class="Annuler" type="button" onclick="retour()" >Annuler</button>
                    </form>
                        </div>
                    
                </div>
            </div>
        </div>
    </div>
    <script src="assets/jquery/jquery.min.js"></script>
    <script>
        $("#form2").hide();
        //$("#datee input").attr("disabled",'true');

        function Myfunction(valeur,description) {
            $("#form1").hide();
            $("#form2").show();
            $("#imp02").val(valeur);
            $("#description").val(description);
            $("#imp2").val('');//date
            $("#heur1").val('');
            $("#heur2").val('');
            $("#heur3").val('');
            $("#heur4").val('');
            $("#heur5").val('');
            $("#heur6").val(''); 
        }
        function retour() {
            $("#form1").show();
            $("#form2").hide();
        }
        function modify(codesal, designation) {
            $("#imp0").val(codesal);
            $("#imp1").val(designation);
        }
        function annuler() {
            $("body input").val("");
        }
        $("#imp2").focusout(function() {
            // Récupérer la valeur du champ de formulaire description
            let date = $("#imp2").val(); // date
            let id = $("#imp02").val(); // id de la salle
            
            // Envoyer une requête AJAX au serveur pour effectuer la recherche
            $.ajax({
                url: "SearchServlet", // URL du servlet qui traite la requête de recherche
                type: "GET",
                data: { codesal: id, date: date }, // Paramètre de recherche
                success: function(response) {
                    // Mettre à jour les champs de formulaire avec la réponse reçue
                    if (response) {
                        $("#heur1").val(response[0]);
                        $("#heur2").val(response[1]);
                        $("#heur3").val(response[2]);
                        $("#heur4").val(response[3]);
                        $("#heur5").val(response[4]);
                        $("#heur6").val(response[5]);
                        $("#maj").val('maj');
                    } else {
                        $("#heur1").val('');
                        $("#heur2").val('');
                        $("#heur3").val('');
                        $("#heur4").val('');
                        $("#heur5").val('');
                        $("#heur6").val('');                        
                    }
                    console.log(response);
                },
                error: function(xhr, status, error) {
                    console.error(error);
                }
            });
        });

    </script>
</body>
</html>