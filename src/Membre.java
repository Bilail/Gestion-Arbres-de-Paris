import java.util.ArrayList;
import java.util.Date;

public class Membre extends Personne {
	
	private Date DateInscription;
	private Association association;
	private ArrayList<Float> CotisationsAnnuelles;
	
	Membre(String nom, String prenom){
		super(nom, prenom);
	}
	
	private void Quitter() {
		association.Revoquer(this);
	}
}
