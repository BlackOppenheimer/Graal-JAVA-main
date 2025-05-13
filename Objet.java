package graal;

public class Objet {
	//attributs
	private String nom;
	private int lvlvie ;
	private int x ; 				//coordonnée x de l'emplacement du chevalier
	private int y ;
	private int poids;
	
	//constructeurs
	public Objet (String nom, int lvlvie) {
		this.setNom(nom); 
		this.setLvlvie(lvlvie);
	}

	
	//méthodes
	public String toString () {
		String res = "Nom : " + nom + " \n Niveau de vie : " + lvlvie; 
		return res;
	}
	
	public void place(int dx, int dy) {
		x = dx;
		y = dy;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getPoids() {
		return poids;
	}


	public void setPoids(int poids) {
		this.poids = poids;
	}


	public int getLvlvie() {
		return lvlvie;
	}


	public void setLvlvie(int lvlvie) {
		this.lvlvie = lvlvie;
	}

}
