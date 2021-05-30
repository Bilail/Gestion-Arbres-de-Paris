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
	 * @param Mairie la mairie � laquelle les SEV sont associ�s
	 */
	public ServicesEspacesVerts(Mairie Mairie) {
		this.Mairie = Mairie;
		notifiables = new ArrayList<Notifiable>();
	}
	
	
	/**
	 * M�thode permettant la classification d'un arbre
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
	 * M�thode permettant de planter un arbre � un endroit donn�
	 * @param arbre l'arbre � plant�
	 * @param GPS les futures coordonn�es GPS l'arbre
	 * @param Adresse la future adresse de l'arbre
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
	 * M�thode permettant l'abattage d'un arbre
	 * @param arbre l'arbre � abattre
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
	 * M�thode permettant de maintenir � jour la liste de personne � notifier pour des actions sur un arbre
	 * @param notifiable un notifiable
	 */
	public void ajoutNotifiable(Notifiable notifiable) {
		notifiables.add(notifiable);
	}

}
