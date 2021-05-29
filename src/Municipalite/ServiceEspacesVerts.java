package Municipalite;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Date;

import Asso.Notifiable;
import Asso.Notification;
import Asso.NotificationArbre;
import Municipalite.Mairie;

public class ServiceEspacesVerts {
	
	private ArrayList<Notifiable> notifiables; 
	private Mairie Mairie;
	
	public ServiceEspacesVerts(Mairie Mairie) {
		this.Mairie = Mairie;
		notifiables = new ArrayList<Notifiable>();
	}
	
	
	/**
	 * Méthode permettant la classification d'un arbre
	 * @param arbre un arbre
	 * @param remarquable vaut true si l'arbre est remarquable, false sinon
	 */
	public void Classifier(Arbre arbre, boolean remarquable) {
		
		arbre.setRemarquable(remarquable);
		
		Notification notification = new NotificationArbre("classification",arbre);
		
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
	public void Classifier (Arbre arbre, boolean remarquable, Date DateClassification) {
		this.Classifier(arbre, remarquable);
		arbre.classifier(DateClassification);
		
	}
	
	/**
	 * Méthode permettant de planter un arbre à un endroit donné
	 * @param arbre l'arbre à planté
	 * @param GPS les futures coordonnées GPS l'arbre
	 * @param Adresse la future adresse de l'arbre
	 */
	public void Planter(Arbre arbre,Float[] GPS, String Adresse) {
		arbre.setAdresse(Adresse);
		arbre.setGPS(GPS);
		
		Notification notification = new NotificationArbre("plantation",arbre);
		
		for(Notifiable i :notifiables) {
			i.notifier(notification);
		}
	}
	
	/**
	 * Méthode permettant l'abattage d'un arbre
	 * @param arbre l'arbre à abattre
	 */
	public void Abattre(Arbre arbre) {
	
		Notification notification = new NotificationArbre("Abattage",arbre);
		
		for(Notifiable i :notifiables) {
			i.notifier(notification);
		}
		Mairie.getListArbre().remove(arbre);
		arbre=null;
	}
	
	public void ajoutNotifiable(Notifiable n) {
		notifiables.add(n);
	}
	public static void main(String[] args) {
	

	}

}
