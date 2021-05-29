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
	 * @param visite, la visite qui a donnée lieu à ce compte rendu
	 */
	public CompteRendu(String contenu, Visite visite) {
		date = visite.getDate();
		this.contenu=contenu;
		arbre = visite.getArbre();
		auteur = visite.getMembre();
	}
	
	/**
	 * Méthode d'accès à la date du CompteRendu
	 * @return la date du CompteRendu
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Méthode d'accès au contenu du CompteRendu
	 * @return le contenu du CompteRendu
	 */
	public String getContenu() {
		return contenu;
	}

	/**
	 * Méthode d'accès à l'auteur du CompteRendu
	 * @return l'auteur du CompteRendu
	 */
	public Membre getAuteur() {
		return auteur;
	}

	/**
	 * Méthode d'accès à l'arbre concerné par le CompteRendu
	 * @return l'arbre du CompteRendu
	 */
	public Arbre getArbre() {
		return arbre;
	}


	/**
	 * Redéfinition de la méthode toString() dans le cadre d'un CompteRendu
	 */
	@Override
	public String toString() {
		return "CompteRendu du " + getDate() + " par " + getAuteur().getPrenom() + " " + getAuteur().getNom() + " : " + "\n"
				+ getContenu();
	}

}	
