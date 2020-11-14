package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vue.DialogueChoixImprimante;

public class ClicAnnulerDialogChoixImp implements ActionListener{

	DialogueChoixImprimante dialog;
	
	public ClicAnnulerDialogChoixImp(DialogueChoixImprimante dialog) {
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
