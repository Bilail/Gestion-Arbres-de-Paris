package Asso;
import java.util.Date;

import Municipalite.Arbre;
import entite.Membre;

public class CompteRendu {
	
	private Date date;
	private String contenu;
	private Membre auteur;
	private Arbre arbre;
	
	/**
	 * Constructeur d'un CompteRendu
	 * @param contenu, le contenu du CompteRendu
	 * @param visite, la visite qui a donn�e lieu � ce compte rendu
	 */
	public CompteRendu(String contenu, Visite visite) {
		date = visite.getDate();
		this.contenu=contenu;
		arbre = visite.getArbre();
		auteur = visite.getMembre();
	}
	
	/**
	 * M�thode d'acc�s � la date du CompteRendu
	 * @return la date du CompteRendu
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * M�thode d'acc�s au contenu du CompteRendu
	 * @return le contenu du CompteRendu
	 */
	public String getContenu() {
		return contenu;
	}

	/**
	 * M�thode d'acc�s � l'auteur du CompteRendu
	 * @return l'auteur du CompteRendu
	 */
	public Membre getAuteur() {
		return auteur;
	}

	/**
	 * M�thode d'acc�s � l'arbre concern� par le CompteRendu
	 * @return l'arbre du CompteRendu
	 */
	public Arbre getArbre() {
		return arbre;
	}


	/**
	 * Red�finition de la m�thode toString() dans le cadre d'un CompteRendu
	 */
	@Override
	public String toString() {
		return "CompteRendu du " + getDate() + " par " + getAuteur().getPrenom() + " " + getAuteur().getNom() + " : " + "\n"
				+ getContenu();
	}

}	
