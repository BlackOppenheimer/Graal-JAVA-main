package graal;

import in.keyboard.Keyboard;

public class Main {

		private static void affiche_menu() {
		System.out.println("------------------------------------------------\n"+
		"BIENVENUE DANS LA QUETE DU GRAAL CHEVALIER !\n"+
				"1- Creer un chevaliers\n"+
				"2- Expulser un chevalier \n"+
				"3- Afficher les membres de la Table Ronde\n"+
				"4- Commencer la quete\n"+
				"5- Quitter la quete du Graal\n"+
				"------------------------------------------------");	
		
	}
	
		private static boolean traitement_choix(int choix, boolean fini, Table tableronde) throws InterruptedException {
			switch (choix)
			{
			case 1 :
				String nomChevalier = new String();
				System.out.println("Entrez le nom de votre chevalier : ");
				nomChevalier = Keyboard.getString();
				Chevalier nouveauChevalier = new Chevalier(nomChevalier);
				tableronde.ajouter(nouveauChevalier);
				break;
			case  2 :
				System.out.println(tableronde.toString()+"\n");
				System.out.println("Choisissez le chevalier a expulser : " );
				String chevaliersuppr = Keyboard.getString();
				Chevalier t = tableronde.chercher(chevaliersuppr);
				if (tableronde.getTable().contains(t)){
					tableronde.expulser(tableronde.getTable().indexOf(t));
				}
				break;
			case 3 :
				if(! tableronde.isEmpty() ) {
					System.out.println(tableronde.toString());
				}
				else{
					System.out.println("Il n'y a aucun chevalier dans La table ronde ! " );
				}
				break;
			case 4:
				QuatreCoinsMonde carte = new QuatreCoinsMonde();
				//On demande le nom du chevalier à envoyer
				System.out.println("Entrez le nom du chevalier que vous souhaitez envoyé en quete du Graal: ");
				String nom = Keyboard.getString();
			    //On récupère le chevalier et initialise les variables
			    Chevalier c = tableronde.chercher (nom);
			    if (tableronde.getTable().contains(c)) {
					System.out.println(carte.affiche());
					System.out.println(carte.envoyer(tableronde,c));
			}
			break;
			case 5: 
				fini = true;
				break;
				
				
			}
			
			return fini;				
			
		}
	
	
	
	public static void main(String[] args) throws InterruptedException {
			
		
		
			Table tableronde = new Table();
			boolean fini = false;
			int choix;
			while(fini == false){
				affiche_menu();
				choix = Keyboard.getInt();
				fini = traitement_choix(choix,fini,tableronde);
				
			}



		}














	}


