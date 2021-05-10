import java.util.ArrayList;

public class Municipalite implements Donateur {
	
	private ArrayList<Arbre> ListeArbres;
	private ServiceEspacesVerts SEV;
	

	/**
	 * Méthode permettant à la municipalité d'effectuer un don à une association
	 */
	public void Donation(Association association, float montant) {
		
		Transaction transaction = new Transaction(montant, "don de la municipalité");
		association.EffectuerTransaction(transaction);
	}

}
