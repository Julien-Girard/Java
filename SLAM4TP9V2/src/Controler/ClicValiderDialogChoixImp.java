package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import DAO.DAOImprimante;
import Modele.Imprimante;
import Vue.DialogueChoixImprimante;


public class ClicValiderDialogChoixImp implements ActionListener{

	DialogueChoixImprimante dialog;
	
	public ClicValiderDialogChoixImp(DialogueChoixImprimante dialog) {
		super();
		// TODO Auto-generated constructor stub
		this.dialog = dialog;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		DAOImprimante daoImp = new DAOImprimante();
		
		JOptionPane optionpane = new JOptionPane("Message");
		String texte = null;
		Imprimante imp = (Imprimante) this.dialog.getCbimprimante().getSelectedItem();
		
		int nb = daoImp.getNbCartoucheCompatible(imp.getRefImprimante());
		
		texte = "Pour l'imprimante : " + imp.getRefImprimante() + ", il existe " + nb + " cartouche(s)";

		optionpane.showMessageDialog(this.dialog, texte);
		
	}
	
}


