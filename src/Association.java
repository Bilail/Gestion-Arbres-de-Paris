import java.util.ArrayList;

public class Association implements Notifiable {
	
	private ArrayList<Membre> membres; //  je propose plutot liste_membre sinon on va se m�langer les pinceaux
	private Budget budget;
	private ArrayList<Donateur> donateurs;
	
	/**
	 * M�thode permettant de r�voquer un membre de l'association
	 * @param membre
	 */
	void Revoquer(Membre membre) {
		membres.remove(membre);
	}
	
	/**
	 * Methode permettant l'inscription d'une personne dans l'association
	 * @param personne la personne � inscrire
	 */
	void inscrire(Personne personne) {
		personne = new Membre(personne.getNom(), personne.getPrenom());
	}
	
	/**
	 * m�thode notifiant l'association d'une action ayant eue lieu sur un arbre
	 */
	public void notifier(Notification notification) {
		notification.toString();
	}

	

}
