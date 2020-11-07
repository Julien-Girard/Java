package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vue.FVisiteurMedical;


public class ClicAnnuler implements ActionListener {
	private FVisiteurMedical f;
	
	
	public ClicAnnuler(FVisiteurMedical fen) {
		this.f=fen;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		f.annuler();
	}

}
