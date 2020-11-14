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

import Controler.ClicAnnulerDialogChoixImp;
import Controler.ClicValiderDialogChoixImp;
import DAO.DAOImprimante;
import DAO.PostGreConnection;
import Modele.Imprimante;


@SuppressWarnings("serial")
public class DialogueChoixImprimante extends JDialog{
	
	private JComboBox cbimprimante ;
	private JButton bannuler ;
	private JButton bvalider ;
	private Vector<Imprimante> listImp;

	public DialogueChoixImprimante (DialogueMenu dialog, boolean b){
		super();
		build();
	}

	public DialogueChoixImprimante (JDialog dialog, Boolean modal){
		super(dialog,modal);
		build();
	}

	private void build() {
		// TODO Auto-generated method stub
		// mise en forme fenetre
		this.setTitle("Choix imprimante");
		this.setSize(500, 400);
		
		DAOImprimante daoImprim = new DAOImprimante();
		
		// creation des composants
		bannuler = new JButton("Annuler");
		bvalider = new JButton("Valider");
		
		// Chargement des imprimantes
		listImp = daoImprim.findAll();
		
		cbimprimante = new JComboBox(listImp);
		
		// abonnement listener
		bannuler.addActionListener(new ClicAnnulerDialogChoixImp(this));
		bvalider.addActionListener(new ClicValiderDialogChoixImp(this));
		
		JPanel panelprincipal = new JPanel();
		panelprincipal.setLayout(new FlowLayout());
		
		panelprincipal.add(cbimprimante);
		panelprincipal.add(bannuler);
		panelprincipal.add(bvalider);
		
		this.getContentPane().add(panelprincipal);
		
	}

	public JComboBox getCbimprimante() {
		return cbimprimante;
	}

	public JButton getBannuler() {
		return bannuler;
	}

	public JButton getBvalider() {
		return bvalider;
	}

	public Vector<Imprimante> getListImp() {
		return listImp;
	}

	public void setListImp(Vector<Imprimante> listImp) {
		this.listImp = listImp;
	}

}
