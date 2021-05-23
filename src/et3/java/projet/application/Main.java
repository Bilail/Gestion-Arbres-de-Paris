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
		//System.out.println(Mairie.getListArbre());
		
		// Création des membre  
		Personne p1 = new Personne("BENYAHIA","Bilail","Villepinte","14/07/2000"); // si la fonction inscrire existe je ne vois pas l'utilité du constructeur membre ? 
		System.out.println(p1);	                                                                  // justement inscrire utilise le contructeur de membre puis ajoute ce membre à la liste des membres de l'asso
																									  // donc il faut créer une personne puis le fait de l'inscrire va créer un membre.
		Personne p2 = new Personne("ALMEIDA","Natanael","Champlan","23/09/1999"); // dsl je ne connais pas ta date de naissance hihi ^^'
		System.out.println(p2);																//j'ai fait la modif :p
		
		System.out.println("Avant inscription : ");
		System.out.println(asso.getListMembre());
		Membre m1=asso.inscrire(p1);
		Membre m2=asso.inscrire(p2);
		System.out.println("Après inscription : ");
		System.out.println(asso.getListMembre());
		
		//Visites
		
		Arbre arbre= asso.getArbresRemarquables().get(1);
		m2.plannifierVisite(arbre, new Date());
		System.out.println(asso.getVisitesPlannifiees());
		//m2.effectuerVisite(null, null) // faut que je termine de tester les visites j'ai encore 2/3 modifs à faire
		
		// Partie Finance 
		System.out.println("\n------Finance------\nle budget de l'asso est de : " + asso.getBudget().getSomme()); // On commence avec un budget de 0
		m1.Cotiser(100);
		m1.Cotiser(10);
		System.out.println("\nBilail cotise, le budget de l'asso est de : " + asso.getBudget().getSomme());
		System.out.println("\nsur le compte de Bilail " + m1.getCotisationsAnnuelles()); // j'aurais plutot di "Cotisation de Bilail:"
		
			// l'Exercice Budgetaire 
		System.out.println(asso.getBudget().getEBActuel()); 
		};
		
		
	}

