package com.gestioncommandes.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.bson.Document;

import com.gestioncommandes.entities.Produit;
import com.gestioncommandes.metier.IProduit;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class ProduitDAO implements IProduit{

	@Override
	public Produit findOne(String nom) {
		Produit pr = new Produit();
		try {
			
			MongoDatabase db = Singleton.getinstance().getconnexion();
			MongoCollection<Document>  collection= db.getCollection("Produit");
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("name", nom);
			//System.out.println("Retrieving specific Mongo Document");
			MongoCursor<Document> cursor = collection.find(searchQuery).iterator();
			while (cursor.hasNext()) {
				 var doc = cursor.next();
				 var users = new ArrayList<>(doc.values());
				 pr.setNom((String) users.get(1));
				 pr.setPrix((double) users.get(2));
				 pr.setId((String) users.get(3));
				 
			}
			
			
			
		}catch(MongoException ex) {
			System.out.println(" Erreur MongoDB : "+ ex.getMessage());
		}
		return pr;
		
	}

	@Override
	public Collection<Produit> findAll() {
		
		Collection<Produit> Produits = new ArrayList<Produit>();
		/*MongoDatabase db = Singleton.getinstance().getconnexion();
		MongoCollection<Document>  collection= db.getCollection("Produit");*/
		//ConnectionMongoDB o = new ConnectionMongoDB();
		MongoClient mongoclient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase db = mongoclient.getDatabase("GestionCommandes");
		MongoCollection<Document> collection = db.getCollection("Produit");
		try {
		
		
		FindIterable<Document> iterDoc =  collection.find();
		int i = 1;
		 //Getting the iterator
		System.out.println("Listing All Mongo Documents");
		Iterator it =  iterDoc.iterator();
		while (it.hasNext()) {
			
			Document doc = (Document) it.next();
			
			String nom =   doc.getString("Nom");
			double prix =   doc.getDouble("Prix");
			String id =  doc.getString("id");
			Produit p = new Produit(id,nom,prix);
		    Produits.add(p);
			
			i++;
			/*FindIterable<Document> iterdoc = collection.find();
			 Iterator it = iterdoc.iterator();
			 while (it.hasNext()) {
				 System.out.println(it.next());*/
		}
		} catch (Exception e) {
			System.out.println(" Erreur ! "+e.getMessage());
		}
		
		return Produits;
	}

	@Override
	public void add(Produit produit) {
		MongoClient mongoclient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase db = mongoclient.getDatabase("GestionCommandes");
		MongoCollection<Document> collection = db.getCollection("Produit");
		try {
		Document doc =new Document("Nom",produit.getNom());
		doc.append("Prix",produit.getPrix());  
		doc.append("id",produit.getId());  
		
		collection.insertOne(doc);
		System.out.println("Insert is completed");
		}catch (Exception e) {
			System.out.println("Erreur"+ e.getMessage());
		}
	}

	@Override
	public void update(Produit produit) {
		MongoClient mongoclient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase db = mongoclient.getDatabase("GestionCommandes");
		MongoCollection<Document> collection = db.getCollection("Produit");
		try {
		collection.updateOne(Filters.eq("Nom", produit.getNom()), Updates.set("Prix", produit.getPrix()));       
		System.out.println("Document updated successfully...");  
		}catch (Exception e) {
			System.out.println("Erreur "+e.getMessage());
		}
		
	}

	@Override
	public void delete(String nom) {
		
		MongoClient mongoclient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase db = mongoclient.getDatabase("GestionCommandes");
		MongoCollection<Document> collection = db.getCollection("Produit");
		
		collection.deleteOne(Filters.eq("name", nom)); 
		System.out.println("Document deleted successfully...");
		
	}

}
