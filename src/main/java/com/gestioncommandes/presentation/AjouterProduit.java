package com.gestioncommandes.presentation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import com.gestioncommandes.dao.ProduitDAO;
import com.gestioncommandes.entities.Produit;
import com.gestioncommandes.metier.IProduit;

/**
 * Servlet implementation class AjouterProduit
 */
public class AjouterProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterProduit() {
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
		String id = request.getParameter("id");
		Produit prod = new Produit(id,name,price);
		IProduit p = new ProduitDAO();
		p.add(prod);}catch (Exception e) {e.getMessage();}
		
		
		
    	
        response.sendRedirect("ListerProduits");
        	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
