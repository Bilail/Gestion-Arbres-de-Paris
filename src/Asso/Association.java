package Asso;

import java.util.ArrayList;

import Mairie.Arbre;
import Mairie.Municipalite;
import entite.Donateur;
import entite.Membre;
import entite.Personne;

public class Association implements Notifiable {
	
	private ArrayList<Membre> listeMembres;
	private Budget budget;
	private ArrayList<Donateur> listeDonateurs;
	private Municipalite mairie;
	
	/**
	 * Constructeur par d�faut de l'association
	 */
	public Association() {
		listeMembres= new ArrayList<Membre>();
		listeDonateurs=new ArrayList<Donateur>();
		budget = new Budget(); 
	}
	
	/**
	 * Permet d'obtenir la liste des membres de l'association
	 * @return liste membres
	 */
	public ArrayList<Membre> getListMembre(){
		return listeMembres;
	}
	
	/**
	 * Permet d'obtenir le budget s de l'association
	 * @return budget
	 */
	public Budget getBudget() {
		return budget;
	}
	
	/**
	 * Permet d'obtenir la liste des donateurs de l'association
	 * @return liste donateurs
	 */
	public ArrayList<Donateur> getListeDonateurs() {
		return listeDonateurs;
	}

	/**
	 * M�thode permettant de r�voquer un membre de l'association
	 * @param membre
	 */
	public void Revoquer(Membre membre) {
		listeMembres.remove(membre);
		membre=null;	
	}
	
	/**
	 * Methode permettant l'inscription d'une personne dans l'association
	 * @param personne la personne � inscrire
	 */
	public void inscrire(Personne personne) {
		Membre membre = new Membre (personne,this);
		listeMembres.add(membre);
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
	 * Methode permettant de mettre a jour le budget de l'association suite � une transaction
	 * @param transaction la transaction effectu�e
	 */
	public void EffectuerTransaction(Transaction transaction) {
		budget.CalculBudget(transaction);
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
	 * En cas d'�galit�, on proc�de par circonf�rence et hauteur croissante.
	 * @param mairie la Municipalite qui tient la liste d'arbres
	 * @return les arbres nomin�s par l'association
	 */
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
	
	private void demanderSubvention() {
		for(Donateur donateur : listeDonateurs) {
			
		}
	}
	
	public static void main(String[] args) {
		
		Association A = new Association();
		
		Personne p= new Personne("Jean", "Dupont","8 rue Balzac","03/06/1985");
		
		A.inscrire(p);
		
		System.out.println(A.listeMembres.get(0).getDateInscription());
	}

	
	

}
