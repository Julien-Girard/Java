package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JOptionPane;

import Modele.Cartouche;
import Modele.Imprimante;
import Vue.DialogueAjoutCartouche;
import Vue.DialogueAjoutImprimante;
import DAO.DAOCartouche;
import DAO.DAOTypeImprimante;
import Main.Application;


public class ClicValiderDialogAjoutCart implements ActionListener{

	DialogueAjoutCartouche dialog;
	
	public ClicValiderDialogAjoutCart(DialogueAjoutCartouche dialog) {
		super();
		// TODO Auto-generated constructor stub
		this.dialog = dialog;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//DAO_TonerExpress dao = new DAO_TonerExpress();
		
		DAOCartouche daoCart = new DAOCartouche();
		
		String ref = this.dialog.gettRef().getText();
		String desc = this.dialog.gettDesc().getText();
		double prix = Double.valueOf(this.dialog.gettPrix().getText());
		
		Cartouche cartouche = new Cartouche(ref, desc, prix);
		daoCart.create(cartouche);
	}
	
}


