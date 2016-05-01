package tests;

import java.util.ArrayList;
import java.util.List;

import metier.CatalogueMetierImpl;
import metier.Categorie;
import metier.Produit;

public class TestSingletonMetier {          
        
	public static void main(String[] args) {
		CatalogueMetierImpl metier =new CatalogueMetierImpl();
		
		/*metier.addCategorie(new Categorie("salle de bains"));*/
		metier.addProduit(new Produit("cuisine",574,"kitc",1),1);/*
		List<Produit> prods =metier.getProduitParmc("c");
		for(Produit p:prods){
			System.out.println(p.getDesignation());
		
		List<Produit> prods =metier.getAllProduit();
		for(Produit p:prods){
			System.out.println(p.getDesignation()+" "+p.getPrix()+" "
					+p.getQte()+" "+p.getRef());
		Categorie c=metier.getCategorie(1);
		System.out.println(c.getNomCategorie());
		
		List<Produit> prods =metier.getProduitParCat(1);
		for(Produit p:prods){
			System.out.println("\n designation :"+p.getDesignation()+" prix :"+p.getPrix()+" quantite :"
					+p.getQte()+" reference :"+p.getRef());
		
		List<Categorie> cats =metier.getAllCategorie();
		for(Categorie c:cats){
			System.out.println("\n nom categorie :"+c.getNomCategorie());*/
		}
	}

	  
