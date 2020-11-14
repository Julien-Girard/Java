package Vue;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.*;

import Controler.ClicAnnulerDialogAjoutImp;
import Controler.ClicValiderDialogAjoutImp;
import DAO.DAOTypeImprimante;
import Main.Application;
import Modele.Imprimante;
import Modele.TypeImprimante;


@SuppressWarnings("serial")
public class DialogueAjoutImprimante extends JDialog{
	
	private JTextField tRef, tDesc;
	private JComboBox cbType;
	private JLabel lRef, lDesc, lType;
	private JButton bannuler ;
	private JButton bvalider ;
	private Vector<TypeImprimante> lesTypesImprimantes;

	public DialogueAjoutImprimante (DialogueMenu dialog, boolean b){
		super();
		build();
	}

	public DialogueAjoutImprimante (JDialog dialog, Boolean modal){
		super(dialog,modal);
		build();
	}

	private void build() {
		// TODO Auto-generated method stub
		// mise en forme fenetre
				
		DAOTypeImprimante daoTypeImp = new DAOTypeImprimante();
		
		this.setTitle("Ajout Cartouche");
		this.setSize(500, 400);
		
		// tableau de type imprimante
		this.lesTypesImprimantes = daoTypeImp.findAll();
		
		
		// creation des composants
		bannuler = new JButton("Annuler");
		bvalider = new JButton("Valider");
		tRef = new JTextField("Saisir la référence");
		tDesc = new JTextField("Saisir la descrition");
		cbType = new JComboBox<TypeImprimante>(this.lesTypesImprimantes);
		lRef = new JLabel("Référence");
		tRef.setSize(200, 12);
		lDesc = new JLabel("Description");
		tDesc.setSize(200, 12);
		lType = new JLabel("Type Imprimante");
		
		// abonnement listener
		bannuler.addActionListener(new ClicAnnulerDialogAjoutImp(this));
		bvalider.addActionListener(new ClicValiderDialogAjoutImp(this));
		
		JPanel panelprincipal = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel11 = new JPanel();
		JPanel panel12 = new JPanel();
		JPanel panel13 = new JPanel();
	
		
		panel2.setLayout(new FlowLayout());
		panel1.setLayout(new GridLayout(3,1));
		//panelprincipal.setLayout(new GridLayout(3,0));
		panelprincipal.setLayout(new BorderLayout());
		
		panel11.add(lRef);
		panel11.add(tRef);
		panel12.add(lDesc);
		panel12.add(tDesc);
		panel13.add(lType);
		panel13.add(cbType);
		
		panel1.add(panel11);
		panel1.add(panel12);
		panel1.add(panel13);

		
		
		panel2.add(bannuler);
		panel2.add(bvalider);
		
		JLabel titre = new JLabel("Ajout d'une imprimante");
		JPanel panelTitre = new JPanel();
		panelTitre.add(titre);		
		panelprincipal.add(panelTitre,BorderLayout.NORTH);
		panelprincipal.add(panel1,BorderLayout.CENTER);
		panelprincipal.add(panel2, BorderLayout.SOUTH);
		
		this.getContentPane().add(panelprincipal);
		
	}

	public JButton getBannuler() {
		return bannuler;
	}

	public JButton getBvalider() {
		return bvalider;
	}

	public JTextField gettRef() {
		return tRef;
	}

	public JTextField gettDesc() {
		return tDesc;
	}

	public JComboBox getcbType() {
		return this.cbType;
	}

	public JLabel getlRef() {
		return lRef;
	}

	public JLabel getlDesc() {
		return lDesc;
	}

	public JLabel getlType() {
		return lType;
	}
}
