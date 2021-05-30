package entite;

import java.util.Date;

import asso.Transaction;

public class CompteBancaire {
	
	private String propri�taire;
	private float solde;
	private Date date;
	
	/**
	 * Contructeur d'un CompteBancaire
	 * @param propri�taire, le proppri�taire du CompteBancaire
	 * @param solde, la somme sur le CompteBancaire
	 */
	public CompteBancaire(String propri�taire, float solde) {
		this.propri�taire=propri�taire;
		this.solde=solde;
		date=new Date();
	}
	
	/**
	 * M�thode d'acc�s au solde du CompteBancaire
	 * @return le solde du CompteBancaire
	 */
	public float getSolde() {
		return solde;
	}
	
	/**
	 * M�thode de mise � jour du solde d'un CompteBancaire
	 * @param montant � prendre en compte
	 */
	void calculSolde(float montant) {
		solde=solde + montant;
	}
}
