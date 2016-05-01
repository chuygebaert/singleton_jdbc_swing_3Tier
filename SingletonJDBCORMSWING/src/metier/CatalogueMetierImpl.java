
package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.Singleton1;

public class CatalogueMetierImpl implements ICatalogueMetier { // orm classique
																// avec
																// singleton

	@Override
	public void addCategorie(Categorie c) {

		try {
			Connection co = Singleton1.getCo();
			PreparedStatement pst = co.prepareStatement("insert into categorie(nomCategorie)values(?)");
			pst.setString(1, c.getNomCategorie());
			pst.executeUpdate();
			pst.close();
			co.close();
		} catch (Exception e) {
			e.getMessage();
		}

	}

	@Override
	public void addProduit(Produit p, int idCat) {

		try {
			Connection co = Singleton1.getCo();
			PreparedStatement pst = co.prepareStatement("insert into produit values(?,?,?,?,?)");
			pst.setString(1, p.getDesignation());
			pst.setDouble(2, p.getPrix());
			pst.setString(3, p.getRef());
			pst.setInt(4, p.getQte());
			pst.setInt(5, idCat);
			pst.executeUpdate();
			pst.close();
			co.close();
		} catch (Exception e) {
			e.getMessage();
		}

	}

	@Override
	public List<Produit> getProduitParmc(String mc) {
		List<Produit> produits = new ArrayList<Produit>();
		try {
			Connection co = Singleton1.getCo();
			PreparedStatement pst = co.prepareStatement("select * from produit where designation like ?");
			pst.setString(1, "%" + mc + "%");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Produit p = new Produit();
				p.setDesignation(rs.getString("designation"));
				p.setPrix(rs.getDouble("prix"));
				p.setRef(rs.getString("ref"));
				p.setQte(rs.getInt("qte"));
				int idCat = rs.getInt("idCat");
				// on recup l'idCat
				PreparedStatement pst2 = co.prepareStatement("select * from categorie where idCat = ?");
				pst2.setInt(1, idCat);
				ResultSet rs2 = pst2.executeQuery();
				rs2.next();
				Categorie c = new Categorie(); // on recup l'idcat
				c.setIdCategorie(rs2.getInt("idCat"));
				c.setNomCategorie(rs2.getString("nomCategorie"));
				p.setCategorie(c); // on modifie le champ cat du produit
				produits.add(p);
			}

			pst.close();
			co.close();
		} catch (Exception e) {
			e.getMessage();
		}
		return produits;

	}

	@Override
	public List<Produit> getProduitParCat(int idCategorie) {
		List<Produit> produits = new ArrayList<Produit>();
		try {
			Connection co = Singleton1.getCo();
			PreparedStatement pst = co.prepareStatement("select * from produit where idCat = ?");
			pst.setInt(1, idCategorie);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Produit p = new Produit();
				p.setDesignation(rs.getString("designation"));
				p.setPrix(rs.getDouble("prix"));
				p.setRef(rs.getString("ref"));
				p.setQte(rs.getInt("qte"));

				PreparedStatement pst2 = co.prepareStatement("select * from categorie where idCat = ?");
				pst2.setInt(1, rs.getInt("idCat"));
				ResultSet rs2 = pst2.executeQuery();
				rs2.next();
				Categorie c = new Categorie();
				c.setIdCategorie(rs2.getInt("idCat"));
				c.setNomCategorie(rs2.getString("nomCategorie"));
				produits.add(p);
			}

			pst.close();
			co.close();
		} catch (Exception e) {
			e.getMessage();
		}
		return produits;

	}

	@Override
	public List<Produit> getAllProduit() {
		List<Produit> produits = new ArrayList<Produit>();
		try {
			Connection co = Singleton1.getCo();
			PreparedStatement pst = co.prepareStatement("select * from produit");

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Produit p = new Produit();
				p.setDesignation(rs.getString("designation"));
				p.setPrix(rs.getDouble("prix"));
				p.setRef(rs.getString("ref"));
				p.setQte(rs.getInt("qte"));
				// on recup l'idCat
				PreparedStatement pst2 = co.prepareStatement("select * from categorie where idCat like ?");
				pst2.setInt(1, rs.getInt("idCat"));
				ResultSet rs2 = pst2.executeQuery();
				rs2.next();
				Categorie c = new Categorie();
				c.setIdCategorie(rs2.getInt("idCat"));
				c.setNomCategorie(rs2.getString("nomCategorie"));
				p.setCategorie(c);
				produits.add(p);
			}

			pst.close();
			co.close();
		} catch (Exception e) {
			e.getMessage();
		}
		return produits;

	}

	@Override
	public List<Categorie> getAllCategorie() {
		List<Categorie> cats = new ArrayList<Categorie>();
		try {
			Connection co = Singleton1.getCo();
			PreparedStatement pst = co.prepareStatement("select * from categorie");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Categorie c = new Categorie();
				c.setIdCategorie(rs.getInt("idCat"));
				c.setNomCategorie(rs.getString("nomCategorie"));
				cats.add(c);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return cats;
	}

	@Override
	public Categorie getCategorie(int idCategorie) {
		Categorie c = new Categorie();
		try {
			Connection co = Singleton1.getCo();
			PreparedStatement pst = co.prepareStatement("select * from categorie where idCat = ?");
			pst.setInt(1, idCategorie);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				c.setIdCategorie(rs.getInt("idCat"));
				c.setNomCategorie(rs.getString("nomCategorie"));
			}

		} catch (Exception e) {
			e.getMessage();
		}
		return c;
	}

}
