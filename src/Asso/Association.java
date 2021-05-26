package Asso;

import java.util.ArrayList;

import Mairie.Arbre;
import Mairie.Municipalite;
import entite.Donateur;
import entite.Membre;
import entite.Personne;

public class Association implements Notifiable {
	
	private ArrayList<Membre> listeMembres;
	private ArrayList<Donateur> listeDonateurs;
	private ArrayList<Visite> visitesPlannifiees;
	private Budget budget;
	private Municipalite mairie;
	
	/**
	 * Constructeur par d�faut de l'association
	 */
	public Association(Municipalite mairie) {
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
	 * M�thode d'acc�s � la mairie � laquelle est associ�e l'Association
	 * @return la mairie
	 */
	public Municipalite getMairie() {
		return mairie;
	}
	
	/**
	 * M�thode d'acc�s aux visites plannifi�es par l'association
	 * @return la liste des visites plannifi�es
	 */
	public ArrayList<Visite> getVisitesPlannifiees(){
		return visitesPlannifiees;
	}
	
	/**
	 * M�thode permettant � l'association d'�num�rer la liste des arbres remarquables
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
	 * M�thode permettant de r�voquer un membre de l'association si celui-ci n'a pas regl� sa cotisation
	 * @param membre
	 */
	public void revoquer(Membre membre) {
		listeMembres.remove(membre);
		membre=null;	
	}
	
	/**
	 * Methode permettant l'inscription d'une personne dans l'association
	 * @param personne la personne � inscrire
	 */
	public Membre inscrire(Personne personne) {
		Membre membre = new Membre (personne,this);
		listeMembres.add(membre);
		return membre;
	}
	
	/**
	 * Methode d'acc�s � la listeDonateurs de l'association
	 * @return la listeDonateur de l'association
	 */
	public ArrayList<Donateur> getDonateurs(){
		return listeDonateurs;
	}
	
	/**
	 * M�thode permettant l'ajout d'un nouveau Donateur � la listeDonateurs de l'association
	 * @param donateur un nouveau Donateur
	 */
	public void ajouterDonateur(Object objet) {
		if(objet instanceof Donateur){
			listeDonateurs.add((Donateur) objet);
		}
	}
	
	/**
	 * Methode permettant de mettre a jour le budget de l'association suite � une transaction,
	 * si la transaction correspond � une facture, on v�rifie d'abord que la somme � payer est disponible
	 * @param transaction la transaction effectu�e
	 */
	public void effectuerTransaction(Transaction transaction) {
		
		if(transaction instanceof Facture) {
			if(getBudget().getSomme()>=transaction.getMontant()) {
				budget.CalculBudget(transaction);
			}
		}
		else {
		budget.CalculBudget(transaction);
		}
	}
	
	/**
	 * m�thode notifiant l'association d'une action ayant eue lieu sur un arbre
	 */
	public void notifier(Notification notification) {
		notification.toString();
	}
	
	/**
	 * M�thode permettant de transmettre � la mairie la liste des arbres qu'elle nomine pour �tre classifi�s
	 * comme remarquables. Liste contenant les 5 arbres les plus nomin�s par les membres de l'association.
	 * En cas d'�galit�, on proc�de par circonf�rence et hauteur croissante. On r�initialise �galement les nominations
	 * de chaque membre ainsi que le compteur de nominations pour chaque arbre.
	 * @param mairie la Municipalite qui tient la liste d'arbres
	 * @return les arbres nomin�s par l'association
	 */
	public ArrayList<Arbre> nominer() {
		
		ArrayList<Arbre> nominations= new ArrayList<Arbre>();
		
		for(int i=0; i<5; i++) {
			nominations.add(null);
		}
		
		for(Membre membre : listeMembres) {
			for(int i=0 ; i<membre.getNominations().size(); i++) {
			membre.getNominations().remove(i);
			}
		}
		
		for(int j=0; j<nominations.size(); j++) {
			
			
			for(Arbre arbre : getMairie().getListArbre()) {
				if(nominations.get(j)==null) {
					//System.out.println("nominations : "+nominations);
					nominations.set(j, arbre);
				}
				else if(arbre.getNbNominations()>nominations.get(j).getNbNominations()){
					nominations.set(j, arbre);
				}
				else if(arbre.getNbNominations()==nominations.get(j).getNbNominations()){
					
					 if(arbre.getCirconference()>nominations.get(j).getCirconference()) {
						 nominations.set(j, arbre);
					 }
					 else if(arbre.getCirconference()==nominations.get(j).getCirconference()) {
						 
						  if(arbre.getHauteur()>nominations.get(j).getHauteur()) {
							  nominations.set(j, arbre);
						  }
					 }
				}
			}
			nominations.get(j).resetNominations();
		}
		
		for(Arbre arbre : mairie.getListArbre()) {
			arbre.resetNominations();
		}
		return nominations;
	}
	
	public void finExerciceBudgetaire() {
		
		for(Membre membre : getListeMembres()) {
			if(membre.getCotisationsAnnuelles().get(membre.getCotisationsAnnuelles().size()-1)==0) {
				revoquer(membre);
			}
			else {
				membre.getCotisationsAnnuelles().add((float) 0);
			}
		}
		
		budget.nouvelleAnnee();
		nominer();
		
	}
	
	private void demanderSubvention() {
		for(Donateur donateur : listeDonateurs) {
			
		}
	}
	
	public static void main(String[] args) {
		
		
	}
	

}
