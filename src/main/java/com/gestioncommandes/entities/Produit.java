package com.gestioncommandes.entities;

public class Produit {
	private String id;
	private String Nom;
	private double prix;
	
	//Constructeurs
	public Produit(String id, String nom, double prix) {
		super();
		this.id = id;
		Nom = nom;
		this.prix = prix;
	}

	public Produit() {
		super();
		
	}
	
	
	//Getters et Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
    
	//ToString
	@Override
	public String toString() {
		return "Produit [id=" + id + ", Nom=" + Nom + ", prix=" + prix + "]";
	}
	
	
	
	
	
	
	
	
	

}
