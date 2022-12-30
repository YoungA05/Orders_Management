<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter un produit</title>
<style>
      
      body{
            background-image: url("Background.jpg");
            background-size: 100%;
            background-attachment: fixed;
       
       }
        h1{
         font-size : 45px;
         text-align : center;
         font-family: pristina;
         color : darkred;
    }
    #affichage{
        margin-left : 450px;
    }
    th{
         font-family : Berlin sans FB;
         background-color : rgb(194,194,194);
         border-radius:15px;
         padding : 5px;
    
    }
    input{
        font-family : Consolas; 
         border-radius:15px;
    }
    .Addform{
        margin-top : 100px;
        
    }
    #formtable{
       background-color : hsla(0,20%,80%,0.5);
       padding : 10px;
       border-radius : 15px;
      
    }
    #addbutton{
       border-radius : 15px;
       font-family : Consolas;
    }
    .footer{
        font-family : Rockwell condensed;
        text-align : center;
     
    }
    hr{
             width: 1000px;
             box-shadow: 2px 0px 1px darkred;
             margin-top: 350px;
    
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
       margin-left : 620px;
       margin-top : 30px;
    }
    



</style>
</head>
<body>
<br>
<br>
<br>
<br>
<br>
<br>
   <h1 > Ajouter un produit : </h1>
   <div id="affichage">
	<form class= "Addform" action="AjouterProduit" method="post">
	<table id="formtable">
	<tr>
	<th>Nom du produit</th>
	<th>Prix du produit</th>
	<th>Id du produit</th>
	</tr>
	<tr>
		<td>
			<input id="1" name="nom" type="text" />
		</td>
		<td>
			<input id="2" name="prix" type="number"/>
		</td>
		<td>
			<input id="3" name="id" type="text" />
		</td>

	<td>
		<button id="addbutton"type="submit" class="addbutton" >Ajouter</button>
	</td>
	</tr>
	</table>
	</form></div>
	
	 <form  class="buttonform"action="index.jsp" method ="get">
    <table>
    <tr>
    <td>
    <button  id="retouracceuil" type="submit">Retourner vers la page d'accueil</button>
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