package Asso;
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
	 * Methode d'accès à l'année de l'ExerciceBudgetaire
	 * @return année de l'ExerciceBudgetaire
	 */
	public int getAnnee() {
		return annee;
	}
	
	/**
	 * Méthode d'accès à l'historique de l'ExerciceBudgetaire
	 * @return historique de l'ExerciceBudgetaire
	 */
	public StringBuilder getHistorique() {
		return historique;
	}
	
	/**
	 * Méthode sauvegardant l'historiques des transactions ayant eu lieu
	 * @param transaction la transaction effectuée
	 * @param budget le budget actuel
	 */
	void SauvegarderTransaction(Transaction transaction, Budget budget) {
		
		historique.append(transaction.getDate() + " " + transaction.getDescription() + transaction.getMontant()
		+ "euros" + " budget : " + budget.getSomme());
		
	}
	
	@Override
	public String toString() {
		return "Exercice budgétaire de l'année : " + getAnnee() + "\n" +
				getHistorique().toString();
	}
	
	

}
