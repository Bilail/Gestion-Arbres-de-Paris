package asso;

public interface Notifiable {
	
	/**
	 * m�thode notifiant d'une action ayant eue lieu sur un arbre
	 * @param notification, message 
	 */
	void recevoirNotification(Notification notification);
}
