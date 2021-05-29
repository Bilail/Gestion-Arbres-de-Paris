package Asso;
import java.util.Date;

import java.util.ArrayList;

public class Notification {
	
	private Date DateNotification;
	private String description;
	
	/**
	 * Constructeur d'une notification prenant en compte les trois �l�ments d'une notification
	 * @param DateNotification date d'�mission de la notification
	 * @param description description de l'action effectu�e sur l'arbre
	 */
	public Notification(String description) {
		DateNotification = new Date();
		this.description=description;
	}

	@Override
	public String toString() {
		return description + " le : " + DateNotification +" de l'arbre : ";
	}
	
	
}
