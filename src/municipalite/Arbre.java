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
	 * Constructeur sans param�tre qui cr�e un arbre "vide"
	 */
	public Arbre() {
		
	}

	/**
	 * Constructeur qui cr�e un arbre non plant� avec le minimum d'informations
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
	 * @param espece l'esp�ce de l'arbre
	 * @param nom le nom de l'arbre
	 * @param GPS les coordonn�es GPS de l'arbre dans un tableau
	 * @param circonference la circonf�rence de l'arbre
	 * @param hauteur la hauteur de l'arbre
	 * @param remarquable le caract�re remarquable de l'arbre
	 * @param dev le stade de d�veloppement de l'arbre
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
	 * M�thode d'acc�s au genre de l'arbre
	 * @return le genre de l'arbre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * M�thode d'acc�s � l'esp�ce d'un arbre
	 * @return l'esp�ce de l'abre
	 */
	public String getEspece() {
		return espece;
	}

	/**
	 * M�thode d'acc�s au stade de d�voleppement de l'arbre
	 * @return le stade de d�voleppement de l'arbre
	 */
	public String getDev() {
		return dev;
	}

	/**
	 * M�thode d'acc�s � l'adresse de l'abre
	 * @return l'adresse de l'arbre
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * M�thode d'acc�s � la circonference de l'arbre 
	 * @return la circonf�rence de l'arbre
	 */
	public int getCirconference() {
		return circonference;
	}

	/**
	 * M�thode d'acc�s � la hauteur de l'arbre
	 * @return la hauteur de l'arbre
	 */
	public int getHauteur() {
		return hauteur;
	}

	/**
	 * M�thode d'acc�s au coordonn�es GPS de l'arbre
	 * @return les coordonn�es GPS de l'arbre
	 */
	public Float[] getGPS() {
		return GPS;
	}
	
	/**
	 * M�thode d'acc�s au caract�re remarquable de l'arbre
	 * @return le caract�re remarquable de l'arbre
	 */
	public boolean getRemarquable() {
		return remarquable;
	}

	/**
	 * M�thode d'acc�s � la date de derni�re visite de l'arbre
	 * @return la date de derni�re visite de l'arbre
	 */
	public Date getDateDerniereVisite() {
		return this.dateDerniereVisite;
	}
	
	/**
	 * M�thode d'acc�s � la date de classfication de l'arbre
	 * @return la date de classification de l'arbre
	 */
	public Date getDateClassification() {
		return dateClassification;
	}
	
	/**
	 * M�thode permettant de classifier un arbre comme remarquable
	 * @param dateClassification la date � laquelle l'arbre est classifi� comme remarquable 
	 */
	void classifier(Date dateClassification) {
		this.dateClassification = dateClassification;
		remarquable=true;
	}
	
	/**
	 * Methode d'acc�s � l'adresse d'un arbre
	 * @param adresse l'adresse de l'arbre
	 */
	void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	/**
	 * M�thode d'acc�s aux coordonn�es GPS de l'arbre
	 * @param GPS tableau contenant les coordonn�es GPS de l'arbre
	 */
	void setGPS(Float[] GPS) {
		this.GPS = GPS;
	}
	
	/**
	 * M�thode d'acc�s � la liste des comptes rendus de l'arbre
	 * @return la liste des comptes rendus de l'abre
	 */
	public ArrayList<CompteRendu> getListeComptesRendus() {
		return listeComptesRendus;
	}
	
	/**
	 * m�thode d'acc�s au nombres de nominations d'un arbre
	 * @return nbNominations le nombre de nominations d'un arbre
	 */
	public int getNbNominations() {
		return nbNominations;
	}
	
	/**
	 * m�thode pour nominer un arbre
	 */
	public void nominer() {
		nbNominations = nbNominations+1;
	}
	
	/**
	 * M�thode pour "d�-nominer" un arbre
	 */
	public void denominer() {
		nbNominations = nbNominations-1;
	}
	
	/**
	 * M�thode pour r�initialiser ne nombre de nominations d'un arbre
	 */
	public void resetNominations() {
		nbNominations = 0;
	}
	
	/**
	 * M�thode permettant de visiter un arbre et de modifier sa listeCompteRendus ainsi que sa date de derni�re visite
	 * @param le CompteRendu � ajouter
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
			   "\tcoordonn�es GPS : " + "(" + GPS[0] + "," + GPS[1] + ")" + "\n" +
			   "\tcaract�re remarquable : " + getRemarquable() + "\n" +
			   "\tdate de derni�re visite : " + dateDerniereVisite + "\n" +
			   "\tdate de classification : " + dateClassification + "\n" +
			   "\tcomptes rendus sur l'arbres : " + listeComptesRendus + "\n" +
			   "\tnombre de nominations : " + getNbNominations() +"\n";
	}
}
