package listeners;

import ihm.Catalogueswing2;
import ihm.ProduitModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextField;

import metier.CatalogueMetierImpl;
import metier.Produit;

public class CatalogueListener implements ActionListener { //C
         private Catalogueswing2 cat2;                               //V
         private CatalogueMetierImpl metier =new CatalogueMetierImpl();                        //M
         
	public CatalogueListener(Catalogueswing2 cat2) {
			
			this.cat2 = cat2;
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		 JButton jb =cat2.getJb();
		 JButton jb2 =cat2.getJb2();
		 JTextField jtf = cat2.getJtf();
		 String mc =jtf.getText();
		 
		 ProduitModel model =cat2.getModel();
		if(e.getSource()==jb){
		
		 List<Produit> produits=metier.getProduitParmc(mc);
         model.loadData(produits);
		 System.out.println("\n listener button ok!");
		 }
		else if(e.getSource()==jb2){
		 List<Produit> produits2 =metier.getAllProduit();
		 model.loadData(produits2);
		 
		}
		
	}
} 
	    

	


