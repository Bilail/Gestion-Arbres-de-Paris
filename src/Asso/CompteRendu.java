package Asso;
import java.util.Date;

import Mairie.Arbre;
import entite.Membre;

public class CompteRendu {
	
	private Date date;
	private String contenu;
	private Membre auteur;
	private Arbre arbre;
	
	public CompteRendu(String contenu, Arbre arbre) {
		date = new Date();
		this.contenu=contenu;
		this.arbre = arbre;
	}
	
	/**
	 * Redéfinition de la méthode toString() dans le cadre d'un CompteRendu
	 */
	@Override
	public String toString() {
		return "CompteRendu du " + date + "par" + auteur.getPrenom() + " " + auteur.getNom() + " : " + "\n"
				+ contenu + "arbre : " + arbre;
	}

}	
