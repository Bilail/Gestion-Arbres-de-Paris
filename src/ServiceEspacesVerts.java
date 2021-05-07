import java.awt.Point;
import java.util.ArrayList;
import java.util.Date;

public class ServiceEspacesVerts {
	
	private ArrayList<Notifiable> notifiables; 
	

	/**
	 * Méthode permettant la classification d'un arbre
	 * @param arbre un arbre
	 * @param remarquable vaut true si l'arbre est remarquable, false sinon
	 */
	void Classifier(Arbre arbre, boolean remarquable) {
		
		arbre.setRemarquable(remarquable);
		
		Notification notification = new Notification(new Date(),"classification",arbre);
		
		for(Notifiable i :notifiables) {
			i.notifier(notification);
		}
	}
	
	/**
	 *Méthode permettant la classification d'un arbre
	 * @param arbre un arbre
	 * @param remarquable vaut true si l'arbre est remarquable, false sinon
	 * @param DateClassification date à laquelle l'arbre a été classifié
	 */
	void Classifier (Arbre arbre, boolean remarquable, String DateClassification) {
		this.Classifier(arbre, remarquable);
		arbre.setDateClassification(DateClassification);
		
	}
	
	/**
	 * Méthode permettant de planter un arbre à un endroit donné
	 * @param arbre l'arbre à planté
	 * @param GPS les futures coordonnées GPS l'arbre
	 * @param Adresse la future adresse de l'arbre
	 */
	void Planter(Arbre arbre,Point GPS, String Adresse) {
		arbre.setAdresse(Adresse);
		arbre.setGPS(GPS);
		
		Notification notification = new Notification(new Date(),"plantation",arbre);
		
		for(Notifiable i :notifiables) {
			i.notifier(notification);
		}
	}
	
	/**
	 * Méthode permettant l'abattage d'un arbre
	 * @param arbre l'arbre à abattre
	 */
	void Abattre(Arbre arbre) {
		arbre=null;
		
		Notification notification = new Notification(new Date(),"Abattage",arbre);
		
		for(Notifiable i :notifiables) {
			i.notifier(notification);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
