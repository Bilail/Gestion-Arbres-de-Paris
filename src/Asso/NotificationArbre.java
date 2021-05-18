package Asso;
import Mairie.Arbre;

public class NotificationArbre extends Notification {
	
	private Arbre arbre;

	public NotificationArbre(String description, Arbre arbre) {
		super(description);
		this.arbre=arbre;
	}
	
	@Override
	public String toString(){
		return super.toString() + arbre;
	}
}
