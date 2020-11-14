package Modele;

public class Cartouche {
	private String refCartouche;
	private String desCartouche;
	private double prixNeuve;
	
	public Cartouche() {
	}
	
	public Cartouche(String refCartouche, String desCartouche, double prixNeuve) {
		//super();
		this.refCartouche = refCartouche;
		this.desCartouche = desCartouche;
		this.prixNeuve = prixNeuve;
	}
	public double getPrixNeuve() {
		return prixNeuve;
	}
	public void setPrixNeuve(double prixNeuve) {
		this.prixNeuve = prixNeuve;
	}
	public String getDesCartouche() {
		return desCartouche;
	}
	public String getRefCartouche() {
		return refCartouche;
	}
	public String toString(){
		return("Référence : " + getRefCartouche() + ", désignation : "+getDesCartouche()+", prix neuve : "+getPrixNeuve());
	}
}
