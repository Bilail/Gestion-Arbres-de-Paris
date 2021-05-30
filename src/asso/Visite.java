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
	 * @param arbre l'arbre concerné
	 * @param membre le membre qui visite 
	 * @param date la date à laquelle on plannifie la visite
	 */
	public Visite(Arbre arbre, Membre membre, Date date) {
		this.arbre=arbre;
		this.membre=membre;
		this.date=date;
	}
	
	/**
	 * Méthode d'accès à la date d'une Visite
	 * @return la date de la visite
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * Méthode d'accès à l'arbre concerné par la Visite
	 * @return l'arbre concerné par la Visite
	 */
	public Arbre getArbre() {
		return arbre;
	}
	
	/**
	 * Méthode d'accès au membre qui effectue la Visite
	 * @return le membre qui effectue la Visite
	 */
	public Membre getMembre() {
		return membre;
	}
	
	/**
	 * Méthode d'accès au montant fixe dont le membre est défrayé pour une Visite
	 * @return le montant de défraiement
	 */
	public int getMontantDefraiement() {
		return montantDefraiement;
	}
	
	@Override
	public String toString() {
		return "\n" + "visite de larbre : " + getArbre() + "\n " + 
				"prévue le : " + getDate() + " par : " + getMembre().getPrenom() + " " + getMembre().getNom();
	}

}
