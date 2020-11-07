package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vue.FVisiteurMedical;


public class ClicMenu implements ActionListener {
	
	private FVisiteurMedical f;
	
		
	public ClicMenu(FVisiteurMedical fen) {
		this.f=fen;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Ajouter")) {
			this.f.afficheMedecinPannel();
		}
		else {
			if (e.getActionCommand().equals("Lister")) {
				this.f.afficheListePannel();
			}
		}
	}

}
