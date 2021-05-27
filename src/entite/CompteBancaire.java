package entite;

import java.util.Date;

import Asso.Transaction;

public class CompteBancaire {
	
	private String propri�taire;
	private float solde;
	private Date date;
	
	public CompteBancaire(String propri�taire, float solde) {
		this.propri�taire=propri�taire;
		this.solde=solde;
		date=new Date();
	}
	
	public float getSolde() {
		return solde;
	}
	
	void calculSolde(float montant) {
		solde=solde + montant;
	}
}
