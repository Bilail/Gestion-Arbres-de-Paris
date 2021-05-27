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
	private static Float montantCotisation = (float) 30.0;
	
	/**
	 * Constructeur d'un membre de l'association à partir d'une personne
	 * qui initialise la date de l'inscription
	 * @param p la personne qui devient membre de l'association
	 * @param association l'association dont fait partie le membre
	 */
	public Membre(Personne p, Association association){
		super(p.getNom(), p.getPrenom(),p.getAdresse(),p.getDateNaissance(),p.getCompte().getSolde());
		this.association=association;
		this.dateInscription=new Date();
		nominations = new ArrayList<Arbre>();
		listeCotisationsAnnuelles = new ArrayList<Float>();
		listeCotisationsAnnuelles.add((float) 0);
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
	 * Méthode d'accès aux nominations d'arbres d'un Membre
	 * @return nominations la liste des nominations
	 */
	public ArrayList<Arbre> getNominations(){
		return nominations;
	}
	
	/**
	 * Méthode d'accès à la prochaine visite d'un Membre
	 * (on suppose qu'un Membre ne peut plannifier qu'une visite à la fois)
	 * @return prochaineVisite la prochaine visite
	 */
	public Visite getProchaineVisite() {
		return prochaineVisite;
	}
	
	/**
	 * Méthode permettant à un membre de cotiser une seule fois par an pour l'association
	 */
	public void Cotiser() {
		if(getCotisationsAnnuelles().get(getCotisationsAnnuelles().size()-1)==0) {
			
		listeCotisationsAnnuelles.set(getCotisationsAnnuelles().size()-1, montantCotisation);
		association.effectuerTransaction(new Transaction(montantCotisation,"cotisation"));
		
		}
		else {
			System.out.println("\n"+"cotisation annuelle déja effectuée");
		}
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
	 * Méthode permettant à un membre de quitter l'association
	 */
	public void quitter() {
		association.revoquer(this);
	}
	
	/**
	 * Méthode permettant à un membre de plannifier une visite
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
				System.out.println("\n" + "visite déjà plannifiée sur cet arbre");
			}
		}
	}
	
	/**
	 * Méthode permettant à un membre d'effectuer une visite préalablement plannifiée
	 * @param visite la visite à effectuer
	 */
	public void effectuerVisite(Visite visite, String bilan) {
		
		if(association.getVisitesPlannifiees().contains(visite) && visite.getDate().getDay()==new Date().getDay()) {
			visite.getArbre().ajouterCompteRendu(new CompteRendu(bilan,visite));
			association.effectuerTransaction(new Transaction(visite.getMontantDefraiement(),"defraiement"));
			getCompte().calculSolde(visite.getMontantDefraiement());
			association.getVisitesPlannifiees().remove(visite);
		}
	}
	
	@Override
	public String toString() {
		return "\n Nom : " + getNom() + " prénom : " + getPrenom() + "\n inscrit : " + " depuis  " + dateInscription;
	}
}
