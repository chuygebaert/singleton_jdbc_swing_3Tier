
package metier;

import java.util.List;

public interface ICatalogueMetier {
	public void addCategorie(Categorie c);

	public void addProduit(Produit p, int idCategorie);

	public List<Produit> getProduitParmc(String mc);

	public List<Produit> getProduitParCat(int idCategorie);

	public List<Produit> getAllProduit();

	public List<Categorie> getAllCategorie();

	public Categorie getCategorie(int idCategorie);

}
