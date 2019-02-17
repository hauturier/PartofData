package data.transdealdata;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//        FileRW fileRW = new FileRW();
//        int n1 = 4;
//        for(int i = 1;i<=n1;i++){
//        	fileRW.readfile("similaritysensen/ss"+String.valueOf(i)+".txt");
//        }
//        
//        int n2 = 5;
//        for(int i = 1;i<=n2;i++){
//        	fileRW.readfile("similaritysensen/so"+String.valueOf(i)+".txt");
//        }
		FileRW fileRW = new FileRW();
		fileRW.readfile("trainnewSense.txt");
		
	}
}
