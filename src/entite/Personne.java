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
	
	/**
	 * Constructeur de Personne prenant en compte les propri�t�s d'une Personne
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
	 * Methode d'acc�s au nom de la personne
	 * @return le nom de la personne
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Methode d'acc�s au prenom de la personne
	 * @return le prenom de la personne
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 * Methode d'acc�s � la date de naissance de la personne
	 * @return la date de naissance de la personne
	 */
	public String getDateNaissance() {
		return DateNaissance;
	}
	
	/**
	 * Methode d'acc�s � l'adresse  de la personne
	 * @return l'adresse de la personne
	 */
	public String getAdresse() {
		return adresse;
	}
	
	/**
	 * m�thode notifiant une personne d'une action ayant eue lieu sur un arbre
	 */
	public void notifier(Notification notification){
		notification.toString();
	}
	
	
	/**
	 * M�thode permettant � une personne d'effectuer un don � une association
	 */
	public void Donation(Association association, float montant) {
		
		Transaction transaction = new Transaction(montant, "don d'un particulier");
		association.effectuerTransaction(transaction);
	}
}
