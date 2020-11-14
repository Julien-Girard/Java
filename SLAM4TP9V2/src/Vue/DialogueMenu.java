package Vue;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.sql.*;

import javax.swing.*;

import Controler.ClicAnnulerDialogMenu;
import Controler.ClicValiderDialogMenu;

@SuppressWarnings("serial")
public class DialogueMenu extends JDialog{
	
	private JLabel ltitre ;
	private JRadioButton rbajoutimprimante ;
	private JRadioButton rbajoutercartouche ;
	private JRadioButton rblisterimprimante;
	private ButtonGroup bgoperations ;
	private DialogueChoixImprimante dialogf;

	public DialogueMenu (){
		super();
		build();
	}

	private void build() {
		// TODO Auto-generated method stub
		// mise en forme fenetre
		this.setTitle("Toner Express");
		this.setSize(500, 400);
				
		// creation des composants
		ltitre = new JLabel("Entreprise Toner Express");
		rbajoutimprimante = new JRadioButton("Ajouter une imprimante");
		rbajoutercartouche = new JRadioButton("Ajouter une cartouche");
		rblisterimprimante = new JRadioButton("Lister les imprimantes");
		bgoperations = new ButtonGroup();
		bgoperations.add(rbajoutimprimante);
		bgoperations.add(rbajoutercartouche);
		bgoperations.add(rblisterimprimante);
		JButton bannuler = new JButton("Annuler");
		JButton bvalider = new JButton("Valider");
		
		JPanel panelprincipal = new JPanel();
		panelprincipal.setLayout(new BorderLayout());
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(3,0));
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		
		// abonnement listeners
		bannuler.addActionListener(new ClicAnnulerDialogMenu(this));
		bvalider.addActionListener(new ClicValiderDialogMenu(this));
		
		panel1.add(ltitre);
		panel2.add(rbajoutimprimante);
		panel2.add(rbajoutercartouche);
		panel2.add(rblisterimprimante);
		panel3.add(bannuler);
		panel3.add(bvalider);
		
		panelprincipal.add(panel1, BorderLayout.NORTH);
		panelprincipal.add(panel2, BorderLayout.CENTER);
		panelprincipal.add(panel3, BorderLayout.SOUTH);
		
		this.getContentPane().add(panelprincipal);
		
	}

	public JLabel getLtitre() {
		return ltitre;
	}

	public JRadioButton getRbajoutimprimante() {
		return rbajoutimprimante;
	}

	public JRadioButton getRbajoutercartouche() {
		return rbajoutercartouche;
	}
	
	public JRadioButton getRblisterimprimante() {
		return rblisterimprimante;
	}

	public ButtonGroup getBgoperations() {
		return bgoperations;
	}

	public DialogueChoixImprimante getDialogf() {
		return dialogf;
	}

	public void setDialogf(DialogueChoixImprimante dialogf) {
		this.dialogf = dialogf;
	}
	
}
