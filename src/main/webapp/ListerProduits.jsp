<%@page import="com.gestioncommandes.entities.Produit"%>
<%@page import="java.util.*"%>
<%@page import ="org.bson.Document"%>
<%@page  import ="com.gestioncommandes.entities.Produit"%>
<%@page   import ="com.gestioncommandes.metier.IProduit"%>
<%@page   import ="com.mongodb.BasicDBObject"%>
<%@page   import ="com.mongodb.MongoException"%>
<%@page   import ="com.mongodb.client.FindIterable"%>
<%@page   import ="com.mongodb.client.MongoClient"%>
<%@page   import ="com.mongodb.client.MongoClients"%>
<%@page   import ="com.mongodb.client.MongoCollection"%>
<%@page   import ="com.mongodb.client.MongoCursor"%>
<%@page   import ="com.mongodb.client.MongoDatabase"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des produits</title>
<style type="text/css">
       body{
            background-image: url("Background.jpg");
            background-size: 100%;
            background-attachment: fixed;
       
       }
       .footer{
        font-family : Rockwell condensed;
        text-align : center;
     
    }
    hr{
             width: 1000px;
             box-shadow: 2px 0px 1px darkred;
    
    }
    h1{
         font-size : 45px;
         text-align : center;
         font-family: pristina;
         color : darkred;
    }
    th{
         font-family : Berlin sans FB;
         background-color : rgb(194,194,194);
         border-radius:15px;
         padding : 5px;
    
    }
    #deletebutton{
        border-radius : 15px;
    }
    #affichage{
        margin-left : 425px;
    }
    input{
        font-family : Consolas; 
         border-radius:15px;
    }
    #retouracceuil{
       font-family : pristina;
       padding : 20px;
       font-size: 20px;
       color : white;
       background-color:black;
       border-radius : 15px;
            
    }
    .buttonform{
       margin-left : 425px;
    }



</style>
</head>
<body>
 <h1 > Produits disponibles : </h1>
 
 <%
	
		
		MongoClient mongoclient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase db = mongoclient.getDatabase("GestionCommandes");
		MongoCollection<Document> collection = db.getCollection("Produit");
		try {
		
			FindIterable<Document> iterdoc = collection.find();
			 Iterator it = iterdoc.iterator();
			 while (it.hasNext()) {
				 Document doc = (Document)it.next();
			 %>
<div id="affichage">			 
<form class ="Form" action="SupprimerProduit" method = "post">
 <table>
	<tr>
		
		<th>Nom</th>
		<th>Prix</th>
		<th>Id</th>
		
	</tr>

	<tr>
		<td >
    							<input id="name" name="nom" value="<%out.println(doc.get("Nom")); %>" readonly/>
		    	  			</td>
    						<td>
    							<input id="price" name="prix" value="<%out.println(doc.get("Prix")); %>"  readonly/>
    							
		    	   			</td>
    						<td name="rate">
								<input id="rate" name="id" value="<%out.println(doc.get("id")); %>" readonly />
		    	   			</td>
		    	   			<td>
		    	   			    <button id="deletebutton" type="submit">Supprimer le produit</button>
		    	   			</td>
    						
		
	</tr>
	
	
 <% 
		}
		}catch (Exception e) {
			System.out.println(" Erreur ! "+e.getMessage());
		}    
%>
    
    </table>
	</form></div>
    <br>
    <form  class="buttonform"action="index.jsp" method ="get">
    <table>
    <tr>
    <td>
    <button  id="retouracceuil" type="submit">Retourner vers la page d'accueil</button>
    </td>
    <td>
    <button  id="retouracceuil"type="submit" formaction="AjouterProduit.jsp">Ajouter un produit</button>
    </td>
    <td>
    <button  id="retouracceuil"type="submit" formaction="EffectuerCommande.jsp">Effectuer une commande</button>
    </td>
    </tr>
    </table>
    </form>
    
    
</body>
<hr>
<div class="footer">
	<footer> &copyCopyright 2022 - Mohammed Aymen El Hafdi </footer>
</div>
</html>