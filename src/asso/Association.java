package asso;



import java.util.ArrayList;

import entite.Donateur;
import entite.Membre;
import entite.Personne;
import municipalite.Arbre;
import municipalite.Mairie;

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
	 * @return le membre inscrit
	 */
	public Membre inscrire(Personne personne) {
		Membre membre = new Membre (personne,this);
		listeMembres.add(membre);
		return membre;
	}
	
	/**
	 * Méthode permettant l'ajout d'un nouveau Donateur à la listeDonateurs de l'association
	 * @param donateur un nouveau Donateur
	 */
	public void ajouterDonateur(Donateur donateur) {
		if(!getListeDonateurs().contains(donateur)){
			listeDonateurs.add(donateur);
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

	@Override
	public void recevoirNotification(Notification notification) {
		System.out.println(notification + "\n");
	}
	
	/**
	 * Méthode permettant de transmettre à la mairie la liste des arbres qu'elle nomine pour être classifiés
	 * comme remarquables. Liste contenant les 5 arbres les plus nominés par les membres de l'association.
	 * En cas d'égalité, on procède par circonférence et hauteur croissante. On réinitialise également les nominations
	 * de chaque membre ainsi que le compteur de nominations pour chaque arbre.
	 */
	public Arbre[] nominer() {
		
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
	
	/**
	 * Méthode permettant de mettre fin à l'exercice budgetaire en cours 
	 * et effectuer les actions telles que la révovation des membres n'ayant pas régle leurs cotisation annuelle
	 * ou transmettre la liste d'abres nominés et changer d'année d'un point de vue de budget
	 * @return la liste d'arbres nominés
	 */
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
	
	/**
	 * Méthode permettant de demander une subvention
	 */
	public void demanderSubvention(Donateur donateur, String description) {
		donateur.recevoirDemande(new DemandeSubvention(description,getBudget()));
	}
}
