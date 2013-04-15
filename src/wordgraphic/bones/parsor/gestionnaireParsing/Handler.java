package wordgraphic.bones.parsor.gestionnaireParsing;
import java.util.List;

import wordgraphic.bones.Arete;
import wordgraphic.bones.Sommet;

public interface Handler {
	public Sommet noeudParse(String d);
	public Arete[] relationParsee(List<Sommet> nodes,String d);
}
