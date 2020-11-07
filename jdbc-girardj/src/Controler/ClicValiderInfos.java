package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vue.FInfos;


public class ClicValiderInfos implements ActionListener {

	FInfos fi;
	
	public ClicValiderInfos(FInfos fi) {
		this.fi=fi;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		fi.majInfos();
		fi.dispose();
	}

		
	

}
