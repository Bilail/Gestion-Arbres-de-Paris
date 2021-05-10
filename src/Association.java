
import java.util.ArrayList;

public class Association implements Notifiable {
	
	private ArrayList<Membre> membres; //  je propose plutot liste_membre sinon on va se mélanger les pinceaux
	private Budget budget;
	private ArrayList<Donateur> donateurs;
	
	/**
	 * Constructeur par défaut de l'association
	 */
	public Association() {
		membres= new ArrayList<Membre>();
		donateurs=new ArrayList<Donateur>();
		budget=new Budget(); //a rectifier
	}
	
	/**
	 * Méthode permettant de révoquer un membre de l'association
	 * @param membre
	 */
	void Revoquer(Membre membre) {
		membres.remove(membre);
		membre=null;	
	}
	
	/**
	 * Methode permettant l'inscription d'une personne dans l'association
	 * @param personne la personne à inscrire
	 */
	void inscrire(Personne personne) {
		Membre membre = new Membre (personne,this);
		membres.add(membre);
	}
	
	/**
	 * Methode permettant de mettre a jour le budget de l'association suite à une transaction
	 * @param transaction la transaction effectuée
	 */
	void EffectuerTransaction(Transaction transaction) {
		budget.CalculBudget(transaction);
	}
	
	/**
	 * méthode notifiant l'association d'une action ayant eue lieu sur un arbre
	 */
	public void notifier(Notification notification) {
		notification.toString();
	}
	
	public static void main(String[] args) {
		
		Association A = new Association();
		
		Personne p= new Personne("Jean", "Dupont","8 rue Balzac","03/06/1985");
		
		A.inscrire(p);
		
		System.out.println(A.membres.get(0).getDateInscription());
	}
	

}
