package Asso;

public interface Notifiable {
	
	/**
	 * m�thode notifiant d'une action ayant eue lieu sur un arbre
	 * @param notification
	 */
	void recevoirNotification(Notification notification);
}
