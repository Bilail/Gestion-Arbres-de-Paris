package Asso;


public class ExerciceBudgetaire{
	
	private int annee = 2021;
	private StringBuilder historique;
	
	
	
	/**
	 * Constructeur par d�faut 
	 * @param budget le budget actuel
	 */
	public ExerciceBudgetaire(Budget budget) {
		
		historique = new StringBuilder();
		historique.append( "Budget initial : " + budget.getSomme() + "\n");
	}
	/**
	 * Constructeur d'un exercice budg�taire avec l'�tat actuel du budget
	 * @param budget le budget actuel
	 */
	public ExerciceBudgetaire(Budget budget, int annee) {
		this(budget);
		this.annee = annee;
	}

	
	/**
	 * Methode d'acc�s � l'ann�e de l'ExerciceBudgetaire
	 * @return ann�e de l'ExerciceBudgetaire
	 */
	public int getAnnee() {
		return annee;
	}
	
	/**
	 * M�thode d'acc�s � l'historique de l'ExerciceBudgetaire
	 * @return historique de l'ExerciceBudgetaire
	 */
	public StringBuilder getHistorique() {
		return historique;
	}
	
	/**
	 * M�thode sauvegardant l'historiques des transactions ayant eu lieu
	 * @param transaction la transaction effectu�e
	 * @param budget le budget actuel
	 */
	void SauvegarderTransaction(Transaction transaction, Budget budget) {
		
		historique.append(transaction.getDate() + " " + transaction.getDescription() + " " + transaction.getMontant()
		+ " euros" + " budget : " + budget.getSomme() + "\n");
		
	}
	
	@Override
	public String toString() {
		return "\n" + "Exercice budg�taire de l'ann�e : " + getAnnee() + "\n" +
				getHistorique().toString();
	}
	
	

}
