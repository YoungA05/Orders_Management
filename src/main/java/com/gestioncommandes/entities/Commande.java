package com.gestioncommandes.entities;

public class Commande {
	
	private Client client;
	private Produit produit;
	private int Qte;
	
	//Constructeurs
	public Commande(Client client, Produit produit, int qte) {
		super();
		this.client = client;
		this.produit = produit;
		Qte = qte;
	}

	public Commande() {
		super();
		
	}
    
	//Getters et Setters
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public int getQte() {
		return Qte;
	}

	public void setQte(int qte) {
		Qte = qte;
	}
    
	//ToString
	@Override
	public String toString() {
		return "Commande [client=" + client + ", produit=" + produit + ", Qte=" + Qte + "]";
	}
	
	
	
	
	
	
	

}
