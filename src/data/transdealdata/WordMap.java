package data.transdealdata;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class WordMap {
	
	HashMap<String,String> wordmap;
	public WordMap() {
		// TODO Auto-generated constructor stub
		wordmap = new HashMap<>();
		
	}

	public void readfile(String fileName) throws IOException{
		FileInputStream fis=new FileInputStream(fileName);
	    InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
	    BufferedReader br = new BufferedReader(isr);
	    String line="";
	    String[] arrs = null;
	    int i = 0;
	    while ((line=br.readLine())!=null) {
	        arrs=line.split("\t");
	        if(arrs.length<1||arrs[0].equals("")){
	        	continue;
	        } 
	        writeappend("entity2id.txt",arrs[0]+"\t"+i+"\n");
	        i++;
	    }
	    br.close();
	    isr.close();
	    fis.close();
	    
	    System.out.println(wordmap.size());
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
