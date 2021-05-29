package entite;
import Asso.Association;
import Asso.DemandeSubvention;

public interface Donateur {

	/**
	 * Méthode permettant a un Donateur d'effectuer une donation à une association
	 * @param association pour le don
	 * @param montant le montant de la donation
	 */
	void Donation(Association association, float montant);
	
	/**
	 * Méthode permettant à un Donateur de recevoir une demande de subvention
	 * @param demande la demande de subvention
	 */
	void recevoirDemande(DemandeSubvention demande);
}