package Asso;



import java.util.ArrayList;

import Municipalite.Arbre;
import Municipalite.Mairie;
import entite.Donateur;
import entite.Membre;
import entite.Personne;

public class Association implements Notifiable {
	
	private ArrayList<Membre> listeMembres;
	private ArrayList<Donateur> listeDonateurs;
	private ArrayList<Visite> visitesPlannifiees;
	private Budget budget;
	private Mairie mairie;
	
	/**
	 * Constructeur par défaut de l'association
	 */
	public Association(Mairie mairie) {
		listeMembres= new ArrayList<Membre>();
		listeDonateurs=new ArrayList<Donateur>();
		visitesPlannifiees=new ArrayList<Visite>();
		budget = new Budget(); 
		this.mairie=mairie;
	}
	
	/**
	 * Permet d'obtenir la liste des membres de l'association
	 * @return liste membres
	 */
	public ArrayList<Membre> getListeMembres(){
		return listeMembres;
	}
	
	/**
	 * Permet d'obtenir le budget de l'association
	 * @return budget
	 */
	public Budget getBudget() {
		return budget;
	}
	
	/**
	 * Méthode d'accès à la mairie à laquelle est associée l'Association
	 * @return la mairie
	 */
	public Mairie getMairie() {
		return mairie;
	}
	
	/**
	 * Méthode d'accès aux visites plannifiées par l'association
	 * @return la liste des visites plannifiées
	 */
	public ArrayList<Visite> getVisitesPlannifiees(){
		return visitesPlannifiees;
	}
	
	/**
	 * Méthode permettant à l'association d'énumérer la liste des arbres remarquables
	 * @return la liste des arbres remarquables
	 */
	public ArrayList<Arbre> getArbresRemarquables(){
		
		ArrayList<Arbre> ListeArbresRemarquables = new ArrayList<Arbre>();
		
		for(Arbre arbre : getMairie().getListArbre()) {
			
			if(arbre.getRemarquable()) {
				ListeArbresRemarquables.add(arbre);
			}
		}
		return ListeArbresRemarquables;
	}
	
	/**
	 * Permet d'obtenir la liste des donateurs de l'association
	 * @return liste donateurs
	 */
	public ArrayList<Donateur> getListeDonateurs() {
		return listeDonateurs;
	}

	/**
	 * Méthode permettant de révoquer un membre de l'association si celui-ci n'a pas reglé sa cotisation
	 * @param membre
	 */
	public void revoquer(Membre membre) {
		listeMembres.remove(membre);
		membre=null;	
	}
	
	/**
	 * Methode permettant l'inscription d'une personne dans l'association
	 * @param personne la personne à inscrire
	 */
	public Membre inscrire(Personne personne) {
		Membre membre = new Membre (personne,this);
		listeMembres.add(membre);
		return membre;
	}
	
	/**
	 * Methode d'accès à la listeDonateurs de l'association
	 * @return la listeDonateur de l'association
	 */
	public ArrayList<Donateur> getDonateurs(){
		return listeDonateurs;
	}
	
	/**
	 * Méthode permettant l'ajout d'un nouveau Donateur à la listeDonateurs de l'association
	 * @param donateur un nouveau Donateur
	 */
	public void ajouterDonateur(Object objet) {
		if(objet instanceof Donateur){
			listeDonateurs.add((Donateur) objet);
		}
	}
	
	/**
	 * Methode permettant de mettre a jour le budget de l'association suite à une transaction,
	 * si la transaction correspond à une facture, on vérifie d'abord que la somme à payer est disponible
	 * @param transaction la transaction effectuée
	 */
	public void effectuerTransaction(Transaction transaction) {
		
		if(transaction instanceof Facture) {
			if(getBudget().getSomme()>=-transaction.getMontant()) {
				budget.CalculBudget(transaction);
			}
		}
		else {
		budget.CalculBudget(transaction);
		}
	}
	
	/**
	 * méthode notifiant l'association d'une action ayant eue lieu sur un arbre
	 */
	@Override
	public void notifier(Notification notification) {
		System.out.println(notification + "\n");
		}
	
	/**
	 * Méthode permettant de transmettre à la mairie la liste des arbres qu'elle nomine pour être classifiés
	 * comme remarquables. Liste contenant les 5 arbres les plus nominés par les membres de l'association.
	 * En cas d'égalité, on procède par circonférence et hauteur croissante. On réinitialise également les nominations
	 * de chaque membre ainsi que le compteur de nominations pour chaque arbre.
	 * @param mairie la Municipalite qui tient la liste d'arbres
	 * @return les arbres nominés par l'association
	 */
	public Arbre[] nominer() {
		
		/*ArrayList<Arbre> nominations= new ArrayList<Arbre>();
		
		for(int i=0; i<5; i++) {
			nominations.add(null);
		}*/
		
		Arbre[] nominations=new Arbre[5];
		
		for(Membre membre : listeMembres) {
			for(int i=0 ; i<membre.getNominations().size(); i++) {
			membre.getNominations().remove(i);
			}
		}
		
		for(int j=0; j<nominations.length; j++) {
			
			
			for(Arbre arbre : getMairie().getListArbre()) {
				if(nominations[j]==null) {
					nominations[j]=arbre;
				}
				else if(arbre.getNbNominations()>nominations[j].getNbNominations()){
					nominations[j]=arbre;
				}
				else if(arbre.getNbNominations()==nominations[j].getNbNominations()){
					
					 if(arbre.getCirconference()>nominations[j].getCirconference()) {
						 nominations[j]=arbre;
					 }
					 else if(arbre.getCirconference()==nominations[j].getCirconference()) {
						 
						  if(arbre.getHauteur()>nominations[j].getHauteur()) {
							  nominations[j]=arbre;
						  }
					 }
				}
			}
			nominations[j].resetNominations();
		}
		
		for(Arbre arbre : mairie.getListArbre()) {
			arbre.resetNominations();
		}
		return nominations;
	}
	
	public Arbre[] finExerciceBudgetaire() {
		
		ArrayList<Membre> aRevoquer = new ArrayList<Membre>();
		
		for(Membre membre : getListeMembres()) {
			if(membre.getCotisationsAnnuelles().get(membre.getCotisationsAnnuelles().size()-1)==0) {
				aRevoquer.add(membre);
			}
			else {
				membre.getCotisationsAnnuelles().add((float) 0);
			}
		}
		
		for(Membre membre : aRevoquer) {
			revoquer(membre);
		}
		
		budget.nouvelleAnnee();
		return nominer();
		
	}
	
	private void demanderSubvention() {
		for(Donateur donateur : listeDonateurs) {
			
		}
	}
	
	public static void main(String[] args) {
		
		
	}
	

}
