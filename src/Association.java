import java.util.ArrayList;

public class Association implements Notifiable {
	
	private ArrayList<Membre> membres;
	private Budget budget;
	private ArrayList<Donateur> donateurs;
	
	/**
	 * Méthode permettant de révoquer un membre de l'association
	 * @param membre
	 */
	void Revoquer(Membre membre) {
		membres.remove(membre);
	}
	
	/**
	 * Methode permettant l'inscription d'une personne dans l'association
	 * @param personne la personne à inscrire
	 */
	void inscrire(Personne personne) {
		personne = new Membre(personne.getNom(), personne.getPrenom());
	}
	
	/**
	 * méthode notifiant l'association d'une action ayant eue lieu sur un arbre
	 */
	public void notifier(Notification notification) {
		notification.toString();
	}

	

}
