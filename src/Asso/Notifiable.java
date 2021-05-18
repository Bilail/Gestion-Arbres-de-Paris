package Asso;

public interface Notifiable {
	/**
	 * méthode notifiant d'une action ayant eue lieu sur un arbre
	 * @param notification
	 */
	void notifier(Notification notification);
}
