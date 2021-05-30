package asso;

public class Facture extends Transaction {
	
	/**
	 * Contructeur d'une facture identique � celui d'une transaction, on veut simplement la diff�rencier
	 * car son paiement n'est effectuer que si l'association dispose de la somme due
	 * @param montant le montant a payer (n�gatif)
	 * @param description la description de la facture
	 */
	public Facture(float montant, String description) {
		super(montant, description);
	}

}
