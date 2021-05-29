package Municipalite;
import java.util.ArrayList;

import Asso.Association;
import Asso.Notifiable;
import Asso.Notification;
import Asso.Transaction;
import entite.Donateur;

public class Mairie implements Donateur, Notifiable {
	
	private ArrayList<Arbre> listeArbres;
	private ServiceEspacesVerts SEV;
	

	public Mairie() {
		listeArbres = new ArrayList<Arbre>();
	}
	
	
	/**
	 * Méthode permettant à la municipalité d'effectuer un don à une association
	 */
	public void Donation(Association association, float montant) {
		
		Transaction transaction = new Transaction(montant, "don de la municipalité");
		association.effectuerTransaction(transaction);
		association.ajouterDonateur((Object) this);
	}
	
	public ArrayList<Arbre> getListArbre(){
		return listeArbres;
	}

	public void notifier(Notification notification) {
		notification.toString();		
	}
	
	public void setListeArbres(ArrayList<Arbre> liste_arbre) {
		listeArbres = liste_arbre;
	}

}
