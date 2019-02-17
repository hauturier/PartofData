package data.transdealdata;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class FileRW {
	
	HashMap<String,String> wordmap;
	public FileRW() {
		// TODO Auto-generated constructor stub
		wordmap = new HashMap<>();
		
	}

	public void readfile(String fileName) throws IOException{
		FileInputStream fis=new FileInputStream(fileName);
	    InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
	    BufferedReader br = new BufferedReader(isr);
//        WordMap wordmap = new WordMap();
//        wordmap.readfile("wordsnew.txt");
	    String line="";
	    String[] arrs = null;
        String[] relations = {"_animal_part_of", "_plant_part_of", "_artifact_part_of", "_located_in_part_of"};
        System.out.println(relations[1]);
	    while ((line=br.readLine())!=null) {
	        arrs=line.split("\t");
	        if(arrs.length<3||arrs[0].equals("")){
	        	continue;
	        } 
//	        wordmap.put(arrs[0],String.valueOf(i));
//	        i = i+1;
	        
	        int relation = Integer.parseInt(arrs[2]);
	        relation = relation - 1;
	        System.out.println(relations[relation]);
	        writeappend("train.txt",arrs[0]+"\t"+arrs[1]+"\t"+relations[relation]+"\n");
	    }
	    br.close();
	    isr.close();
	    fis.close();
	    
	    System.out.println(fileName+" read0 end");
	}

	public void writeappend(String fileName, String content) {
        try {
            //
        	  FileOutputStream fos = new FileOutputStream(fileName,true); 
              OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8"); 
              osw.write(content); 
              osw.flush(); 
        } catch (IOException e) {
            e.printStackTrace();   
        }
    }
}
