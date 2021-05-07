import java.awt.Point;
import java.util.ArrayList;

public class Arbre {
	
	private String genre, espece, nom, dev, adresse;
	private int circonference,hauteur;
	private Point GPS = new Point();
	private boolean remarquable;
	private String DateDerniereVisite, DateClassification;
	private ArrayList<CompteRendu> ComptesRendus = new ArrayList<CompteRendu>();
	
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
	public Arbre(String genre, String espece, String nom) {
		this.genre=genre;
		this.espece=espece;
		this.nom=nom;
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

	public Point getGPS() {
		return GPS;
	}

	void setGPS(Point GPS) {
		this.GPS = GPS;
	}

	public boolean getRemarquable() {
		return remarquable;
	}

	void setRemarquable(boolean remarquable) {
		this.remarquable = remarquable;
	}

	public String getDateDerniereVisite() {
		return this.DateDerniereVisite;
	}

	private void setDateDerniereVisite(String dateDerniereVisite) {
		DateDerniereVisite = dateDerniereVisite;
	}
	

	public String getDateClassification() {
		return DateClassification;
	}

	void setDateClassification(String dateClassification) {
		DateClassification = dateClassification;
	}
	
	public ArrayList<CompteRendu> getListeComptesRendus() {
		return ComptesRendus;
	}

	private void setListeComptesRendus(ArrayList<CompteRendu> comptesRendus) {

		ComptesRendus = comptesRendus;
	}

	/**
	 * Redéfinition de la méthode toString() dans le cadre d'un Arbre
	 */
	@Override
	public String toString() {
		return "genre : " + genre + "\n" +
			   "espece : " + espece + "\n" +
			   "nom : " + nom + "\n" +
			   "dev : " + dev + "\n" +
			   "adresse : " + adresse + "\n" +
			   "circonference : " + circonference + "\n" +
			   "hauteur : " + hauteur + "\n" +
			   "coordonnées GPS : " + "(" + GPS.getX() + "," + GPS.getY() + ")" + "\n" +
			   "caractère remarquable : " + remarquable + "\n" +
			   "date de dernière vidite : " + DateDerniereVisite + "\n" +
			   "date de classification : " + DateClassification + "\n" +
			   "comptes rendus sur l'abres : " + ComptesRendus.toString() + "\n" ;
	}
	
	
	
	public static void main(String[] args) {
	
		Arbre arbre = new Arbre("truc","bidule","chouette");
		arbre.setGPS(new Point(4,3));
		System.out.println(arbre);

	}
	
}
