package asso;
import java.util.ArrayList;

public class Budget {
	
	private float somme;

	private ArrayList<ExerciceBudgetaire> listExercicesBudgetaires;
	
	/**
	 * Constructeur de Budget avec un montant initial nul
	 */
	public Budget() {
		listExercicesBudgetaires= new ArrayList<ExerciceBudgetaire>();
		somme=0;
		listExercicesBudgetaires.add(new ExerciceBudgetaire(this));
	}
	
	
	/**
	 * Methode d'accès au montant actuel du Budget
	 * @return le montant actuel du Budget
	 */
	public float getSomme() {
		return somme;
	}
	
	/**
	 * Méthode d'accès aux exercices budgétaires précédents
	 * @return la liste des exercices budgétaires précédents
	 */
	public ArrayList<ExerciceBudgetaire> getExercicesBudgetaires(){
		return listExercicesBudgetaires;
	}
	
	/**
	 * Methode d'accès à l'exercice budgétaire actuel
	 * @return l'exercice budgétaire en cours
	 */
	public ExerciceBudgetaire getEBActuel() {
		return getExercicesBudgetaires().get(getExercicesBudgetaires().size()-1);
	}
	
	/**
	 * Methode de mise à jour du Budget et qui fait appel à la sauvegarde de 
	 * la transaction dans l'exercice budgétaire actuel
	 * @param transaction la transaction effectueé
	 */
	void CalculBudget(Transaction transaction) {
		
		somme=somme+transaction.getMontant();
		getEBActuel().SauvegarderTransaction(transaction, this);
	}
	
	/**
	 * Méthode permettant de de changer d'année d'un point de vue du budget en stockant l'exercice budgetaire
	 * et qui en crée un nouveau
	 */
	void nouvelleAnnee() {
		listExercicesBudgetaires.add(new ExerciceBudgetaire(this,getEBActuel().getAnnee()+1));
	}
}
