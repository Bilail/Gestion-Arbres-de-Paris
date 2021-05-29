package Municipalite;
import java.util.ArrayList;

import Asso.Association;
import Asso.DemandeSubvention;
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
	
	
	
	
	public ArrayList<Arbre> getListArbre(){
		return listeArbres;
	}

	public void notifier(Notification notification) {
		notification.toString();		
	}
	
	public void setListeArbres(ArrayList<Arbre> liste_arbre) {
		listeArbres = liste_arbre;
	}

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
