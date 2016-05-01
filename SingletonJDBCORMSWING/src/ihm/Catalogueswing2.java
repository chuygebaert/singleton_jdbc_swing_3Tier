package ihm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import listeners.CatalogueListener;
import metier.CatalogueMetierImpl;
import metier.Produit;

public class Catalogueswing2 extends JFrame{         //listener class externe  (add get et set pour recup champs)   
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private JTable jt;
        private JLabel jl =new JLabel("mot cle");
        private JTextField jtf =new JTextField(12);
        private JButton jb =new JButton("Rechercher");
        private JButton jb2 =new JButton("Liste");
     
        
        private ProduitModel model;
        
        private CatalogueMetierImpl metier =new CatalogueMetierImpl();
        
     public Catalogueswing2(){
    	 
    	 JPanel jp1 =new JPanel();
    	 jp1.setLayout(new FlowLayout());
    	 jp1.add(jl);jp1.add(jtf);jp1.add(jb);jp1.add(jb2);
    	 
    	 this.add(jp1,BorderLayout.NORTH);
    	 
    	 model =new ProduitModel();
    	 jt =new JTable(model);
    	 JScrollPane jscroll =new JScrollPane(jt);
    	 this.add(jscroll,BorderLayout.CENTER);
    	 
    	 this.setVisible(true);
    	 this.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
    	 this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	 jb.addActionListener(new CatalogueListener(this));
    	 jb2.addActionListener(new CatalogueListener(this));
    	 
      }

	public JButton getJb2() {
		return jb2;
	}

	public void setJb2(JButton jb2) {
		this.jb2 = jb2;
	}

	public JButton getJb() {
		return jb;
	}

	public void setJb(JButton jb) {
		this.jb = jb;
	}

	public JTextField getJtf() {
		return this.jtf;
	}

	public void setJtf(JTextField jtf) {
		this.jtf = jtf;
	}

	public ProduitModel getModel() {
		return this.model;
	}

	public void setModel(ProduitModel model) {
		this.model = model;
	}
   }
  

 
