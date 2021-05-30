package entite;

import Asso.Association;
import Asso.DemandeSubvention;
import Asso.Transaction;

public class Entreprise implements Donateur {
	
	private String nom;
	private CompteBancaire compte;
	
	/**
	 * Constructeur d'une Entreprise
	 * @param nom le nom de l'entreprise
	 * @param montant le montant dont l'Entreprise dispose sur son Compte
	 */
	public Entreprise(String nom, float montant) {
		this.nom=nom;
		compte=new CompteBancaire("nom",montant);
	}
	
	/**
	 * M�thode d'ac�s au CompteBancaire de l'Entreprise
	 * @return le CompteBancaire de l'Entreprise
	 */
	public CompteBancaire getCompte() {
		return compte;
	}
	
	/**
	 * M�thode d'acc�s au nom de l'Entreprise
	 * @return le nom de l'entreprise
	 */
	public String getNom() {
		return nom;
	}

	@Override
	public void Donation(Association association, float montant) {
		Transaction transaction = new Transaction(montant, "don d'une entreprise");
		association.effectuerTransaction(transaction);
		compte.calculSolde(-(montant));
		association.ajouterDonateur(this);
	}

	@Override
	public void recevoirDemande(DemandeSubvention demande) {
		System.out.println(demande);
	}
	
}
