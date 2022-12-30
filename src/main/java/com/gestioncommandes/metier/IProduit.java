package com.gestioncommandes.metier;

import java.util.Collection;



import com.gestioncommandes.entities.Produit;

public interface IProduit {
	public Produit findOne(String nom);
	public Collection<Produit> findAll();
	public void add(Produit produit);
	public void update(Produit produit);
	public void delete(String nom);
	
	

}
