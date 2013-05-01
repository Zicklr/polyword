package wordgraphic.bones.parsor;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import wordgraphic.bones.Arete;
import wordgraphic.bones.Graphe;
import wordgraphic.bones.Sommet;

public class DataParsor implements AutoCloseable {
	// Attributes
	private ArrayList<Sommet> noeuds;
	private final Scanner s;
	private DataRobot parseur;
	private int nbSommetsMax;
	
	/**
	 * @category Constructor
	 * @param file
	 * @throws IOException
	 * @author Lance
	 * @version 2013-03-21

	 */
	public DataParsor(Path file) throws IOException {
		noeuds = new ArrayList<>();
		s = new Scanner(file);
		parseur = new DataRobot(noeuds);
	}
	/**
	 * @category method
	 * @return
	 * @throws IOException
	 */
	public Graphe parse() throws IOException {
		return parseEverything(-1);
	}

	public Graphe parse(int max) throws IOException {
		if((max >= findNumberOfNodes()) || (max == 0)) {
			return parseEverything(-1);
		}
		return parseEverything(max);
	}

	private int findNumberOfNodes() {
		Pattern pattern = Pattern.compile(".*MAX NODE ID = (\\d+).*");
		while(s.hasNext()) {
			String line = s.nextLine();
			Matcher matcher = pattern.matcher(line);
			if(matcher.matches()) {
				int nbSommetsMax = Integer.parseInt(matcher.group(1));
				return nbSommetsMax;
			}
		}
		return 0;
	}

	private Graphe parseEverything(int max) throws IOException {
		Graphe g=null;
		System.out.println("Chargement des sommets ...");
		if(max != -1) {
			parseSommetslambda(max);
		} else {
			noeuds=parseSommets();
			System.out.println(noeuds.size()+" mots chargés.");
		}
		System.out.println("Chargement des aretes...");
		g = addNodesInGraph();
		g.setPoidsMax(parseAretes(g));
		System.out.println("Aretes chargées.");
		return g;
	}
	private void parseSommetslambda(int max) {
		Random randomizer = new Random();
		while(s.hasNext() && max != 0) {
			String line = s.nextLine();
			if(line.matches("^eid.*t=1.*") && (randomizer.nextInt(6) < 3)) {
				parseur.noeudParse(line);
			} else if(line.matches(".*RELATIONS$")) {
				return;
			}
		}
	}

	
	/** That function makes parsing of vertex's graph passed 
	 * and keep up an array of vertex which done success
	 * @see interface Handler
	 * @author Lance	  
	 * @return {@link ArrayList} Sommet
	 */
	private ArrayList<Sommet> parseSommets() {
		ArrayList<Sommet> somParses = new ArrayList<>();
		while(s.hasNext()) {
			String line = s.nextLine();
			if(line.matches("^eid.*t=1.*")) {
				Sommet som = parseur.noeudParse(line);
				if(som!=null) {
					somParses.add(som);
					System.out.println("Sommet label="+som.getMot()+"  id"+som.getId());
				}
			} else if(line.matches(".*RELATIONS$")) {
				break;
			}
		}
		return somParses;
	}
	/*** Chargement des aretes
	 * Notre graphe etant orienté et pondéré on se doit d'ajouter pour chaque arete deux aretes selon
	 * le sens de A vers B et de B vers A et bien tester que nos sommets de départ et d'arrivée sont bien différents 
	 *  ****/
	private int parseAretes(Graphe a){
		int poids_max = 0;
		while(s.hasNext()) {
			String line = s.nextLine();
			if(line.matches("^rid.*")) {
				Arete[] newAretes; 
				newAretes= parseur.relationParsee(noeuds,line);
				System.out.println(newAretes[0]);
				if(newAretes[0]!= null && (newAretes[0].getDestination()!=null && newAretes[0].getSource()!=null)) {
					a.addArete(newAretes[0]);
					a.addArete(newAretes[1]);
					poids_max+=2;
				}
			}
		}
		return poids_max;
	}
	
	@Override
	public void close() throws Exception {
		s.close();
	}
	public int getNbSommetsMax() {
		return nbSommetsMax;
	}
	public void setNbSommetsMax(int nbSommetsMax) {
		this.nbSommetsMax = nbSommetsMax;
	}
	private int findHighestId(ArrayList<Sommet> nodes) {
		int max = 0;
		for(Sommet n:noeuds) {
			if(n.getId()>max)
				max = n.getId();
		}
		return max;
	}
	private Graphe addNodesInGraph() {
		int size = findHighestId(noeuds);
		Graphe a = new Graphe(size+1);
		for(Sommet s:noeuds) {
			if(!(s.getId()>size))
				a.addSommet(s);
		}
		return a;
	}
	
	
}
