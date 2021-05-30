package municipalite;


import java.util.ArrayList;
import java.util.Date;

import asso.Notifiable;
import asso.Notification;



public class ServicesEspacesVerts {
	
	private ArrayList<Notifiable> notifiables; 
	private Mairie Mairie;
	
	/**
	 * Constructeur des servives espaces verts
	 * @param Mairie la mairie à laquelle les SEV sont associés
	 */
	public ServicesEspacesVerts(Mairie Mairie) {
		this.Mairie = Mairie;
		notifiables = new ArrayList<Notifiable>();
	}
	
	
	/**
	 * Méthode permettant la classification d'un arbre
	 * @param arbre un arbre
	 */
	public void classifier(Arbre arbre) {
		
		arbre.classifier(new Date());
		
		Notification notification = new Notification("classification",arbre);
		
		for(Notifiable i :notifiables) {
			i.recevoirNotification(notification);
		}
	}
	
	/**
	 * Méthode permettant de planter un arbre à un endroit donné
	 * @param arbre l'arbre à planté
	 * @param GPS les futures coordonnées GPS l'arbre
	 * @param adresse la future adresse de l'arbre
	 */
	public void Planter(Arbre arbre,Float[] GPS, String adresse) {
		arbre.setAdresse(adresse);
		arbre.setGPS(GPS);
		
		Notification notification = new Notification("plantation",arbre);
		
		for(Notifiable i :notifiables) {
			i.recevoirNotification(notification);
		}
	}
	
	/**
	 * Méthode permettant l'abattage d'un arbre
	 * @param arbre l'arbre à abattre
	 */
	public void Abattre(Arbre arbre) {
	
		Notification notification = new Notification("Abattage",arbre);
		
		for(Notifiable i :notifiables) {
			i.recevoirNotification(notification);
		}
		Mairie.getListArbre().remove(arbre);
		arbre=null;
	}
	
	/**
	 * Méthode permettant de maintenir à jour la liste de personne à notifier pour des actions sur un arbre
	 * @param notifiable un notifiable
	 */
	public void ajoutNotifiable(Notifiable notifiable) {
		notifiables.add(notifiable);
	}

}
