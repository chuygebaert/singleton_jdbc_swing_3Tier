package ihm;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;  //donnees affichees dans un jtable

import metier.Produit;

public class ProduitModel extends AbstractTableModel {
     
	private static final long serialVersionUID = 1L;

		private String[] nomsCols =new String[]
        		{                                    //correspond champs obj /table cols bdd   -> cols
        		  "designation",
        		  "prix",
        		  "ref",
        		  "qte",
        		  "categorie"
                };                
         
         private Vector<String[]> rows =new Vector<String[]>();             //valeurs corresp.  -> rows
          
	@Override
	public int getRowCount() {
		
		return rows.size();
	}

	@Override
	public int getColumnCount() {
	
		return nomsCols.length;
	}
	
	public String getColumnName(int columnIndex) {
	
		return nomsCols[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		return rows.get(rowIndex)[columnIndex];
	}
    //on utlise une list de produits donc on convertit ->vector
	public void loadData(List<Produit> produits){
		rows =new Vector<String[]>();
		for(Produit p:produits){       //chaque ligne=tab de string qui contient valeurs produits
			//conversion
		         rows.add(new String[]{p.getDesignation(),
				 String.valueOf(p.getPrix()),p.getRef(),String.valueOf(p.getQte()),
				 p.getCategorie().getNomCategorie()});//cast string int (valueof)
				
		}
		fireTableChanged(null);         //indique a la vue le chgt
	}
	
}
