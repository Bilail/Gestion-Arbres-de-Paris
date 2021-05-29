package Municipalite;
import java.awt.Point;

import java.util.Date;

import Asso.CompteRendu;

import java.util.ArrayList;

public class Arbre {
	
	private String genre, espece, nom, dev, adresse;
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
	public Arbre(String genre, String espece, String nom) {
		this.genre=genre;
		this.espece=espece;
		this.nom=nom;
	}
	
	/**
	 * Constructeur complet 
	 * @param genre
	 * @param espece
	 * @param nom
	 * @param GPS
	 * @param circonference
	 * @param hauteur
	 * @param remarquable
	 * @param dev
	 */
	public Arbre(String genre, String espece, Float[] GPS, int circonference, int hauteur , boolean remarquable, String dev ) {
		this.genre=genre;
		this.espece=espece;
		//this.nom=nom;
		this.GPS = GPS;
		this.circonference = circonference;
		this.hauteur = hauteur;
		this.remarquable = remarquable;
		this.dev = dev;
	}
	
	/**
	 * M�thode d'acc�s au genre de l'arbre
	 * @return le genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * M�thode d'acc�s � l'esp�ce d'un arbre
	 * @return l'esp�ce
	 */
	public String getEspece() {
		return espece;
	}

	/**
	 * M�thode d'acc�s au nom de l'arbre
	 * @return le nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * M�thode d'acc�s au stade de d�voleppement de l'arbre
	 * @return le stade de d�voleppement
	 */
	public String getDev() {
		return dev;
	}

	/**
	 * M�thode d'acc�s � l'adresse de l'abre
	 * @return
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * M�thode d'acc�s � la circonference de l'arbre 
	 * @return la circonf�rence
	 */
	public int getCirconference() {
		return circonference;
	}

	/**
	 * M�thode d'acc�s � la hauteur de l'arbre
	 * @return la hauteur
	 */
	public int getHauteur() {
		return hauteur;
	}

	/**
	 * M�thode d'acc�s au coordonn�es GPS de l'arbre
	 * @return le Point des coordonn�es GPS
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
	 * @return la date de derni�re visite
	 */
	public Date getDateDerniereVisite() {
		return this.dateDerniereVisite;
	}
	
	/**
	 * M�thode d'acc�s � la date de classfication de l'arbre
	 * @return la date de classification
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
	 */
	public void ajouterCompteRendu(CompteRendu compteRendu) {
		dateDerniereVisite = compteRendu.getDate();
		getListeComptesRendus().add(compteRendu);
	}

	/**
	 * Red�finition de la m�thode toString() dans le cadre d'un Arbre
	 */
	@Override
	public String toString() {
		return "\n" + "\tgenre : " + getGenre() + "\n" +
			   "\tespece : " + getEspece() + "\n" +
			   "\tnom : " + getNom() + "\n" +
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
