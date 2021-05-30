package municipalite;



import java.util.Date;

import asso.CompteRendu;

import java.util.ArrayList;

public class Arbre {
	
	private String genre, espece, dev, adresse;
	private int circonference,hauteur;
	private  Float[] GPS;
	private boolean remarquable;
	private Date dateDerniereVisite, dateClassification; 
	private ArrayList<CompteRendu> listeComptesRendus = new ArrayList<CompteRendu>(); 
	private int nbNominations;
	
	/**
	 * Constructeur sans paramètre qui crée un arbre "vide"
	 */
	public Arbre() {
		
	}

	/**
	 * Constructeur qui crée un arbre non planté avec le minimum d'informations
	 * @param genre
	 * @param espece
	 * @param nom
	 */
	public Arbre(String genre, String espece) {
		this.genre=genre;
		this.espece=espece;
	}
	
	/**
	 * Constructeur complet 
	 * @param genre le genre de l'arbre
	 * @param espece l'espèce de l'arbre
	 * @param nom le nom de l'arbre
	 * @param GPS les coordonnées GPS de l'arbre dans un tableau
	 * @param circonference la circonférence de l'arbre
	 * @param hauteur la hauteur de l'arbre
	 * @param remarquable le caractère remarquable de l'arbre
	 * @param dev le stade de développement de l'arbre
	 */
	public Arbre(String genre, String espece, Float[] GPS, int circonference, int hauteur , boolean remarquable, String dev ) {
		this(genre,espece);
		this.GPS = GPS;
		this.circonference = circonference;
		this.hauteur = hauteur;
		this.remarquable = remarquable;
		this.dev = dev;
	}
	
	/**
	 * Méthode d'accès au genre de l'arbre
	 * @return le genre de l'arbre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * Méthode d'accès à l'espèce d'un arbre
	 * @return l'espèce de l'abre
	 */
	public String getEspece() {
		return espece;
	}

	/**
	 * Méthode d'accès au stade de dévoleppement de l'arbre
	 * @return le stade de dévoleppement de l'arbre
	 */
	public String getDev() {
		return dev;
	}

	/**
	 * Méthode d'accès à l'adresse de l'abre
	 * @return l'adresse de l'arbre
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * Méthode d'accès à la circonference de l'arbre 
	 * @return la circonférence de l'arbre
	 */
	public int getCirconference() {
		return circonference;
	}

	/**
	 * Méthode d'accès à la hauteur de l'arbre
	 * @return la hauteur de l'arbre
	 */
	public int getHauteur() {
		return hauteur;
	}

	/**
	 * Méthode d'accès au coordonnées GPS de l'arbre
	 * @return les coordonnées GPS de l'arbre
	 */
	public Float[] getGPS() {
		return GPS;
	}
	
	/**
	 * Méthode d'accès au caractère remarquable de l'arbre
	 * @return le caractère remarquable de l'arbre
	 */
	public boolean getRemarquable() {
		return remarquable;
	}

	/**
	 * Méthode d'accès à la date de dernière visite de l'arbre
	 * @return la date de dernière visite de l'arbre
	 */
	public Date getDateDerniereVisite() {
		return this.dateDerniereVisite;
	}
	
	/**
	 * Méthode d'accès à la date de classfication de l'arbre
	 * @return la date de classification de l'arbre
	 */
	public Date getDateClassification() {
		return dateClassification;
	}
	
	/**
	 * Méthode permettant de classifier un arbre comme remarquable
	 * @param dateClassification la date à laquelle l'arbre est classifié comme remarquable 
	 */
	void classifier(Date dateClassification) {
		this.dateClassification = dateClassification;
		remarquable=true;
	}
	
	/**
	 * Methode d'accès à l'adresse d'un arbre
	 * @param adresse l'adresse de l'arbre
	 */
	void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	/**
	 * Méthode d'accès aux coordonnées GPS de l'arbre
	 * @param GPS tableau contenant les coordonnées GPS de l'arbre
	 */
	void setGPS(Float[] GPS) {
		this.GPS = GPS;
	}
	
	/**
	 * Méthode d'accès à la liste des comptes rendus de l'arbre
	 * @return la liste des comptes rendus de l'abre
	 */
	public ArrayList<CompteRendu> getListeComptesRendus() {
		return listeComptesRendus;
	}
	
	/**
	 * méthode d'accès au nombres de nominations d'un arbre
	 * @return nbNominations le nombre de nominations d'un arbre
	 */
	public int getNbNominations() {
		return nbNominations;
	}
	
	/**
	 * méthode pour nominer un arbre
	 */
	public void nominer() {
		nbNominations = nbNominations+1;
	}
	
	/**
	 * Méthode pour "dé-nominer" un arbre
	 */
	public void denominer() {
		nbNominations = nbNominations-1;
	}
	
	/**
	 * Méthode pour réinitialiser ne nombre de nominations d'un arbre
	 */
	public void resetNominations() {
		nbNominations = 0;
	}
	
	/**
	 * Méthode permettant de visiter un arbre et de modifier sa listeCompteRendus ainsi que sa date de dernière visite
	 * @param le CompteRendu à ajouter
	 */
	public void ajouterCompteRendu(CompteRendu compteRendu) {
		dateDerniereVisite = compteRendu.getDate();
		getListeComptesRendus().add(compteRendu);
	}

	@Override
	public String toString() {
		return "\n" + "\tgenre : " + getGenre() + "\n" +
			   "\tespece : " + getEspece() + "\n" +
			   "\tdev : " + getDev() + "\n" +
			   "\tadresse : " + getAdresse() + "\n" +
			   "\tcirconference : " + getCirconference() + "\n" +
			   "\thauteur : " + getHauteur() + "\n" +
			   "\tcoordonnées GPS : " + "(" + GPS[0] + "," + GPS[1] + ")" + "\n" +
			   "\tcaractère remarquable : " + getRemarquable() + "\n" +
			   "\tdate de dernière visite : " + dateDerniereVisite + "\n" +
			   "\tdate de classification : " + dateClassification + "\n" +
			   "\tcomptes rendus sur l'arbres : " + listeComptesRendus + "\n" +
			   "\tnombre de nominations : " + getNbNominations() +"\n";
	}
}
