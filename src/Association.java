
import java.util.ArrayList;

public class Association implements Notifiable {
	
	private ArrayList<Membre> listeMembres;
	private Budget budget;
	private ArrayList<Donateur> listeDonateurs;
	private Municipalite mairie;
	
	/**
	 * Constructeur par défaut de l'association
	 */
	public Association() {
		listeMembres= new ArrayList<Membre>();
		listeDonateurs=new ArrayList<Donateur>();
		budget = new Budget(); 
	}
	
	/**
	 * Méthode permettant de révoquer un membre de l'association
	 * @param membre
	 */
	void Revoquer(Membre membre) {
		listeMembres.remove(membre);
		membre=null;	
	}
	
	/**
	 * Methode permettant l'inscription d'une personne dans l'association
	 * @param personne la personne à inscrire
	 */
	void inscrire(Personne personne) {
		Membre membre = new Membre (personne,this);
		listeMembres.add(membre);
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
	
	public ArrayList<Arbre> nominer(Municipalite mairie) {
		
		ArrayList<Arbre> nominations= new ArrayList<Arbre>();
		
		for(Membre membre : listeMembres) {
			for(int i=0 ; i<membre.getNominations().size(); i++) {
			membre.getNominations().get(i).nominer();
			}
		}
		
		for(int j=0; j<5; j++) {
			
			
			for(Arbre arbre : mairie.getListArbre()) {
				if(nominations.get(j)==null) {
					nominations.add(j,arbre);
				}
				else if(arbre.getNbNominations()>nominations.get(j).getNbNominations()){
					nominations.add(j,arbre);
				}
				else if(arbre.getNbNominations()==nominations.get(j).getNbNominations()){
					
					 if(arbre.getCirconference()>nominations.get(j).getNbNominations()) {
						 nominations.add(j,arbre);
					 }
					 else if(arbre.getCirconference()==nominations.get(j).getNbNominations()) {
						 
						  if(arbre.getHauteur()>nominations.get(j).getHauteur()) {
							 nominations.add(j,arbre);
						  }
					 }
				}
			}
			nominations.get(j).resetNominations();
		}
		return nominations;
	}
	
	private void finExerciceBudgetaire() {
		budget.changementAnnee();
		nominer(mairie);
		
	}
	
	public static void main(String[] args) {
		
		Association A = new Association();
		
		Personne p= new Personne("Jean", "Dupont","8 rue Balzac","03/06/1985");
		
		A.inscrire(p);
		
		System.out.println(A.listeMembres.get(0).getDateInscription());
	}
	

}
