package similarity;

import edu.cmu.lti.jawjaw.pobj.POS;
import edu.cmu.lti.jawjaw.pobj.Synset;
import edu.cmu.lti.jawjaw.util.WordNetUtil;
import edu.cmu.lti.lexical_db.ILexicalDatabase;
import edu.cmu.lti.lexical_db.NictWordNet;
import edu.cmu.lti.lexical_db.data.Concept;
import edu.cmu.lti.ws4j.Relatedness;
import edu.cmu.lti.ws4j.RelatednessCalculator;
import edu.cmu.lti.ws4j.impl.*;
import edu.cmu.lti.ws4j.util.WS4JConfiguration;

import java.util.ArrayList;
import java.util.List;


public class CalSimilarity {

	public CalSimilarity() {
		// TODO Auto-generated constructor stub
	}
	
	private static ILexicalDatabase db = new NictWordNet();
	private static RelatednessCalculator[] rcs = {
			new HirstStOnge(db), new LeacockChodorow(db), new Lesk(db),  new WuPalmer(db), 
			new Resnik(db), new JiangConrath(db), new Lin(db), new Path(db)
			};
	private static List<Concept> toSynsets( String word, String posText ) {
		POS pos2 = POS.valueOf(posText); 
		List<Synset> synsets = WordNetUtil.wordToSynsets(word, pos2);
		List<Concept> concepts = new ArrayList<Concept>(synsets.size());
		for ( Synset synset : synsets ) {
			concepts.add( new Concept(synset.getSynset(), POS.valueOf(posText)) );
		}
		return concepts;
	}
	//private static void run( Concept synsets1, Concept synsets2 ) {
	//	WS4JConfiguration.getInstance().setMFS(true);
	//	for ( RelatednessCalculator rc : rcs ) {
	//		double s = rc.calcRelatednessOfSynset(synsets1,synsets2).getScore();
	//		System.out.println(rc.getClass().getName()+"\t"+s);
	//	}
	//}
	
	public static double computeSimilarity(String word1,String word2, int index){
		String[] w1 = word1.split("\\.");
		//System.out.println(w1[0]+" "+w1[1]+" "+Integer.parseInt(w1[2]));
		String[] w2 = word2.split("\\.");
		//System.out.println(w2[0]+" "+w2[1]+" "+Integer.parseInt(w2[2]));
		if(w1.length<3){
			return 0;
		}
		if(w2.length<3){
			return 0;
		}
		String wsense1 = w1[0];
		for(int i = 1;i<w1.length-2;i++){
			wsense1 = wsense1+"."+w1[i];
		}
		//System.out.println(wsense1);
		String wsense2 = w2[0];
		for(int i = 1;i<w2.length-2;i++){
			wsense2 = wsense2+"."+w2[i];
		}
		//System.out.println(wsense2);
		Concept concept1 =toSynsets(wsense1, w1[w1.length-2]).get(Integer.parseInt(w1[w1.length-1])-1);
		Concept concept2 =toSynsets(wsense2, w2[w2.length-2]).get(Integer.parseInt(w2[w2.length-1])-1);
		WS4JConfiguration.getInstance().setMFS(true);
		Relatedness relatedness = rcs[index-1].calcRelatednessOfSynset(concept1, concept2);
		double score = relatedness.getScore();
		return score;
	}
	
	public static void main(String[] args) {
		String aString ="dog.n.1";
		String bString = "animal.n.1";
		System.out.println(computeSimilarity(aString, bString, 4));
	}
}
