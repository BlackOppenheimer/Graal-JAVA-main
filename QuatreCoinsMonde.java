package graal;

public class QuatreCoinsMonde {
	//attribut 
	private Objet [][] carte;
	private static final int TAILLE = 10;
	
	//constructeurs
	public QuatreCoinsMonde() {
		this.carte = new Objet [TAILLE][TAILLE];
		Objet[] objet = new Objet [13];
		
		//On crée les 4 objets constituants le Graal
		Graal excalibur = new Graal ("Excalibur", 100, 5);
		Graal pierreDeFal = new Graal ("Pierre de Fal Lial", 80, 4);
		Graal lance = new Graal ("Lance de Lug", 40, 2);
		Graal chaudron = new Graal ("Chaudron de la Connaissance", 50, 3);
		//On crée les objets
		Obstacle roche1  = new Obstacle ("roche", -20);
		Obstacle roche2  = new Obstacle ("roche", -20);
		Obstacle puit1  = new Obstacle ("puit", -30);
		Obstacle puit2  = new Obstacle ("puit", -30);
		Obstacle ronce1  = new Obstacle ("ronce", -10);
		Obstacle ronce2  = new Obstacle ("ronce", -10);
		Obstacle pomme  = new Obstacle ("BonusDeVie", +20);
		Obstacle banana  = new Obstacle ("BonusDeVie", +30);
		Obstacle mangue  = new Obstacle ("BonusDeVie", +40);

		
		//On intègre les objets dans le tableau
		objet[0] = excalibur; objet[1] = pierreDeFal; objet[2] = lance;
		objet[3] = chaudron;
		
		objet[4] = roche1; objet[5] = roche2; objet[6] = puit1;
		objet[7] = puit2; objet[8] = ronce1; objet[9] = ronce2;
		objet[10] = pomme; objet[11] = banana; objet[12] = mangue;

		
		for (int i=0; i<objet.length ;i++) {
			int dx = (int)(Math.random()*10);
			int dy = (int)(Math.random()*10);
			int j = 0;
			while (carte[dx][dy] != null && j < 100) {
				dx = (int)(Math.random()*10);
				dy = (int)(Math.random()*10);
				j = j+1 ;
			}
			objet[i].place(dx, dy);
			carte [dx][dy]=objet[i];
		}
	}
	
	
	//méthodes
	
	public String affiche() {
		String res = "  0 1 2 3 4 5 6 7 8 9";
		for (int i = 0 ; i < TAILLE ; i ++){
			res = res + "\n" + i;
			for (int j = 0 ; j < TAILLE ; j++) {
				
				if (this.carte[i][j]==null) {
					res = res + " .";}
				else {
					switch (this.carte[i][j].getNom()) {
					case "Excalibur" : res = res + " E";
					break;
					case "Pierre de Fal Lial" : res = res + " P";
					break;
					case "Lance de Lug" : res = res + " L";
					break;
					case "Chaudron de la Connaissance" : res = res + " C";
					break;
					case "roche" : res = res + " r";
					break;
					case "puit" : res = res + " t";
					break;
					case "ronce" : res = res + " n";
					break;
					case "BonusDeVie" : res = res + " $";
					break;
					}}}}
		return res;
	}
	
	public String envoyer (Table table, Chevalier c) throws InterruptedException
	{
		
	    
		String res = "";
		int ndv = 0 ;
		System.out.println(this.affiche());
		c.place();
		int i = 0 ; 
		while (c.getSac().size() < 4 && c.getLvlvie() > 0) {
			if (this.carte[c.getX()][c.getY()] != null) {
				
				if (this.carte[c.getX()][c.getY()] instanceof Graal) {
					
					c.getSac().add(this.carte[c.getX()][c.getY()]);
					System.out.println(this.carte[c.getX()][c.getY()].toString());
					ndv = this.carte[c.getX()][c.getY()].getLvlvie();
					this.carte[c.getX()][c.getY()] = null;	
				}
				
				if (this.carte[c.getX()][c.getY()] != null) {
					
						System.out.println(this.carte[c.getX()][c.getY()].toString());
						ndv = this.carte[c.getX()][c.getY()].getLvlvie();
				}
				
				System.out.println(c.toString());
			}
			c.modifndv(ndv);
			i++;
			System.out.println("tour:" +i +"\n"+this.affiche());
			System.out.println(c.toString());
			
			c.bouge();
			ndv = 0;
			Thread.sleep(2000);
		}
		if (c.getLvlvie()<=0)
		{
			res = "Perdu, le chevalier a failli dans sa quete !";
			c.toString();
			table.expulser(c);
		}
		else if (c.getSac().size() == 4)
		{
			 res = "Gagné, le chevalier entre dans la legende !";
			 c.toString();
		}
		
		
		System.out.println(this.affiche());
		return res;
	}
}
	