package entite;

import java.util.Date;

import asso.Transaction;

public class CompteBancaire {
	
	private String propriétaire;
	private float solde;
	private Date date;
	
	/**
	 * Contructeur d'un CompteBancaire
	 * @param propriétaire, le proppriétaire du CompteBancaire
	 * @param solde, la somme sur le CompteBancaire
	 */
	public CompteBancaire(String propriétaire, float solde) {
		this.propriétaire=propriétaire;
		this.solde=solde;
		date=new Date();
	}
	
	/**
	 * Méthode d'accès au solde du CompteBancaire
	 * @return le solde du CompteBancaire
	 */
	public float getSolde() {
		return solde;
	}
	
	/**
	 * Méthode de mise à jour du solde d'un CompteBancaire
	 * @param montant à prendre en compte
	 */
	void calculSolde(float montant) {
		solde=solde + montant;
	}
}
