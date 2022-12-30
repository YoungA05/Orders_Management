package com.gestioncommandes.dao;

import java.util.Collection;

import org.bson.Document;

import com.gestioncommandes.entities.Commande;
import com.gestioncommandes.metier.ICommande;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;

public class CommandeDAO implements ICommande{

	@Override
	public Commande findOne() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Commande> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(String client, String produit, int qte) {
		MongoClient mongoclient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase db = mongoclient.getDatabase("GestionCommandes");
		MongoCollection<Document> collection = db.getCollection("Commande");
		try {
		Document doc =new Document("Client",client);
		doc.append("Produit",produit);  
		doc.append("Qte",qte);  
		
		collection.insertOne(doc);
		System.out.println("Insert is completed");
		}catch (Exception e) {
			System.out.println("Erreur"+ e.getMessage());
		}
		
	}

	@Override
	public void update(Commande commande) {
		MongoClient mongoclient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase db = mongoclient.getDatabase("GestionCommandes");
		MongoCollection<Document> collection = db.getCollection("Commande");
		try {
		collection.updateOne(Filters.eq("Qte", commande.getQte()), Updates.set("Qte", commande.getQte()));       
		System.out.println("Document updated successfully...");  
		}catch (Exception e) {
			System.out.println("Erreur "+e.getMessage());
		}
		
	}

	@Override
	public void delete(String nom) {
		MongoClient mongoclient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase db = mongoclient.getDatabase("GestionCommandes");
		MongoCollection<Document> collection = db.getCollection("Commande");
		
		BasicDBObject theQuery = new BasicDBObject();
		theQuery.put("name", nom);
		System.out.println(nom);
	    collection.deleteOne(theQuery);
		
	}

}
