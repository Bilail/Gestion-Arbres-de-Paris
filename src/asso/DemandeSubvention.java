package asso;

public class DemandeSubvention{
	
	private Budget budget;
	private String description;
	
	/**
	 * Contructeur d'une DemandeSubvention � partir du Budget de l'Association
	 * @param description
	 */
	public DemandeSubvention(String description, Budget budget) {
		this.description=description;
		this.budget=budget;   // A quoi sert cette ligne ? ? 
	}
	
	/**
	 * redefinition de la m�thode toString() pour une demande de subvention
	 * qui rajoute un rapport d'activit� comprenant l'exercice budgetaire actuel et pr�c�dent
	 * du budget de l'association
	 */
	@Override
	public String toString() {
		return description + "\n" +
			   "Rapport d'activit� : " + "\n" +
			   "Exercice budg�taire actuel : " + budget.getEBActuel() + "\n" +
			   "Exercice budg�taire pr�c�dent : " + 
			   budget.getExercicesBudgetaires().get(budget.getExercicesBudgetaires().size()-1);
	}

}
