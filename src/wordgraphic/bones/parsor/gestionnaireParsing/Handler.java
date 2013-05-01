package wordgraphic.bones.parsor.gestionnaireParsing;
import java.util.List;

import wordgraphic.bones.Arete;
import wordgraphic.bones.Sommet;
import wordgraphic.bones.parsor.DataParsor;
import wordgraphic.bones.parsor.DataRobot;
/**
 * @see DataParsor {@link DataParsor}
 * {@link DataRobot}
 * @author Zicklr
 *@version 1
 */
public interface Handler {
	public Sommet noeudParse(String d);
	public Arete[] relationParsee(List<Sommet> nodes,String d);
}
