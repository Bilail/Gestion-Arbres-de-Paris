package entite;
import Asso.Association;
import Asso.DemandeSubvention;
import Asso.Notifiable;
import Asso.Notification;
import Asso.Transaction;

public class Personne implements Notifiable,Donateur {
	
	private String nom;
	private String prenom;
	private String DateNaissance; 
	private String adresse;
	private CompteBancaire compte;
	
	/**
	 * Constructeur de Personne prenant en compte les propri�t�s d'une Personne
	 * @param nom le nom de la Personne 
	 * @param prenom le Prenom de la personne 
	 * @param adresse l'adresse de la Personne 
	 * @param DateNaissance la date de naissance de la Personne 
	 * @param montant le montant sur le CompteBancaire de la Personne
	 */
	public Personne(String nom, String prenom, String adresse, String DateNaissance,float montant){
		this.nom=nom;
		this.prenom=prenom;
		this.adresse=adresse;
		this.DateNaissance= DateNaissance;
		compte=new CompteBancaire("prenom"+"nom",montant);
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
	 * M�thode d'acc�s au compteBancaire de la Personne
	 * @return le compteBancaire de la personne
	 */
	public CompteBancaire getCompte() {
		return compte;
	}
	
	@Override
	public void recevoirNotification(Notification notification){
		System.out.println(notification);
	}
	
	@Override
	public void Donation(Association association, float montant) {
		
		Transaction transaction = new Transaction(montant, "don d'un particulier");
		association.effectuerTransaction(transaction);
		compte.calculSolde(-(montant));
		association.ajouterDonateur(this);
	}
	
	@Override
	public void recevoirDemande(DemandeSubvention demande) {
		System.out.println(demande);
	}
	
	@Override
	public String toString() {
		return "\n Nom : " + getNom() + " pr�nom : " + getPrenom();
	}
}
