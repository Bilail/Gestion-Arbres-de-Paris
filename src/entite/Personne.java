package entite;
import Asso.Association;
import Asso.Notifiable;
import Asso.Notification;
import Asso.Transaction;

public class Personne implements Notifiable,Donateur {
	
	private String nom;
	private String prenom;
	private String DateNaissance; // je propose le type date directement 
	private String adresse;
	private CompteBancaire compte;
	
	/**
	 * Constructeur de Personne prenant en compte les propriétés d'une Personne
	 * @param nom le nom de la Personne 
	 * @param prenom le Prenom de la personne 
	 * @param adresse l'adresse de la Personne 
	 * @param DateNaissance la date de naissance de la Personne 
	 */
	public Personne(String nom, String prenom, String adresse, String DateNaissance){
		this.nom=nom;
		this.prenom=prenom;
		this.adresse=adresse;
		this.DateNaissance= DateNaissance;
	}
	
	/**
	 * Methode d'accès au nom de la personne
	 * @return le nom de la personne
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Methode d'accès au prenom de la personne
	 * @return le prenom de la personne
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 * Methode d'accès à la date de naissance de la personne
	 * @return la date de naissance de la personne
	 */
	public String getDateNaissance() {
		return DateNaissance;
	}
	
	/**
	 * Methode d'accès à l'adresse  de la personne
	 * @return l'adresse de la personne
	 */
	public String getAdresse() {
		return adresse;
	}
	
	/**
	 * méthode notifiant une personne d'une action ayant eue lieu sur un arbre
	 */
	public void notifier(Notification notification){
		notification.toString();
	}
	
	
	/**
	 * Méthode permettant d'effectuer un don de particulier à association
	 */
	@Override
	public void Donation(Association association, float montant) {
		
		Transaction transaction = new Transaction(montant, "don d'un particulier");
		association.effectuerTransaction(transaction);
	}
}
