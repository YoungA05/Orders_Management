package com.gestioncommandes.entities;

import java.util.Collection;


public class Panier {
	private Collection<Commande> commandes;
    
	//Constructeurs
	public Panier(Collection<Commande> commandes) {
		super();
		this.commandes = commandes;
	}

	public Panier() {
		super();// TODO Auto-generated constructor stub
	}

	public Collection<Commande> getCommandes() {
		return commandes;
	}
    
	//Getters et Setters
	public void setCommandes(Collection<Commande> commandes) {
		this.commandes = commandes;
	}
    
	//ToString
	@Override
	public String toString() {
		return "Panier [commandes=" + commandes + "]";
	}
	
	
	
	

}
