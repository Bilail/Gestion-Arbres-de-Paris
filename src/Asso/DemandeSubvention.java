package Asso;

public class DemandeSubvention extends Notification {
	
	private Budget budget;
	
	/**
	 * Contructeur d'une DemandeSubvention � partir du Budget de l'Association
	 * @param description
	 */
	public DemandeSubvention(String description) {
		super(description);
		budget=budget;
	}
	
	/**
	 * redefinition de la m�thode toString() pour une demande de subvention
	 * qui rajoute un rapport d'activit� comprenant l'exercice budgetaire actuel et pr�c�dent
	 * du budget de l'association
	 */
	@Override
	public String toString() {
		return super.toString() + "\n" +
			   "Rapport d'activit� : " + "\n" +
			   "Exercice budg�taire actuel : " + budget.getEBActuel().toString() + "\n" +
			   "Exercice budg�taire pr�c�dent : " + 
			   budget.getExercicesBudgetaires().get(budget.getExercicesBudgetaires().size()-1).toString();
	}

}
