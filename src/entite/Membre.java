package entite;
import java.util.ArrayList;
import java.util.Date;

import Asso.Association;
import Asso.CompteRendu;
import Asso.Transaction;
import Asso.Visite;
import Mairie.Arbre;

public class Membre extends Personne {
	
	private Date dateInscription;
	private Association association;
	private ArrayList<Arbre> nominations;
	private ArrayList<Float> listeCotisationsAnnuelles;
	private Visite prochaineVisite;
	
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
		nominations = new ArrayList<Arbre>();
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
	 * M�thode d'acc�s aux nominations d'arbres d'un Membre
	 * @return nominations la liste des nominations
	 */
	public ArrayList<Arbre> getNominations(){
		return nominations;
	}
	
	/**
	 * M�thode d'acc�s � la prochaine visite d'un Membre
	 * (on suppose qu'un Membre ne peut plannifier qu'une visite � la fois)
	 * @return prochaineVisite la prochaine visite
	 */
	public Visite getProchaineVisite() {
		return prochaineVisite;
	}
	
	/**
	 * M�thode permettant � un membre de cotiser pour l'association
	 * @param somme le montant de la cotisation
	 */
	public void Cotiser(float somme) {
		listeCotisationsAnnuelles.add(somme);
		association.effectuerTransaction(new Transaction(somme,"cotisation"));
		;
	}
	
	public void nominer(Arbre arbre) {
		
		if(nominations.size()==5) {
			nominations.get(0).denominer();
			nominations.remove(0);
		}
		arbre.nominer();
		nominations.add(arbre);
	}

	/**
	 * M�thode permettant � un membre de quitter l'association
	 */
	public void quitter() {
		association.Revoquer(this);
	}
	
	/**
	 * M�thode permettant � un membre de plannifier une visite
	 */
	public void plannifierVisite(Arbre arbre, Date date) {
		
		if(association.getArbresRemarquables().contains(arbre)){
			
			boolean dejaPlannifiee=false;
			
			for(Visite visite : association.getVisitesPlannifiees()) {
				
				if(visite.getArbre()==arbre) {
					dejaPlannifiee=true;
				}
			}
			
			if(dejaPlannifiee==false) {
				
			prochaineVisite =new Visite(arbre, this, date);
			association.getVisitesPlannifiees().add(prochaineVisite);
			
			}
			else {
				System.out.println("\n" + "visite d�j� plannifi�e sur cet arbre");
			}
		}
	}
	
	/**
	 * M�thode permettant � un membre d'effectuer une visite pr�alablement plannifi�e
	 * @param visite la visite � effectuer
	 */
	public void effectuerVisite(Visite visite, String bilan) {
		
		if(association.getVisitesPlannifiees().contains(visite) && visite.getDate().getDay()==new Date().getDay()) {
			visite.getArbre().ajouterCompteRendu(new CompteRendu(bilan,visite));
			association.effectuerTransaction(new Transaction(visite.getMontantDefraiement(),"defraiement"));
			association.getVisitesPlannifiees().remove(visite);
		}
	}
	
	@Override
	public String toString() {
		return "\n Nom : " + getNom() + " pr�nom : " + getPrenom() + "\n inscrit : " + association + " depuis  " + dateInscription;
	}
}
