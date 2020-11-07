package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import DAO.DAOMedecin;
import Vue.FVisiteurMedical;


public class ClicValider implements ActionListener {
	private FVisiteurMedical f;
	
	
	public ClicValider(FVisiteurMedical fen) {
		super();
		this.f=fen;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		DAOMedecin daomed = new DAOMedecin();
		
		daomed.create(f.validerMedecin()); 
	}

}
