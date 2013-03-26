package wordgraphic;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/****
		 * Ici , il s'agira de mettre en place une application avec vue m�tier :
		 * On commence par dire que l'on va charger les deux listes de 10 mots chacun
		 * On aura donc deux graphes � charger sous forme de fichiers texte.
		 * Ce qui implique de parser les deux fichiers et de stocker ce qu'on va lire dans des fichiers   
		 */
			System.out.println("<<<<<<<<<<<<<< Polys�mie sur jeux de mots >>>>>>>>>>>>>>>>");
			/**** 
			 * Lecture des deux fichiers et chargement dans les graphes par l'interm�diaire des m�thodes:
			 * readFile()
			 * loadListeMots() 
			 */
			Liste<Sommet> L1 = GrapheOrientePondere.loadListeMotsPolysemiques("jeuxdemots.txt");
			Liste<Sommet> L2 = GrapheOrientePondere.loadListeMotsNonPolysemiques("jeuxdemots.txt");
			L1.toString();
			L2.toString();
	}

}
