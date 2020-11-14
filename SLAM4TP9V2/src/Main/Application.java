package Main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingUtilities;

import DAO.PostGreConnection;
import Vue.DialogueMenu;

public class Application {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// utilisation d'invokelater pour execution dans EDC
		
		SwingUtilities.invokeLater(new Runnable(){
			// utilisation d'une classe Anonyme
			@Override
			public void run() {
				// TODO Auto-generated method stub
				// Ex�cution de la fenetre principale
				
				DialogueMenu dialog = new DialogueMenu();
				dialog.setVisible(true);
				
				}
			}
		);
		
	}

}
