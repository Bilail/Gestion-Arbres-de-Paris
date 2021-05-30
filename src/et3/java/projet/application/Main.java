package et3.java.projet.application;


import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import entite.Entreprise;
import entite.Membre;
import entite.Personne;
import entite.President;
import asso.Association;
import asso.Facture;
import et3.java.projet.data.FileReader;
import municipalite.Arbre;
import municipalite.Mairie;
import municipalite.ServicesEspacesVerts;
import et3.java.projet.data.*;

public class Main 
{
	
	/*TEST*/
	public static void main(String[] args) 
	{	
		ArrayList<Arbre> listeArbres  = new ArrayList<Arbre>();;
		
		if(args.length > 0)
		{
			File tempFile = new File(args[0]);
			
			if(tempFile.exists())
			{
				System.out.println("[Main] Reading the file " + args[0] + " ...");
						
				//We start by reading the CSV file
				listeArbres  = FileReader.getDataFromCSVFile(args[0]);
				
				System.out.println("[Main] End of the file " + args[0] + ".");
			}
			else
			{
				System.out.println("[Main] No file " + args[0]);
			}
		}
		else
		{
			System.out.println("[Main] You should enter the CSV file path as a parameter.");
		}
		
		
		// Création des Organismes 
		
		Mairie mairie = new Mairie();
		mairie.setListeArbres(listeArbres);
		Association asso = new Association(mairie);
		ServicesEspacesVerts sev = new ServicesEspacesVerts(mairie);
		mairie.setSEV(sev);
		sev.ajoutNotifiable(asso);

	
		// Création des personnes et des membres  
		Personne p1 = new Personne("BENYAHIA","Bilail","Villepinte","14/07/2000", 440); 
		System.out.println(p1);
		Personne p2 = new Personne("MAX","Aurelien","Champlan","12/04/1990", 420); // Quelle jeunesse!
		System.out.println(p2);
		Personne p3 = new Personne("BRASIER","Eugenie","Paris","01/01/1995", 890); //Quelle jeunesse!
		System.out.println(p3);
		Personne p4 = new Personne("ALMEIDA","Natanael","Champlan","23/09/1999", 260); 
		System.out.println(p2);	
		Personne p5 = new Personne("DUPONT","Ludovic","Orsay","25/04/1989", 360); 
		System.out.println(p3);
		
		
		System.out.println("Avant inscription : ");
		System.out.println(asso.getListeMembres());
		Membre m1=asso.inscrire(p1);
		President pres= new President(p2,asso); //Aucun fayotage bien sûr..
		Membre m2=asso.inscrire(pres);
		Membre m3=asso.inscrire(p3);
		Membre m4=asso.inscrire(p4);
		Membre m5=asso.inscrire(p5);
		System.out.println("Après inscription : ");
		System.out.println(asso.getListeMembres());
		
		// Partie Finance 
		System.out.println("\n------Finance------\nle budget de l'asso est de : " + asso.getBudget().getSomme()); // On commence avec un budget de 0
		m1.Cotiser();
		m1.Cotiser(); // Un membre ne peut cotiser que une fois par an, la deuxième n'est donc pas prise en compte
		m2.Cotiser();
		m3.Cotiser();
		System.out.println("\n------------ Vue sur les cotisation de l'asso -------------"); 
		System.out.println("\n Cotisations de " + m1.getNom() + " : " + m1.getCotisationsAnnuelles()); 
		System.out.println("\n Cotisations de " + m2.getNom() + " : " + m2.getCotisationsAnnuelles()); 
		System.out.println("\n Cotisations de " + m3.getNom() + " : " + m3.getCotisationsAnnuelles()); 
		
		
		
		Facture f = new Facture(-50,"electrcite"); // Les factures sont des crédits, ils ont donc un montant négatif
		asso.effectuerTransaction(f);
		
		Facture l = new Facture(-250,"loyer"); // Le montant < au budget l'asso ne peut pas payer la facture
		asso.effectuerTransaction(l);
		
		Entreprise SKM = new Entreprise("SKM", 1000000);
		System.out.println("\n Test entreprise : --------\nsolde avant don : " + SKM.getNom()+ " : " + SKM.getCompte().getSolde());
		SKM.Donation(asso, 100);
		System.out.println("\solde après don : " + SKM.getNom()+ " : " + SKM.getCompte().getSolde());
		
		
		//Visites
		System.out.println("\n------------  Visites ------------ \n");
		Arbre arbre= asso.getArbresRemarquables().get(1);
		m2.plannifierVisite(arbre, new Date());  //On plannifie une visite instantannée
		m1.plannifierVisite(arbre, new Date());  //pas pris en compte car rentre en conflit avec la visite de m2
		System.out.println(asso.getVisitesPlannifiees());
		m2.effectuerVisite(m2.getProchaineVisite(), "joli petit arbre");
		m2.nominer(arbre); // pas pris en compte car arbre déja nominé
		m1.plannifierVisite(arbre, new Date());
		System.out.println(asso.getVisitesPlannifiees());

		//Les nominations 
		
		System.out.println("\n-------- Les Nominations --------");
		Arbre a1 = mairie.getListArbre().get(1);
		Arbre a2 = mairie.getListArbre().get(2);
		Arbre a3 = mairie.getListArbre().get(3);
		Arbre a4 = mairie.getListArbre().get(4);
		Arbre a5 = mairie.getListArbre().get(5);
		Arbre a6 = mairie.getListArbre().get(6);
				
		m1.nominer(a1); m1.nominer(a2); m1.nominer(a3) ; m1.nominer(a4); m1.nominer(a6);
		//System.out.println(m1.getPrenom() + " a nominé : " + m1.getNominations());
		m2.nominer(a2); m2.nominer(a3); m2.nominer(a5); 
		System.out.println(m1.getPrenom() + " a nominé : " + m1.getNominations());
		m3.nominer(a1); m3.nominer(a2); m3.nominer(a3); m3.nominer(a4); m3.nominer(a4);m3.nominer(a6); // Il nomine 6 arbres donc a1 est ignoré 
		System.out.println(m3.getPrenom() + " a nominé : " + m3.getNominations()); // de plus si une personne nomine 2 fois un même arbre, ce n'est pris en compte qu'une seule fois 
		
		/* NBr de nomination par arbres
		 * a1: 2 
		 * a2: 3
		 * a3: 3
		 * a4: 2
		 * a5: 1 
		 * a6: 2
		 * En cas d'égalité les arbres sont trié par ordre décroissant de circonférence
		 */ 
		
		//Abattage 
		Arbre a7 = mairie.getListArbre().get(7);
		System.out.println("----- Les abattages -----\n avant :" + mairie.getListArbre().get(7));
		
		sev.Abattre(a7);
		System.out.println("\napres : " + mairie.getListArbre().get(7) ); // l'arbre a bien été supprimé et remplacé
		System.out.println("L'arbre a bien été remplacé par l'arbre suivant dans la liste, il a donc bien été abbatu");
		
		
		// l'Exercice Budgetaire 
		System.out.println(asso.getBudget().getEBActuel());
		
		System.out.println("----- Envoie des demandes de Subvention -----");
		asso.demanderSubvention(SKM, "paiment de facture et agrandissement");
		
		System.out.println("les arbres nominé sont : ");
		for (Arbre a : asso.finExerciceBudgetaire()) {
			System.out.println(a);
		}
		System.out.println(asso.getListeMembres()); // les membres qui n'ont pas cotisé ont été radié
		System.out.println(asso.getBudget().getEBActuel());
		System.out.println("vérification si " + m4 + " est biand l'association : " + asso.getListeMembres().contains(m4)); //  retourne false elle a bien été radié
		 
		//Demande de subvention 
		System.out.println("----- Envoie des demandes de Subvention -----");
		asso.demanderSubvention(SKM, "achat nouveau batiment");
		
		
		};
		
		
	}

