package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vue.DialogueAjoutImprimante;

public class ClicAnnulerDialogAjoutImp implements ActionListener{

	DialogueAjoutImprimante dialog;
	
	public ClicAnnulerDialogAjoutImp(DialogueAjoutImprimante dialog) {
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
