import java.util.Date;

public class Transaction {
	
	private float montant;
	private String description;
	private Date date;
	
	/**
	 * Constructeur d'une operation prenant en compte les informations
	 * @param montant
	 * @param description
	 */
	public Transaction(float montant, String description) {
		this.montant=montant;
		this.description=description;
		date = new Date();
	}
	
	/**
	 * Methode d'acc�s au montant de la Transaction
	 * @return
	 */
	public float getMontant() {
		return montant;
	}
	
	/**
	 * Methode d'acc�s � la description de la Transaction
	 * @return
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * M�thode d'acc�s � la date de la Transaction
	 * @return
	 */
	public Date getDate() {
		return date;
	}

}
