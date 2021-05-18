package Mairie;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Date;

import Asso.Notifiable;
import Asso.Notification;
import Asso.NotificationArbre;

public class ServiceEspacesVerts {
	
	private ArrayList<Notifiable> notifiables; 
	

	/**
	 * M�thode permettant la classification d'un arbre
	 * @param arbre un arbre
	 * @param remarquable vaut true si l'arbre est remarquable, false sinon
	 */
	void Classifier(Arbre arbre, boolean remarquable) {
		
		arbre.setRemarquable(remarquable);
		
		Notification notification = new NotificationArbre("classification",arbre);
		
		for(Notifiable i :notifiables) {
			i.notifier(notification);
		}
	}
	
	/**
	 *M�thode permettant la classification d'un arbre
	 * @param arbre un arbre
	 * @param remarquable vaut true si l'arbre est remarquable, false sinon
	 * @param DateClassification date � laquelle l'arbre a �t� classifi�
	 */
	void Classifier (Arbre arbre, boolean remarquable, Date DateClassification) {
		this.Classifier(arbre, remarquable);
		arbre.classifier(DateClassification);
		
	}
	
	/**
	 * M�thode permettant de planter un arbre � un endroit donn�
	 * @param arbre l'arbre � plant�
	 * @param GPS les futures coordonn�es GPS l'arbre
	 * @param Adresse la future adresse de l'arbre
	 */
	void Planter(Arbre arbre,Float[] GPS, String Adresse) {
		arbre.setAdresse(Adresse);
		arbre.setGPS(GPS);
		
		Notification notification = new NotificationArbre("plantation",arbre);
		
		for(Notifiable i :notifiables) {
			i.notifier(notification);
		}
	}
	
	/**
	 * M�thode permettant l'abattage d'un arbre
	 * @param arbre l'arbre � abattre
	 */
	void Abattre(Arbre arbre) {
	
		Notification notification = new NotificationArbre("Abattage",arbre);
		
		for(Notifiable i :notifiables) {
			i.notifier(notification);
		}
		arbre=null;
	}

	public static void main(String[] args) {
	

	}

}
