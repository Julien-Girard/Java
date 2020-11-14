package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vue.DialogueAjoutCartouche;

public class ClicAnnulerDialogAjoutCart implements ActionListener{

	DialogueAjoutCartouche dialog;
	
	public ClicAnnulerDialogAjoutCart(DialogueAjoutCartouche dialog) {
		super();
		// TODO Auto-generated constructor stub
		this.dialog = dialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.dialog.dispose();
	}

}
