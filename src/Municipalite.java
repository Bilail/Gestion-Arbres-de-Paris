import java.util.ArrayList;

public class Municipalite implements Donateur {
	
	private ArrayList<Arbre> ListeArbres;
	private ServiceEspacesVerts SEV;
	

	/**
	 * M�thode permettant � la municipalit� d'effectuer un don � une association
	 */
	public void Donation(Association association, float montant) {
		
		Transaction transaction = new Transaction(montant, "don de la municipalit�");
		association.EffectuerTransaction(transaction);
	}

}
