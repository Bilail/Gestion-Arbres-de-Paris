package entite;

import java.util.Date;

import Asso.Transaction;

public class CompteBancaire {
	
	private String propriétaire;
	private float solde;
	private Date date;
	
	public CompteBancaire(String propriétaire, float solde) {
		this.propriétaire=propriétaire;
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
