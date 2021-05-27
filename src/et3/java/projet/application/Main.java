package et3.java.projet.application;


import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import Mairie.Arbre;
import Mairie.Municipalite;
import entite.Membre;
import entite.Personne;
import Asso.Association;

import et3.java.projet.data.FileReader;
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
		
		Municipalite mairie = new Municipalite();
		mairie.setListeArbres(listeArbres);
		Association asso = new Association(mairie);
		
		// Création des personnes et des membres  
		Personne p1 = new Personne("BENYAHIA","Bilail","Villepinte","14/07/2000", 440); 
		System.out.println(p1);	                                                                  																						  
		Personne p2 = new Personne("ALMEIDA","Natanael","Champlan","23/09/1999", 260); 
		System.out.println(p2);	
		Personne p3 = new Personne("DUPONT","Ludovic","Orsay","25/04/1989", 360); 
		System.out.println(p3);
		Personne p4 = new Personne("MILLARD","Manon","Champlan","12/04/1995", 420); 
		System.out.println(p4);
		Personne p5 = new Personne("BRASIER","Eugenie","Paris","01/01/1989", 890); 
		System.out.println(p5);
		
		System.out.println("Avant inscription : ");
		System.out.println(asso.getListeMembres());
		Membre m1=asso.inscrire(p1);
		Membre m2=asso.inscrire(p2);
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
		
		// Ajouter entrepise don
		
		
		//Visites
		System.out.println("\n------------  Visites ------------ \n");
		Arbre arbre= asso.getArbresRemarquables().get(1);
		m2.plannifierVisite(arbre, new Date());
		m1.plannifierVisite(arbre, new Date()); //pas pris en compte car rentre en conflit avec la vidite de m2
		System.out.println(asso.getVisitesPlannifiees());
		m2.effectuerVisite(m2.getProchaineVisite(), "joli petit arbre");
		m2.nominer(arbre);
		m1.plannifierVisite(arbre, new Date());
		System.out.println(asso.getVisitesPlannifiees());

				
		// l'Exercice Budgetaire 
		System.out.println(asso.getBudget().getEBActuel());
		
		asso.finExerciceBudgetaire(); 
		System.out.println(asso.getListeMembres());
		System.out.println(asso.getBudget().getEBActuel());
		System.out.println(m1);
		 
		};
		
		
	}

