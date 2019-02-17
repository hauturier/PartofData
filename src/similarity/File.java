package similarity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class File {
	String InputFileName;
	String OutputFileName;
	ArrayList<String> RelationList; 
    public File() {
		// TODO Auto-generated constructor stub
    	RelationList = null;
	}
    
	public void readFile(String InputFile) throws IOException{
		RelationList = new ArrayList<String>();
		FileInputStream fis=new FileInputStream(InputFile);
	    InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
	    BufferedReader br = new BufferedReader(isr);
	    
	    String line="";
	    String[] arrs = null;
	    while ((line=br.readLine())!=null) {
	        arrs=line.split("\t");
	        if(arrs.length==0||arrs[0].equals("")){
	        	continue;
	        }
	        String lexicon_String = arrs[0];
	        //System.out.println(arrs[0]);
	        RelationList.add(lexicon_String);
	    }
	    br.close();
	    isr.close();
	    fis.close();
	}
    
	public void writeFile(String OutputFile,String content) throws IOException{
		if(null == RelationList){
			System.out.println("file not read");
			return ;
		}
		FileWriter writer = new FileWriter(OutputFile,true);
        writer.write(content);
        writer.close();
	}
    
}
