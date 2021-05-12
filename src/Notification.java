import java.util.Date;

import java.util.ArrayList;

public class Notification {
	
	private Date DateNotification;
	private String description;
	private Arbre arbre;
	
	/**
	 * Constructeur d'une notification prenant en compte les trois �l�ments d'une notification
	 * @param DateNotification date d'�mission de la notification
	 * @param description description de l'action effectu�e sur l'abre
	 * @param arbre l'arbre sur lequel l'action a �t� effectu�e
	 */
	public Notification(String description, Arbre arbre) {
		DateNotification = new Date();
		this.description=description;
		this.arbre=arbre;
	}
	
	/**
	 * Red�finition de la m�thode toString() dans le cadre d'une Notification
	 */
	@Override
	public String toString() {
		return description + "le : " + DateNotification +" de l'arbre : " + arbre.toString();
	}
	
	
}
