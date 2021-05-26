package entite;

import java.util.Date;

import Asso.Transaction;

public class CompteBancaire {
	
	private String propriétaire;
	private Double solde;
	private Date date;
	
	public CompteBancaire(String propriétaire, Double solde) {
		this.propriétaire=propriétaire;
		this.solde=solde;
		date=new Date();
	}
	
	void CalculSolde(Transaction transaction) {
		solde=solde + transaction.getMontant();
	}
}
