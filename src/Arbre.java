import java.awt.Point;
import java.util.Date;
import java.util.ArrayList;

public class Arbre {
	
	private String genre, espece, nom, dev, adresse;
	private int circonference,hauteur;
	private Point GPS = new Point();
	private boolean remarquable;
	private Date dateDerniereVisite, dateClassification; 
	private ArrayList<CompteRendu> listeCR = new ArrayList<CompteRendu>(); //je propose d'appeler la variable plutot Liste_CR comme c plusieurs CR
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
	public Arbre(String genre, String espece, String nom, Point GPS, int circonference, int hauteur , boolean remarquable, String dev ) {
		this.genre=genre;
		this.espece=espece;
		this.nom=nom;
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

	public Date getDateDerniereVisite() {
		return this.dateDerniereVisite;
	}

	private void setDateDerniereVisite(Date dateDerniereVisite) {
		this.dateDerniereVisite = dateDerniereVisite;
	}
	

	public Date getDateClassification() {
		return dateClassification;
	}

	void classifier(Date dateClassification) {
		this.dateClassification = dateClassification;
	}
	
	public ArrayList<CompteRendu> getListeComptesRendus() {
		return listeCR;
	}
	
	public int getNbNominations() {
		return nbNominations;
	}
	
	void nominer() {
		nbNominations = nbNominations+1;
	}
	
	void resetNominations() {
		nbNominations = 0;
	}

	private void setListeComptesRendus(ArrayList<CompteRendu> comptesRendus) {

		listeCR = comptesRendus;
	}

	/**
	 * Redéfinition de la méthode toString() dans le cadre d'un Arbre
	 */
	@Override
	public String toString() {
		return "genre : " + getGenre() + "\n" +
			   "espece : " + getEspece() + "\n" +
			   "nom : " + getNom() + "\n" +
			   "dev : " + getDev() + "\n" +
			   "adresse : " + getAdresse() + "\n" +
			   "circonference : " + getCirconference() + "\n" +
			   "hauteur : " + getHauteur() + "\n" +
			   "coordonnées GPS : " + "(" + GPS.getX() + "," + GPS.getY() + ")" + "\n" +
			   "caractère remarquable : " + getRemarquable() + "\n" +
			   "date de dernière vidite : " + dateDerniereVisite + "\n" +
			   "date de classification : " + dateClassification + "\n" +
			   "comptes rendus sur l'abres : " + listeCR.toString() + "\n" +
			   "nombre de nominations : " + getNbNominations();
	}
	
	
	
	public static void main(String[] args) {
	
		Arbre arbre = new Arbre("truc","bidule","chouette");
		arbre.setGPS(new Point(4,3));
		System.out.println(arbre);

	}
	
}
