package Main;

import javax.swing.SwingUtilities;

import Vue.FVisiteurMedical;

public class Lanceur {


	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				FVisiteurMedical fen = new FVisiteurMedical();
				fen.setVisible(true);
			}
		});
	}

}
