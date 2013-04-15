package wordgraphic.bones.parsor;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import wordgraphic.bones.Arete;
import wordgraphic.bones.Sommet;
import wordgraphic.bones.parsor.gestionnaireParsing.Handler;


	public class DataRobot implements Handler {
		private List<Sommet> noeuds;
		private  Pattern nodePattern, relationPattern;
		public Pattern getNodePattern() {
			return nodePattern;
		}

		public Pattern getRelationPattern() {
			return relationPattern;
		}

		public DataRobot(List<Sommet> noeuds) {
			this.noeuds=noeuds;
			nodePattern = Pattern.compile("eid=(\\d+)[|]n=[\"](.*)[\"][|]t=1[|]w=(\\d+)(|[|]nf=[\"](.*)[\"])");
			relationPattern = Pattern.compile("rid=(\\d+)[|]n1=(\\d+)[|]n2=(\\d+)[|]t=(\\d+)[|]w=(\\d+)");
		}
		
		public Sommet noeudParse(String mot) {
			Matcher m = nodePattern.matcher(mot);
			if(m.matches() && !"0".equals(m.group(1)) && !m.group(1).equals("0") && (Integer.parseInt(m.group(3))>=0)) {
				return new Sommet(Integer.parseInt(m.group(1)), m.group(2), 1, Integer.parseInt(m.group(3)));
			}
			return new Sommet(0,"",0,0);
		}
		
		public Arete[] relationParsee(List<Sommet> nodes, String d) {
			Matcher matcher = relationPattern.matcher(d);
			Arete[] arc = new Arete[2];
			arc[0] = new Arete(0, null,null,0,0.0);
			arc[1] = new Arete(0,null,null,0,0.0);
			noeuds=nodes;
			if( matcher.matches() && !(matcher.group(2).equals(matcher.group(3))) &&
					(Integer.parseInt(matcher.group(1))>=1) && (Double.parseDouble(matcher.group(5))>=0)
					&& (Integer.parseInt(matcher.group(2)) < noeuds.size()) && (Integer.parseInt(matcher.group(3)) < noeuds.size())) {

				arc[0] = new Arete(
						Integer.parseInt(matcher.group(1)), noeuds.get(Integer.parseInt(matcher.group(2))),
						noeuds.get(Integer.parseInt(matcher.group(3))), Integer.parseInt(matcher.group(4)),
						Double.parseDouble(matcher.group(5))
						);
				arc[1] = new Arete(
						Integer.parseInt(matcher.group(1)), noeuds.get(Integer.parseInt(matcher.group(3))),
						noeuds.get(Integer.parseInt(matcher.group(2))), Integer.parseInt(matcher.group(4)),
						Double.parseDouble(matcher.group(5))
						);	
			}
			else{
				System.out.println("Arc null"+arc[0]);
			}
			return arc;
			
		}
	}


