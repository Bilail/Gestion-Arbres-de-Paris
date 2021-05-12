import java.util.ArrayList;

public class Budget {
	
	private float somme;
	private ExerciceBudgetaire EBactuel;
	private ArrayList<ExerciceBudgetaire> ExercicesBudgetaires;
	
	/**
	 * Constructeur de Budget avec un montant initial
	 * @param le montant initial du budget
	 */
	public Budget() {
		ExercicesBudgetaires= new ArrayList<ExerciceBudgetaire>();
		somme=0;
		EBactuel=new ExerciceBudgetaire(this);
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
		return ExercicesBudgetaires;
	}
	
	/**
	 * Methode d'accès à l'exercice budgétaire actuel
	 * @return l'exercice budgétaire en cours
	 */
	public ExerciceBudgetaire getEBActuel() {
		return EBactuel;
	}
	
	/**
	 * Methode de mise à jour du Budget et qui fait appel à la sauvegarde de 
	 * la transaction dans l'exercice budgétaire actuel
	 * @param transaction la transaction effectueé
	 */
	void CalculBudget(Transaction transaction) {
		
		somme=somme+transaction.getMontant();
		EBactuel.SauvegarderTransaction(transaction, this);
	}
}
