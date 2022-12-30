package com.gestioncommandes.metier;

import java.util.Collection;

import com.gestioncommandes.entities.Commande;

public interface ICommande {
	
	public Commande findOne();
	public Collection<Commande> findAll();
	public void add(String client, String produit, int qte);
	public void update(Commande commande);
	public void delete(String nom);

}
