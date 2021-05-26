package entite;

import java.util.Date;

import Asso.Transaction;

public class CompteBancaire {
	
	private String propri�taire;
	private Double solde;
	private Date date;
	
	public CompteBancaire(String propri�taire, Double solde) {
		this.propri�taire=propri�taire;
		this.solde=solde;
		date=new Date();
	}
	
	void CalculSolde(Transaction transaction) {
		solde=solde + transaction.getMontant();
	}
}
