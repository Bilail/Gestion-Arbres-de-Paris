import java.util.Date;

import java.util.ArrayList;

public class Notification {
	
	private Date DateNotification;
	private String description;
	private Arbre arbre;
	
	/**
	 * Constructeur d'une notification prenant en compte les trois éléments d'une notification
	 * @param DateNotification date d'émission de la notification
	 * @param description description de l'action effectuée sur l'abre
	 * @param arbre l'arbre sur lequel l'action a été effectuée
	 */
	public Notification(String description, Arbre arbre) {
		DateNotification = new Date();
		this.description=description;
		this.arbre=arbre;
	}
	
	/**
	 * Redéfinition de la méthode toString() dans le cadre d'une Notification
	 */
	@Override
	public String toString() {
		return description + "le : " + DateNotification +" de l'arbre : " + arbre.toString();
	}
	
	
}
