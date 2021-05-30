package asso;

import entite.Membre;
import municipalite.Arbre;

import java.util.Date;

public class Visite {
	
	private Date date;
	private Arbre arbre;
	private Membre membre;
	private static int montantDefraiement= -20;
	
	/**
	 * Constructeur d'une Visite
	 * @param arbre l'arbre concern�
	 * @param membre le membre qui visite 
	 * @param date la date � laquelle on plannifie la visite
	 */
	public Visite(Arbre arbre, Membre membre, Date date) {
		this.arbre=arbre;
		this.membre=membre;
		this.date=date;
	}
	
	/**
	 * M�thode d'acc�s � la date d'une Visite
	 * @return la date de la visite
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * M�thode d'acc�s � l'arbre concern� par la Visite
	 * @return l'arbre concern� par la Visite
	 */
	public Arbre getArbre() {
		return arbre;
	}
	
	/**
	 * M�thode d'acc�s au membre qui effectue la Visite
	 * @return le membre qui effectue la Visite
	 */
	public Membre getMembre() {
		return membre;
	}
	
	/**
	 * M�thode d'acc�s au montant fixe dont le membre est d�fray� pour une Visite
	 * @return le montant de d�fraiement
	 */
	public int getMontantDefraiement() {
		return montantDefraiement;
	}
	
	@Override
	public String toString() {
		return "\n" + "visite de larbre : " + getArbre() + "\n " + 
				"pr�vue le : " + getDate() + " par : " + getMembre().getPrenom() + " " + getMembre().getNom();
	}

}
