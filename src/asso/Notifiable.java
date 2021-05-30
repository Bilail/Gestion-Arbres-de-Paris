package asso;

public interface Notifiable {
	
	/**
	 * méthode notifiant d'une action ayant eue lieu sur un arbre
	 * @param notification, message 
	 */
	void recevoirNotification(Notification notification);
}
