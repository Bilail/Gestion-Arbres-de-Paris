import java.util.ArrayList;
import java.util.Date;

public class Membre extends Personne {
	
	private Date DateInscription;
	private Association association;
	private ArrayList<Float> CotisationsAnnuelles;
	
	/**
	 * Constructeur d'un membre de l'association à partir d'une personne
	 * qui initialise la date de l'inscription
	 * @param p la personne qui devient membre de l'association
	 * @param association l'association dont fait partie le membre
	 */
	Membre(Personne p, Association association){
		super(p.getNom(), p.getPrenom(),p.getAdresse(),p.getDateNaissance());
		this.association=association;
		this.DateInscription=new Date();
	}
	
	/**
	 * Méthode d'accès à la date d'inscription du membre
	 * @return DateInscription
	 */
	public Date getDateInscription() {
		return DateInscription;
	}
	
	/**
	 * Méthode d'accès aux CotisationsAnnuelles du membre
	 * @return les CotisationAnnuelles
	 */
	public ArrayList<Float> getCotisationsAnnuelles() {
		return CotisationsAnnuelles;
	}

	/**
	 * Méthode permettant à un membre de cotiser pour l'association
	 * @param somme le montant de la cotisation
	 */
	public void Cotiser(float somme) {
		CotisationsAnnuelles.add(somme);
	}

	/**
	 * Méthode permettant à un membre de quitter l'association
	 */
	private void Quitter() {
		association.Revoquer(this);
	}
}
