package asso;
import java.util.Date;

import municipalite.Arbre;

public class Notification {
	
	private Date DateNotification;
	private String description;
	private Arbre arbre;
	
	/**
	 * Constructeur d'une notification prenant en compte les trois éléments d'une notification
	 * @param arbre l'abre concerné par l'action
	 * @param description description de l'action effectuée sur l'arbre
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
