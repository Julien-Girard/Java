package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;

import Vue.FInfos;
import Vue.FVisiteurMedical;


public class ClicCheckInfos implements ActionListener{

	private FVisiteurMedical fvm=null;
	private JCheckBox jcb=null;
	
	public ClicCheckInfos (FVisiteurMedical pfvm, JCheckBox j){
		this.fvm=pfvm;
		this.jcb=j;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (jcb.isSelected() ) {
			FInfos fi = new FInfos(fvm);
			fi.setVisible(true);	
		}
	}

}
