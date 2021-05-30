package Asso;
import java.util.Date;

import Municipalite.Arbre;

public class Notification {
	
	private Date DateNotification;
	private String description;
	private Arbre arbre;
	/**
	 * Constructeur d'une notification prenant en compte les trois �l�ments d'une notification
	 * @param DateNotification date d'�mission de la notification
	 * @param description description de l'action effectu�e sur l'arbre
	 */
	public Notification(String description, Arbre arbre) {
		DateNotification = new Date();
		this.description=description;
		this.arbre=arbre;
	}

	@Override
	public String toString() {
		return description + " le : " + DateNotification +" de l'arbre : " + arbre;
	}
	
	
}
