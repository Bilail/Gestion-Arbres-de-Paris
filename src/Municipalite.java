import java.util.ArrayList;

public class Municipalite implements Donateur, Notifiable {
	
	private ArrayList<Arbre> listeArbres;
	private ServiceEspacesVerts SEV;
	

	/**
	 * M�thode permettant � la municipalit� d'effectuer un don � une association
	 */
	public void Donation(Association association, float montant) {
		
		Transaction transaction = new Transaction(montant, "don de la municipalit�");
		association.EffectuerTransaction(transaction);
		association.ajouterDonateur((Object) this);
	}
	
	public ArrayList<Arbre> getListArbre(){
		return listeArbres;
	}

	public void notifier(Notification notification) {
		notification.toString();		
	}

}
