package Modele;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import Vue.FVisiteurMedical;


public class FocusNom implements FocusListener {

	private FVisiteurMedical f;
	
	
	public FocusNom(FVisiteurMedical fen) {
		this.f=fen;
	}
	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		f.upperCaseNom();
	}

}
