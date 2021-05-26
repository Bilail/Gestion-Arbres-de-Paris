package Asso;
import java.util.Date;

import Mairie.Arbre;
import entite.Membre;

public class CompteRendu {
	
	private Date date;
	private String contenu;
	private Membre auteur;
	private Arbre arbre;
	
	public CompteRendu(String contenu, Visite visite) {
		date = visite.getDate();
		this.contenu=contenu;
		arbre = visite.getArbre();
		auteur = visite.getMembre();
	}
	

	public Date getDate() {
		return date;
	}

	
	public String getContenu() {
		return contenu;
	}


	public Membre getAuteur() {
		return auteur;
	}


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
