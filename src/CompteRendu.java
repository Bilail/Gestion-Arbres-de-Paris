import java.util.Date;

public class CompteRendu {
	
	private Date date;
	private String contenu;
	private Membre auteur;
	
	public CompteRendu(Date date, String contenu) {
		this.date=date;
		this.contenu=contenu;
	}
	
	/**
	 * Redéfinition de la méthode toString() dans le cadre d'un CompteRendu
	 */
	@Override
	public String toString() {
		return "CompteRendu du " + date + "par" + auteur.getPrenom() + " " + auteur.getNom() + " : " + "\n"
				+ contenu ;
	}

}	
