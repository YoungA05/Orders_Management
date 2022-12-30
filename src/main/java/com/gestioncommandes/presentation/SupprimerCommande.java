package com.gestioncommandes.presentation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.gestioncommandes.dao.CommandeDAO;
import com.gestioncommandes.dao.ProduitDAO;
import com.gestioncommandes.metier.ICommande;
import com.gestioncommandes.metier.IProduit;

/**
 * Servlet implementation class SupprimerCommande
 */
public class SupprimerCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerCommande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nom = request.getParameter("nom");	
			ICommande com = new CommandeDAO();
			com.delete(nom);
			}catch(Exception e) {e.getMessage();}
		     response.sendRedirect("ListerCommandes.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
