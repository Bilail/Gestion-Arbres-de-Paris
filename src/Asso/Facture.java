package Asso;

public class Facture extends Transaction {
	
	/**
	 * Contructeur d'une facture identique à celui d'une transaction, on veut simplement la différencier
	 * car son paiement n'est effectuer que si l'association dispose de la somme due
	 * @param montant le montant a payer (négatif)
	 * @param description la description de la facture
	 */
	public Facture(float montant, String description) {
		super(montant, description);
	}

}
