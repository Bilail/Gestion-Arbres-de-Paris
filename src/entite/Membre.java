package entite;
import java.util.ArrayList;
import java.util.Date;

import Asso.Association;
import Mairie.Arbre;

public class Membre extends Personne {
	
	private Date dateInscription;
	private Association association;
	private ArrayList<Arbre> nominations;
	private ArrayList<Float> listeCotisationsAnnuelles;
	
	/**
	 * Constructeur d'un membre de l'association à partir d'une personne
	 * qui initialise la date de l'inscription
	 * @param p la personne qui devient membre de l'association
	 * @param association l'association dont fait partie le membre
	 */
	public Membre(Personne p, Association association){
		super(p.getNom(), p.getPrenom(),p.getAdresse(),p.getDateNaissance());
		this.association=association;
		this.dateInscription=new Date();
	}
	
	/**
	 * Méthode d'accès à la date d'inscription du membre
	 * @return DateInscription
	 */
	public Date getDateInscription() {
		return dateInscription;
	}
	
	/**
	 * Méthode d'accès aux CotisationsAnnuelles du membre
	 * @return les CotisationAnnuelles
	 */
	public ArrayList<Float> getCotisationsAnnuelles() {
		return listeCotisationsAnnuelles;
	}
	
	/**
	 * 
	 */
	public ArrayList<Arbre> getNominations(){
		return nominations;
	}
	
	/**
	 * Méthode permettant à un membre de cotiser pour l'association
	 * @param somme le montant de la cotisation
	 */
	public void Cotiser(float somme) {
		listeCotisationsAnnuelles.add(somme);
	}
	
	public void nominer(Arbre arbre) {
		
		if(nominations.size()==5) {
			nominations.remove(0);
		}
		
		nominations.add(arbre);
	}

	/**
	 * Méthode permettant à un membre de quitter l'association
	 */
	private void Quitter() {
		association.Revoquer(this);
	}
}
