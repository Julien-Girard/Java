package Modele;
	/**
	 * Class Specialite qui permet de gérer la spécialité du medecin.
	 */

public class Specialite {
	
	private long id;
	private String libelle;


	/**
	 * Constructeur Specialite.
	 */
	public Specialite(long id, String libelle){
		this.id = id;
		this.libelle = libelle;
	}



	public void setId(long id){
		this.id = id;
	}


	public long getId(){
		return this.id;
	}

	public void setLibelle(String libelle){
		this.libelle=libelle;
	}



	@Override
	public String toString() {
		return libelle;
	}

	
}
