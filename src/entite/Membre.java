package entite;
import java.util.ArrayList;
import java.util.Date;

import Asso.Association;
import Asso.Transaction;
import Mairie.Arbre;

public class Membre extends Personne {
	
	private Date dateInscription;
	private Association association;
	private ArrayList<Arbre> nominations;
	private ArrayList<Float> listeCotisationsAnnuelles;
	
	/**
	 * Constructeur d'un membre de l'association � partir d'une personne
	 * qui initialise la date de l'inscription
	 * @param p la personne qui devient membre de l'association
	 * @param association l'association dont fait partie le membre
	 */
	public Membre(Personne p, Association association){
		super(p.getNom(), p.getPrenom(),p.getAdresse(),p.getDateNaissance());
		this.association=association;
		this.dateInscription=new Date();
		listeCotisationsAnnuelles = new ArrayList<Float>();
	}
	
	/**
	 * M�thode d'acc�s � la date d'inscription du membre
	 * @return DateInscription
	 */
	public Date getDateInscription() {
		return dateInscription;
	}
	
	/**
	 * M�thode d'acc�s aux CotisationsAnnuelles du membre
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
	 * M�thode permettant � un membre de cotiser pour l'association
	 * @param somme le montant de la cotisation
	 */
	public void Cotiser(float somme) {
		listeCotisationsAnnuelles.add(somme);
		association.EffectuerTransaction(new Transaction(somme,"cotisation"));
		;
	}
	
	public void nominer(Arbre arbre) {
		
		if(nominations.size()==5) {
			nominations.remove(0);
		}
		
		nominations.add(arbre);
	}

	/**
	 * M�thode permettant � un membre de quitter l'association
	 */
	private void Quitter() {
		association.Revoquer(this);
	}
	
	@Override
	public String toString() {
		return "\n Nom : " + getNom() + " pr�nom : " + getPrenom() + "\n inscrit : " + association + " depsuis  " + dateInscription;
	}
}
