package wordgraphic.main;
import java.io.IOException;
import java.nio.file.Paths;
import wordgraphic.bones.Graphe;
import wordgraphic.bones.parsor.DataParsor;

public class Main {
	/**
	 * @param String s, int max
	 * @author Zicklr
	 * @see Graphe
	 * @return Graphe
	 * @since 15-03-2013
	 */
	private static Graphe loadGraph(String s, int max) throws IOException {
		DataParsor parser = new DataParsor(Paths.get(s));
		Graphe graphe = null;
		if(max == -1) {
			graphe = new Graphe(parser.parse());
		} else {
			graphe = new Graphe(parser.parse(max));
		}
		try {
			parser.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Fichier charg� � 100%.");
		return graphe;
	}
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/****
		 * Ici , il s'agira de mettre en place une application avec vue m�tier :
		 * On aura donc un graphe � partir d'un fichier texte C:\Users\Lance\Desktop\projets\polyword/jeuxdemots.txt.
		 * Charger les noeuds et les aretes;
		 */
			System.out.println("<<<<<<<<<<<<<< Polys�mie sur jeux de mots >>>>>>>>>>>>>>>>");
			Graphe graphe ;
			int id = 448;
			if(args.length == 0) {
				System.out.println("Veuiller fournir en argument un fichier de jeuxdemots.org ");
			}
			else{
				graphe = loadGraph(args[0],-1);
				System.out.println("Calcul des voisins des sommets");
				
				/***
				 * A l'aide du graphe charg� on va essayer de calculer le voisinage de ce graphe , c'est - �-dire 
				 * trouver toutes les aretes adjacentes dans la mesure du possible � ce graphe 
				 * et donc la liste des sommets voisins
				 * situes � un pas de distance de ce sommet
				 */
				graphe.locateNeighbour(id);
			}
			


	}

}
