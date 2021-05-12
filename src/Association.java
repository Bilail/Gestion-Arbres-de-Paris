
import java.util.ArrayList;

public class Association implements Notifiable {
	
	private ArrayList<Membre> ListeMembres;
	private Budget budget;
	private ArrayList<Donateur> ListeDonateurs;
	
	/**
	 * Constructeur par d�faut de l'association
	 */
	public Association() {
		ListeMembres= new ArrayList<Membre>();
		ListeDonateurs=new ArrayList<Donateur>();
		budget = new Budget(); 
	}
	
	/**
	 * M�thode permettant de r�voquer un membre de l'association
	 * @param membre
	 */
	void Revoquer(Membre membre) {
		ListeMembres.remove(membre);
		membre=null;	
	}
	
	/**
	 * Methode permettant l'inscription d'une personne dans l'association
	 * @param personne la personne � inscrire
	 */
	void inscrire(Personne personne) {
		Membre membre = new Membre (personne,this);
		ListeMembres.add(membre);
	}
	
	/**
	 * Methode permettant de mettre a jour le budget de l'association suite � une transaction
	 * @param transaction la transaction effectu�e
	 */
	void EffectuerTransaction(Transaction transaction) {
		budget.CalculBudget(transaction);
	}
	
	/**
	 * m�thode notifiant l'association d'une action ayant eue lieu sur un arbre
	 */
	public void notifier(Notification notification) {
		notification.toString();
	}
	
	public static void main(String[] args) {
		
		Association A = new Association();
		
		Personne p= new Personne("Jean", "Dupont","8 rue Balzac","03/06/1985");
		
		A.inscrire(p);
		
		System.out.println(A.ListeMembres.get(0).getDateInscription());
	}
	

}
