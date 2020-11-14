package Modele;

public class TypeImprimante {
	private char codeType;
	private String libType;
	
	public TypeImprimante() {
	}
	
	public TypeImprimante(char codeType, String libType) {
		//super();
		this.codeType = codeType;
		this.libType = libType;
	}
	public char getCodeType() {
		return codeType;
	}
	public String getLibType() {
		return libType;
	}
	public String toString(){
		return ("Type : " + getCodeType() + ", libellé : " + getLibType());
	}
}
