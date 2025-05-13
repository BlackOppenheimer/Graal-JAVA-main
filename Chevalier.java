package graal;

import java.util.ArrayList;

public class Chevalier {
	//attributs
	private String nom;
	private int lvlvie ;
	private ArrayList <Objet> sac;
	private int x ; 				//coordonnée x de l'emplacement du chevalier
	private int y ; 				//coordonnée y de l'emplacement du chevalier
	
	
	//constructeurs
	public Chevalier (String nom) {
		this.nom=nom;
		setLvlvie((int) (Math.random()*101));
		setSac(new ArrayList <Objet>());
	}


	public String getNom() {
		String nom = this.nom;
		return nom;
	}	
	
	//méthodes
	public String toString() {
		return "Nom : " + nom + "\n Niveau de vie : " + getLvlvie() + "\n Sac : " + getSac()
				+ "\n Position : " + "x : " + x + ", y : " + y;
	}
	
	public void place () {
		this.setX((int)(Math.random()*10));
		this.setY((int)(Math.random()*10));
	}
	
	public void modifndv(int ndvobjet) {
		int poids = 0;
		for (int i = 0; i< this.sac.size(); i ++) {
			poids = poids + this.sac.get(i).getPoids();
		}
		this.lvlvie = this.lvlvie + ndvobjet - poids;
		if (this.lvlvie > 100){
			this.lvlvie = 100;
		}
	}
	
	public void bouge() {
		int dx = (int)(Math.random()*3)-1;
		int dy = (int)(Math.random()*3)-1;
		int i = 0;
		while ((dx == 0 && dy == 0) && i < 100) {
			dx = (int)(Math.random()*3)-1;
			dy = (int)(Math.random()*3)-1;
			i = i++;
		}
		//On change les coordonnées
		this.x = this.x + dx ;
		this.y = this.y + dy ;
		// On prends les cas si x = 0 ou 9 ou y = 0 ou 9
		switch (x) {
		case -1 : this.x = 9;
		break;
		case 10 : this.x = 0;
		break;
		}
		switch (y) {
		case -1 : this.y = 9;
		break;
		case 10 : this.y = 0;
		break;
		}
		
	}


	public int getLvlvie() {
		return lvlvie;
	}


	public void setLvlvie(int lvlvie) {
		this.lvlvie = lvlvie;
	}


	public ArrayList <Objet> getSac() {
		return sac;
	}


	public void setSac(ArrayList <Objet> sac) {
		this.sac = sac;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	
}