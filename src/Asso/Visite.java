package Asso;

import entite.Membre;

import java.util.Date;
import Mairie.Arbre;

public class Visite {
	
	private Date date;
	private Arbre arbre;
	private Membre membre;
	private static int montantDefraiement= -20;
	
	
	public Visite(Arbre arbre, Membre membre, Date date) {
		this.arbre=arbre;
		this.membre=membre;
		this.date=date;
	}
	
	public Date getDate() {
		return date;
	}
	
	public Arbre getArbre() {
		return arbre;
	}
	
	public Membre getMembre() {
		return membre;
	}
	
	public int getMontantDefraiement() {
		return montantDefraiement;
	}
	
	@Override
	public String toString() {
		return "\n" + "visite de larbre : " + getArbre() + "\n " + 
				"prévue le : " + getDate() + " par : " + getMembre().getPrenom() + " " + getMembre().getNom();
	}
	


}
