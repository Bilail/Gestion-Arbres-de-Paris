package entite;

import asso.Association;

public class President extends Membre {
	
	private final boolean CmoiLePatrooooon;
	
	/**
	 * Constructeur du président
	 * @param p une personne 
	 * @param association l'association
	 */
	public President(Personne p, Association association) {
		super(p,association);
		CmoiLePatrooooon=true;
	}


}
