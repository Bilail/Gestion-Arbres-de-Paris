import java.util.Date;

public class CompteRendu {
	
	private Date date;
	private String contenu;
	private Membre auteur;
	private Arbre abr;
	
	public CompteRendu(String contenu, Arbre abr) {
		date= new Date();
		this.contenu=contenu;
		this.abr = abr;
	}
	
	/**
	 * Redéfinition de la méthode toString() dans le cadre d'un CompteRendu
	 */
	@Override
	public String toString() {
		return "CompteRendu du " + date + "par" + auteur.getPrenom() + " " + auteur.getNom() + " : " + "\n"
				+ contenu + "arbre : " + abr;
	}

}	
