package entite;

import Asso.Association;
import Asso.Transaction;

public class Entreprise implements Donateur {
	
	private String nom;
	private CompteBancaire compte;
	

	@Override
	public void Donation(Association association, float montant) {
		Transaction transaction = new Transaction(montant, "don d'une entreprise");
		association.effectuerTransaction(transaction);
	}
	
}
