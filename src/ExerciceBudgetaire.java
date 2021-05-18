import java.util.Date;

public class ExerciceBudgetaire{
	
	private int annee;
	private StringBuilder historique;
	
	/**
	 * Constructeur d'un exercice budg�taire avec l'�tat actuel du budget
	 * @param budget le budget actuel
	 */
	public ExerciceBudgetaire(Budget budget) {
		annee= new Date().getYear();
		historique = new StringBuilder();
		historique.append( "Budget initial :" + budget.getSomme() + "\n");
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
		
		historique.append(transaction.getDate() + " " + transaction.getDescription() + transaction.getMontant()
		+ "euros" + " budget : " + budget.getSomme());
		
	}
	
	@Override
	public String toString() {
		return "Exercice budg�taire de l'ann�e : " + getAnnee() + "\n" +
				getHistorique().toString();
	}
	
	

}
