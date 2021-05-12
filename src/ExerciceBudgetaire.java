import java.util.Date;

public class ExerciceBudgetaire{
	
	private int annee;
	private StringBuilder historique;
	
	/**
	 * Constructeur d'un exercice budgétaire avec l'état actuel du budget
	 * @param budget le budget actuel
	 */
	public ExerciceBudgetaire(Budget budget) {
		annee= new Date().getYear();
		historique = new StringBuilder();
		historique.append( "Budget initial :" + budget.getSomme() + "\n");
	}
	
	/**
	 * Méthode sauvegardant l'historiques des transactions ayant eu lieu
	 * @param transaction la transaction effectuée
	 * @param budget le budget actuel
	 */
	void SauvegarderTransaction(Transaction transaction, Budget budget) {
		
		historique.append(transaction.getDate() + " " + transaction.getDescription() + transaction.getMontant()
		+ "euros" + " buget : " + budget.getSomme());
		
	}
	
	

}
