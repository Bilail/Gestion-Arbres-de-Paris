package Mairie;
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
	
	public String getGenre() {
		return genre;
	}

	private void setGenre(String genre) {
		this.genre = genre;
	}

	public String getEspece() {
		return espece;
	}

	private void setEspece(String espece) {
		this.espece = espece;
	}

	public String getNom() {
		return nom;
	}

	private void setNom(String nom) {
		this.nom = nom;
	}

	public String getDev() {
		return dev;
	}

	private void setDev(String dev) {
		this.dev = dev;
	}

	public String getAdresse() {
		return adresse;
	}

	void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getCirconference() {
		return circonference;
	}

	private void setCirconference(int circonference) {
		this.circonference = circonference;
	}

	public int getHauteur() {
		return hauteur;
	}

	private void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	public Float[] getGPS() {
		return GPS;
	}

	void setGPS(Float[] GPS) {
		this.GPS = GPS;
	}

	public boolean getRemarquable() {
		return remarquable;
	}

	void setRemarquable(boolean remarquable) {
		this.remarquable = remarquable;
	}

	public Date getDateDerniereVisite() {
		return this.dateDerniereVisite;
	}

	public Date getDateClassification() {
		return dateClassification;
	}

	void classifier(Date dateClassification) {
		this.dateClassification = dateClassification;
	}
	
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
			   "\tdate de derni�re vidite : " + dateDerniereVisite + "\n" +
			   "\tdate de classification : " + dateClassification + "\n" +
			   "\tcomptes rendus sur l'arbres : " + listeComptesRendus + "\n" +
			   "\tnombre de nominations : " + getNbNominations() +"\n";
	}
	
	
	
	public static void main(String[] args) {
	
		Arbre arbre = new Arbre("truc","bidule","chouette");
		Float[] coordonne =  new Float[2];
		coordonne[0] = (float) 1.1;
		coordonne[1] = (float) 2.2;
		arbre.setGPS(coordonne);
		System.out.println(arbre);

	}
	
}
