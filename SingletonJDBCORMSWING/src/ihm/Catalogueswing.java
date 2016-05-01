package ihm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import metier.CatalogueMetierImpl;
import metier.Produit;

public class Catalogueswing extends JFrame{        //class interne listener
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private JTable jt;
        private JLabel jl =new JLabel("keyword");
        private JTextField jtf =new JTextField(12);
        private JButton jb =new JButton("OK");
     
        private ProduitModel model;
        
        private CatalogueMetierImpl metier =new CatalogueMetierImpl();
        
     public Catalogueswing(){
    	 
    	 JPanel jp1 =new JPanel();
    	 jp1.setLayout(new FlowLayout());
    	 jp1.add(jl);jp1.add(jb);
    	 jp1.add(jtf);
    	 this.add(jp1,BorderLayout.NORTH);
    	 
    	 model =new ProduitModel();
    	 jt =new JTable(model);
    	 JScrollPane jscroll =new JScrollPane(jt);
    	 this.add(jscroll,BorderLayout.CENTER);
    	 
    	 this.setVisible(true);
    	 this.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
    	 this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	 jb.addActionListener(new Listener1());
    	
      }
     
     
         class Listener1 implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				String mc =jtf.getText();
				List<Produit> produits=metier.getProduitParmc(mc);
                model.loadData(produits);
				System.out.println("\n listener button ok!");
				
			}
        }
        
  }

 
