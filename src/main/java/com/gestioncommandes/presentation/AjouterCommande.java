package com.gestioncommandes.presentation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.gestioncommandes.dao.CommandeDAO;
import com.gestioncommandes.dao.ProduitDAO;
import com.gestioncommandes.entities.Commande;
import com.gestioncommandes.entities.Produit;
import com.gestioncommandes.metier.ICommande;
import com.gestioncommandes.metier.IProduit;

/**
 * Servlet implementation class AjouterCommande
 */
public class AjouterCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterCommande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name = request.getParameter("nom");	
			float price = Float.parseFloat(request.getParameter("prix"));
			int quantite= Integer.parseInt(request.getParameter("Qte"));
			ICommande c = new CommandeDAO();
			c.add("Client1",name,quantite);
			}catch (Exception e) {e.getMessage();}
			
			
			
	    	
	        response.sendRedirect("EffectuerCommande.jsp");
	        	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
