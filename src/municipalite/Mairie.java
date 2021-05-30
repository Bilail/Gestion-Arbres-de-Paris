package municipalite;
import java.util.ArrayList;

import asso.Association;
import asso.DemandeSubvention;
import asso.Notifiable;
import asso.Notification;
import asso.Transaction;
import entite.Donateur;

public class Mairie implements Donateur, Notifiable {
	
	private ArrayList<Arbre> listeArbres;
	private ServicesEspacesVerts SEV;
	
	/**
	 * Constructeur de la Mairie
	 */
	public Mairie() {
		listeArbres = new ArrayList<Arbre>();
	}
	
	/**
	 * Méthode pour associer les ServicesEspacesVerts à la Mairie
	 * @param SEV les ServicesEspacesVerts
	 */
	public void setSEV(ServicesEspacesVerts SEV) {
		this.SEV=SEV;
	}
	
	/**
	 * Méthode d'accès à la liste des arbres de la commune tenue par la Mairie
	 * @return le liste D'arbres de la commune
	 */
	public ArrayList<Arbre> getListArbre(){
		return listeArbres;
	}
	
	@Override
	public void recevoirNotification(Notification notification) {
		notification.toString();		
	}
	
	/**
	 * Méthode permettant de charger la Liste d'abres dans la Mairie
	 * @param listeArbres la liste à charger
	 */
	public void setListeArbres(ArrayList<Arbre> listeArbres) {
		this.listeArbres = listeArbres;
	}

	@Override
	public void Donation(Association association, float montant) {
		
		Transaction transaction = new Transaction(montant, "don de la municipalité");
		association.effectuerTransaction(transaction);
		association.ajouterDonateur(this);
	}

	@Override
	public void recevoirDemande(DemandeSubvention demande) {
		System.out.println(demande);
	}

}
