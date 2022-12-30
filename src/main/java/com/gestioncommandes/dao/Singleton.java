package com.gestioncommandes.dao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class Singleton {
    private static Singleton uniqueinstance;
	private Singleton() {
		
	}
	
	public static Singleton getinstance() {
		if(uniqueinstance == null) {
			return new Singleton();
		}
		return uniqueinstance;
		
	}
	
	public  MongoDatabase getconnexion() {
		
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		System.out.println("Created Mongo Connection successfully");
		MongoDatabase db = mongoClient.getDatabase("GestionCommandes");
		System.out.println("Get database is successful");
		 
		
		return db;
		
	}
	

}
