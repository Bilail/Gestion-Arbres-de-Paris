package asso;
import java.util.Date;

public class Transaction {
	
	private float montant;
	private String description;
	private Date date;
	
	/**
	 * Constructeur d'une operation prenant en compte les informations
	 * @param montant le montant de la transaction
	 * @param description la description de la transaction
	 */
	public Transaction(float montant, String description) {
		this.montant=montant;
		this.description=description;
		date = new Date();
	}
	
	/**
	 * Methode d'acc�s au montant de la Transaction
	 * @return le montant de la transaction
	 */
	public float getMontant() {
		return montant;
	}
	
	/**
	 * Methode d'acc�s � la description de la Transaction
	 * @return la description de la transaction
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * M�thode d'acc�s � la date de la Transaction
	 * @return la date de la transaction
	 */
	public Date getDate() {
		return date;
	}

}
