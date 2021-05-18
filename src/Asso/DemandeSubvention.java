package Asso;

public class DemandeSubvention extends Notification {
	
	private Budget budget;
	
	/**
	 * Contructeur d'une DemandeSubvention à partir du Budget de l'Association
	 * @param description
	 */
	public DemandeSubvention(String description) {
		super(description);
		budget=budget;
	}
	
	/**
	 * redefinition de la méthode toString() pour une demande de subvention
	 * qui rajoute un rapport d'activité comprenant l'exercice budgetaire actuel et précédent
	 * du budget de l'association
	 */
	@Override
	public String toString() {
		return super.toString() + "\n" +
			   "Rapport d'activité : " + "\n" +
			   "Exercice budgétaire actuel : " + budget.getEBActuel().toString() + "\n" +
			   "Exercice budgétaire précédent : " + 
			   budget.getExercicesBudgetaires().get(budget.getExercicesBudgetaires().size()-1).toString();
	}

}
