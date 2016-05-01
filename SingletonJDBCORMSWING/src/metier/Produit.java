package metier;

import java.io.Serializable;

public class Produit implements Serializable{                           
	//projet pas hibernate pas jpa pas session util orm classic   mvc
	// avec singleton
	 private String ref;
	 private String designation;
	 private double prix;
	 
	 private Categorie categorie;             //asso bidirect(dans la bdd cle etrangere idcat)
	 public Produit() {
		
	}
	
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Produit(String designation,double prix,String ref,
			int qte) {
		super();
		this.ref = ref;
		this.designation = designation;
		this.prix = prix;
		this.qte = qte;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	private int qte;
	 

}
