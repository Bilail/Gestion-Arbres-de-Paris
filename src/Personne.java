
public class Personne implements Notifiable,Donateur {
	
	private String nom;
	private String prenom;
	private String DateNaissance; // je propose le type date directement 
	private String Adresse;
	
	Personne(String nom, String prenom){
		this.nom=nom;
		this.prenom=prenom;
	}
	
	private void SetDateNaissance(String DateNaissance) {
		this.DateNaissance=DateNaissance;
	}
	
	private void SetAdresse(String Adresse) {
		this.Adresse=Adresse;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public String getDateNaissance() {
		return DateNaissance;
	}
	
	public String getAdresse() {
		return Adresse;
	}
	
	/**
	 * méthode notifiant une personne d'une action ayant eue lieu sur un arbre
	 */
	public void notifier(Notification notification){
		notification.toString();
	}

	public void Donation(Association association, Float somme) {
		
	}
}
