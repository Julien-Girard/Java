package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import DAO.PostGreConnection;
import Vue.DialogueMenu;

public class ClicAnnulerDialogMenu implements ActionListener{

	DialogueMenu dialog;
	Connection connection;
	
	public ClicAnnulerDialogMenu(DialogueMenu dialog) {
		super();
		// TODO Auto-generated constructor stub
		this.dialog = dialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		connection = PostGreConnection.getInstance();
		if (connection != null) {
	        try {
	        	connection.close();
	        } catch (SQLException e1) {
	        	
	        }
	    }
		System.exit(0);
	}

}
