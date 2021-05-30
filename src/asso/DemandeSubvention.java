package asso;

public class DemandeSubvention{
	
	private Budget budget;
	private String description;
	
	/**
	 * Contructeur d'une DemandeSubvention à partir du Budget de l'Association
	 * @param description
	 */
	public DemandeSubvention(String description, Budget budget) {
		this.description=description;
		this.budget=budget;  
	}
	
	/**
	 * redefinition de la méthode toString() pour une demande de subvention
	 * qui rajoute un rapport d'activité comprenant l'exercice budgetaire actuel et précédent
	 * du budget de l'association
	 */
	@Override
	public String toString() {
		if (budget.getExercicesBudgetaires().size() == 1){
			return description + "\n" +
					   "Rapport d'activité : " + "\n" +
					   "\tExercice budgétaire actuel : " + budget.getEBActuel() + "\n";
		}
		else {
			return description + "\n" +
			   "Rapport d'activité : " + "\n" +
			   "\tExercice budgétaire actuel : " + budget.getEBActuel() + "\n" +
			   "\tExercice budgétaire précédent : " + 
			   budget.getExercicesBudgetaires().get(budget.getExercicesBudgetaires().size()-2);
		}
	}

}
