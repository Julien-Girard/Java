package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import Modele.Cartouche;
import Modele.Imprimante;
import Vue.DialogueAjoutCartouche;
import Vue.DialogueAjoutImprimante;
import Vue.DialogueMenu;
import DAO.DAOCartouche;
import DAO.DAOTypeImprimante;
import Main.Application;

public class test {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// utilisation d'invokelater pour execution dans EDC
		
		SwingUtilities.invokeLater(new Runnable(){
			// utilisation d'une classe Anonyme
			@Override
			public void run() {
				// TODO Auto-generated method stub
				// Ex�cution de la fenetre principale
				
				String ref = "MLG";
				String des = "Cartouche des pros gameurs";
				double prix = 69420;
				
				DAOCartouche daoCart = new DAOCartouche();
				
				Cartouche cartouche = new Cartouche(ref, des, prix);
				daoCart.create(cartouche);
				
				}
			}
		);
		
	}
	
}

