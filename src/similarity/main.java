package similarity;

import java.io.IOException;
import java.util.ArrayList;

public class main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		CalSimilarity calSimilarity = new CalSimilarity();
		File file = new File();
//		String InputFileName = args[0];
//		String OutputFileName = args[1];
		String InputFileName = "objectwordsnew.txt";
		String OutputFileName = "so1.txt";
		String OutputNotInWordnetName = "notInWordNet.txt";
		file.readFile(InputFileName);
		ArrayList<String> RList = new ArrayList<String>();
		for(int i=0;i<file.RelationList.size();i++){
			String lexicon_String = file.RelationList.get(i);
			RList.add(lexicon_String);
		}
		
		int startline = 0;
		int endline = 2000;
//		startline = Integer.parseInt(args[2]);
//		endline = Integer.parseInt(args[3]);
		System.out.println(startline+" "+endline);
		int end = 0;
		for(int i=startline;i<endline;i++){
			String lexicon_iString = RList.get(i);
			for(int j=i+1;j<RList.size();j++){
				String lexicon_jString = RList.get(j);
				double similarity = calSimilarity.computeSimilarity(lexicon_iString, lexicon_jString, 4);
				//System.out.println(lexicon_iString+";"+lexicon_jString+";"+similarity);
				String content = lexicon_iString+";"+lexicon_jString+";"+similarity+"\n";
				file.writeFile(OutputFileName,content);
			}
			end = i;
		}
		System.out.println("end : "+end);
	}
}