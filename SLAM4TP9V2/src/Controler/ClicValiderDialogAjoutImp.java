package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.DAOImprimante;
import Main.Application;
import Modele.Cartouche;
import Modele.Imprimante;
import Modele.TypeImprimante;
import Vue.DialogueAjoutCartouche;
import Vue.DialogueAjoutImprimante;


public class ClicValiderDialogAjoutImp implements ActionListener{

	DialogueAjoutImprimante dialog;
	
	public ClicValiderDialogAjoutImp(DialogueAjoutImprimante dialog) {
		super();
		// TODO Auto-generated constructor stub
		this.dialog = dialog;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		DAOImprimante daoImp = new DAOImprimante();
		
		String ref = this.dialog.gettRef().getText();
		String desc = this.dialog.gettDesc().getText();
		TypeImprimante typImp = (TypeImprimante) this.dialog.getcbType().getSelectedItem();
					
		Imprimante imprimante = new Imprimante(ref, typImp, desc, new ArrayList<Cartouche>());
		
		daoImp.create(imprimante); 

	}
	
}


