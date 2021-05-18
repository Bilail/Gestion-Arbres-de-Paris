package et3.java.projet.application;


import java.io.File;
import java.util.ArrayList;

import Mairie.Arbre;
import Mairie.Municipalite;
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
		System.out.println(Mairie.getListArbre());
		
		
	}
}
