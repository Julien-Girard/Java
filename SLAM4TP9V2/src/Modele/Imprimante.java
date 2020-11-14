package Modele;

import java.util.ArrayList;

public class Imprimante {
	private String refImprimante;
	private TypeImprimante typeImprimante;
	private String desImprimante;
	private ArrayList <Cartouche> lesCartouches;
	
	public Imprimante() {
	}
	
	public Imprimante(String refImprimante, TypeImprimante typeImprimante, String desImprimante, ArrayList<Cartouche> lesCartouches) {
		//super();
		this.refImprimante = refImprimante;
		this.typeImprimante = typeImprimante;
		this.desImprimante = desImprimante;
		this.lesCartouches = lesCartouches;
	}
	public ArrayList<Cartouche> getLesCartouches() {
		return lesCartouches;
	}
	public void setLesCartouches(ArrayList<Cartouche> lesCartouches) {
		this.lesCartouches = lesCartouches;
	}
	public String getDesImprimante() {
		return desImprimante;
	}
	public String getRefImprimante() {
		return refImprimante;
	}
	public TypeImprimante getTypeImprimante() {
		return typeImprimante;
	}
	public int getNbCartouchesCompatibles(){
		return lesCartouches.size();
	}
	public String toString(){
		return(getRefImprimante() + " : "+getDesImprimante());
	}
}
