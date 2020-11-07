package Modele;

/**
 * <b>Medecin est la classe représentant un médecin</b>
 * <p>
 * Un médecin est caractérisé par les informations suivantes :
 * <ul>
 * <li>Un identifiant unique attribué définitivement.</li>
 * <li>Un nom, un prénom, une adresse, un téléphone, un email, une spécialité, suceptibles d'être changée.</li>
 * <li>Un ensemble de visites. On peut ajouter, supprimer une viste à cet ensemble de visites</li>
 * </ul>
 * </p>
 * 
 */
public class Medecin {
	
	private long id;
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;
	private String email;
	private Specialite specialite;
	private String infos;

	/**
	 * Constructeur Medecin.
	 */
	public Medecin(long id, String nom, String prenom, String adresse, String telephone, String email, Specialite specialite){
		this.id=id;
		this.nom=nom;
		this.prenom=prenom;
		this.adresse=adresse;
		this.telephone=telephone;
		this.email=email;
		this.specialite=specialite;
		this.infos="nul";
	}
	/**
	 * Retourne le nom du medecin
	 * 
	 * @return Le nom du medecin, sous forme d'une chaine de caract�res.
	 */
	public String getNom(){
		return this.nom;
	}

	/**
	 * Met à jour le nom du médecin.
	 * 
	 * @param 	n Le nouveau nom du médecin
	 */
	public void setNom(String n){
		this.nom=n.toUpperCase();
	}

	/**
	 * Retourne le prénom du medecin
	 * 
	 * @return Le prénom du medecin, sous forme d'une chaine de caractères.
	 */
	public String getPrenom(){
		return this.prenom;
	}
	/**
	 * Met à jour le prénom du médecin.
	 * 
	 * @param 	p Le nouveau prénom du médecin
	 */
	public void setPrenom(String p){
		this.prenom=p;
	}

	/**
	 * Retourne l'adresse du médecin
	 * 
	 * @return L'adresse du medecin, sous forme d'une chaine de caractères.
	 */
	public String getAdresse(){
		return this.adresse;
	}

	/**
	 * Met à jour l'adresse du médecin.
	 * 
	 * @param 	a La nouvelle adresse du médecin
	 */
	public void setAdresse(String s){
		this.adresse=s;
	}

	/**
	 * Retourne le téléphone du medecin
	 * 
	 * @return Le téléphone du medecin, sous forme d'une chaine de caractères.
	 */
	public String getTelephone(){
		return this.telephone;
	}

	/**
	 * Met à jour le téléphone du médecin.
	 * 
	 * @param 	t Le nouveau téléphone du médecin
	 * 			
	 */
	public void setTelephone(String t){
		this.telephone=t;
	}

	/**
	 * Retourne l'email du medecin
	 * 
	 * @return L'email du medecin, sous forme d'une chaine de caract�res.
	 */
	public String getEmail(){
		return this.email;
	}

	/**
	 * Met à jour l'email du médecin.
	 * 
	 * @param 	e Le nouvel email du médecin
	 */
	public void setEmail(String e){
		this.email=e;
	}

	/**
	 * Retourne la spécialitédu médecin
	 * 
	 * @return La spécialité du medecin, sous forme d'une chaine de caractères.
	 */
	public Specialite getSpecialite(){
		return this.specialite;
	}

	/**
	 * Met à jour la spécialité du médecin.
	 * 
	 * @param 	s La nouvelle spécialité du médecin
	 */
	public void setSpecialite(Specialite s){
		this.specialite=s;
	}

	/**
	 * Retourne lidentifiant du medecin
	 * 
	 * @return L'identifiant du medecin, sous forme d'un entier long.
	 */
	public long getId(){
		return this.id;
	}

	/**
	 * Met à jour l'identifiant du médecin.
	 * 
	 * @param 	i Le nouvel identifiant du médecin.
	 */
	public void setId(long id){
		this.id=id;
	}

	/**
	 * Retourne les infos concernant le médecin
	 * 
	 * @return Les infos du médecin, sous forme d'une chaine de caractères.
	 */
	public String getInfos(){
		return this.infos;
	}

	/**
	 * Met à jour les infos concernant le médecin
	 * 
	 * @param 	infos Les nouvelles informations concernant le médecin
	 */
	public void setInfos(String infos){
		this.infos=infos;
	}
	
}
