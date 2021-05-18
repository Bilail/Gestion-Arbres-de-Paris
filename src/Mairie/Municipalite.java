package Mairie;
import java.util.ArrayList;

import Asso.Association;
import Asso.Notifiable;
import Asso.Notification;
import Asso.Transaction;
import entite.Donateur;

public class Municipalite implements Donateur, Notifiable {
	
	private ArrayList<Arbre> listeArbres;
	private ServiceEspacesVerts SEV;
	

	/**
	 * Méthode permettant à la municipalité d'effectuer un don à une association
	 */
	public void Donation(Association association, float montant) {
		
		Transaction transaction = new Transaction(montant, "don de la municipalité");
		association.EffectuerTransaction(transaction);
		association.ajouterDonateur((Object) this);
	}
	
	public ArrayList<Arbre> getListArbre(){
		return listeArbres;
	}

	public void notifier(Notification notification) {
		notification.toString();		
	}

}
