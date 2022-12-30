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
<title>Liste des Commandes</title>
</head>
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
             margin-top: 250px;
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
        margin-left : 525px;
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
       margin-left : 460px;
    }
    .buttonimpression{
       font-family : pristina;
       padding : 20px;
       font-size: 20px;
       color : white;
       background-color:rgb(0,168,0);
       border-radius : 15px;
    
    }



</style>

<body>
 <h1 style="color : darkred"> Vos commandes : </h1>
 
 <%		
		
		
		MongoClient mongoclient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase db = mongoclient.getDatabase("GestionCommandes");
		MongoCollection<Document> collection = db.getCollection("Commande");
		try {
		
			FindIterable<Document> iterdoc = collection.find();
			 Iterator it = iterdoc.iterator();
			 while (it.hasNext()) {
				 Document doc = (Document)it.next();

				 %>

<div id="affichage">
<form action="SupprimerCommande" method = "post">
 <table class="table table-striped">
	<tr>
		
		<th>Nom du produit</th>
		<th>Quantité commandée</th>
		
	</tr>
<tr>
		<td >
    							<input id="name" name="produit" value="<%out.println(doc.get("Produit")); %>" readonly/>
		    	  			</td>
    						<td>
    							<input id="price" name="Qte" value="<%out.println(doc.get("Qte")); %>"  readonly/>
    							
		    	   			</td>
    						
		
		    	   			<td>
		    	   			    <button id="deletebutton" type="submit">Supprimer la commande</button>
		    	   			</td>
    						
		
	</tr>
	
	
 <% 
		}
		}catch (Exception e) {
			System.out.println(" Erreur ! "+e.getMessage());
		}    
%>
    
    </table>
	</form>
	</div>
	
    <br>
    <form  class="buttonform"action="index.jsp" method ="get">
    <table>
    <tr>
    <td>
    <button  id="retouracceuil" type="submit">Retourner vers la page d'accueil</button>
    </td>
    <td>
    <button  id="retouracceuil"type="submit" formaction="EffectuerCommande.jsp">Effectuer une commande</button>
    </td>
    <td>
    <button  class ="buttonimpression" type="submit" formaction="ListerCommandes.jsp" onClick="window.print()">Imprimer cette page</button>
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