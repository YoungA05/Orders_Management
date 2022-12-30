package com.gestioncommandes.entities;

public class Client {
	
	private String id;
	private String nom;
	private int age;
	private String Nationnalite;
	private Panier panier;
	
	//Constructeurs
	public Client(String id, String nom, int age, String nationnalite, Panier panier) {
		super();
		this.id = id;
		this.nom = nom;
		this.age = age;
		Nationnalite = nationnalite;
		this.panier = panier;
	}

	public Client() {
		super();
		
	}
	
    // Getters et Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNationnalite() {
		return Nationnalite;
	}

	public void setNationnalite(String nationnalite) {
		Nationnalite = nationnalite;
	}
	
	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	//ToString
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", age=" + age + ", Nationnalite=" + Nationnalite + "]";
	}
	
	
	
	
	

}
