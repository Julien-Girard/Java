package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vue.DialogueAjoutCartouche;
import Vue.DialogueAjoutImprimante;
import Vue.DialogueChoixImprimante;
import Vue.DialogueMenu;

public class ClicValiderDialogMenu implements ActionListener{

	DialogueMenu dialog;
	
	public ClicValiderDialogMenu(DialogueMenu dialog) {
		super();
		// TODO Auto-generated constructor stub
		this.dialog = dialog;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (this.dialog.getRbajoutercartouche().isSelected() ){
			//traitement si ajouter cartouche
			DialogueAjoutCartouche dialogf1 = new DialogueAjoutCartouche(this.dialog,true);
			dialogf1.setVisible(true);
			
		}
		
		if (this.dialog.getRbajoutimprimante().isSelected()){
			//traitement si ajouter cartouche
			DialogueAjoutImprimante dialogf2 = new DialogueAjoutImprimante(this.dialog,true);
			dialogf2.setVisible(true);
			
			
		}
		
		if (this.dialog.getRblisterimprimante().isSelected()){
			if (this.dialog.getDialogf() == null){
				DialogueChoixImprimante dialogf = new DialogueChoixImprimante(this.dialog,true);
				dialogf.setVisible(true);}
			else
			{	this.dialog.getDialogf().setVisible(true);
			}
		}
	}
		
}


