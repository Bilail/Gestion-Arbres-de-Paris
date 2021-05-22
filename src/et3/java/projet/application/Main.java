package et3.java.projet.application;


import java.io.File;
import java.util.ArrayList;

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
		Municipalite Mairie = new Municipalite();
		Mairie.setListeArbres(listeArbres); 
		Association Asso = new Association();
		//System.out.println(Mairie.getListArbre());
		
		// Création des membre  
		Membre Bilail = new Membre(new Personne("BENYAHIA","Bilail","Villepinte","14/07/2000"),Asso); // si la fonction inscrire existe je ne vois pas l'utilité du constructeur membre ? 
		System.out.println(Bilail);
		Membre Natanael = new Membre(new Personne("ALMEIDA","Natanael","Paris","12/07/1999"),Asso); // dsl je ne connais pas ta date de naissance hihi ^^'
		System.out.println(Natanael);
		
		System.out.println("Avant inscription : ");
		System.out.println(Asso.getListMembre());
		Asso.inscrire(Bilail);
		Asso.inscrire(Natanael);
		System.out.println("Après inscription : ");
		System.out.println(Asso.getListMembre());
		
		// Partie Finance 
		System.out.println("\n------Finance------\nle budget de l'asso est de : " + Asso.getBudget().getSomme()); // On commence avec un budget de 0
		Bilail.Cotiser(100);
		Bilail.Cotiser(10);
		System.out.println("\nBilail cotise, le budget de l'asso est de : " + Asso.getBudget().getSomme());
		System.out.println("\nsur le compte de Bilail " + Bilail.getCotisationsAnnuelles());
		
			// l'Exercice Budgetaire 
		//System.out.println(Asso.getBudget().getEBActuel()); // Il faut revoie le EBactuel il y a un pb
		
		};
		
		
	}

