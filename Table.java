package graal;

import java.util.ArrayList;

public class Table {
	//attributs
	private ArrayList <Chevalier> table ;
	
	/**
	 * Constructeur
	 */
	public Table () {
		table = new ArrayList <Chevalier>();
	}
	
	//méthodes
	//Getteurs
	
	public ArrayList<Chevalier> getTable(){
		return this.table;
	}
	
	//methode pour ajouter un chevalier
	public void ajouter (Chevalier chevalier) {
//		boolean estDedans = false ;
//		int i = 0;
//		while (i < table.size() && ! estDedans) {
//			estDedans = m.equals(table.get(i));
//			i++;
//		}
//		if (! estDedans) {
//			table.add(m);	
//		}
		
		this.table.add(chevalier);
	}
	//to string 
	public String toString () {
		String chaine = " La table ronde : \n";
		for(int i =0 ; i<table.size();i++){
			chaine = chaine + i +") Nom : " + table.get(i).getNom() +"\n" +
		"Sac: " + table.get(i).getSac().toString() +"\n" +
		"PV : " + table.get(i).getLvlvie() + " \n" ;
		}
		return chaine;
	}
	
	// Les différentes methodes pour expulser un chevalier 
	public void expulser (int i){
		table.remove(i);
	}
	
	public void expulser (Chevalier chevalier) {
//		boolean estDedans = false ;
//		int i = 0;
//		while (i < table.size() && ! estDedans) {
//			estDedans = m.equals(table.get(i));
//			if (! estDedans) {
//			i++;}
//		}
//		if (estDedans) {
//			table.remove(i);
//		}
		this.table.remove(chevalier);
	}
	//Methode pour rechercher un chevalier 
	
	public Chevalier chercher (String nom) {
		Chevalier m;
		boolean estDedans = false ;
		int i = 0;
		while (i < table.size() && ! estDedans && (table.get(i).getNom() != nom)) {
			estDedans = nom.equals(table.get(i).getNom());
			i++;
		}
		if (! estDedans) {
			System.out.println("Le chevalier ne fait pas partie de la table ronde");
			return null;
		}
		m = table.get(i-1);
		return m;
	}

	public boolean isEmpty() {
		
		return this.table.isEmpty();
	}
	
}
