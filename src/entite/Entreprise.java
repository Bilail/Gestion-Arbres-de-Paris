package entite;

import Asso.Association;
import Asso.Transaction;

public class Entreprise implements Donateur {
	
	private String nom;
	private CompteBancaire compte;
	
	public Entreprise(String nom, float montant) {
		this.nom=nom;
		compte=new CompteBancaire("nom",montant);
	}
	
	public CompteBancaire getCompte() {
		return compte;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public void Donation(Association association, float montant) {
		Transaction transaction = new Transaction(montant, "don d'une entreprise");
		association.effectuerTransaction(transaction);
		compte.calculSolde(-(montant));
	}
	
}
