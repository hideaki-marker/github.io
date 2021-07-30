package chap07;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sample14_MS932 {

	public static void main(String[] args) {
		BufferedReader br = null;
		String rec = null;
		String[] str = null;
		try{
			//br = new BufferedReader(new FileReader("FileCSV_MS932.csv"));
			br = new BufferedReader(new InputStreamReader
							(new FileInputStream("FileCSV_MS932.csv"),"MS932"));
			while((rec = br.readLine()) != null){
				//1行読み込んだ文字列をコンマで区切って文字列の配列で返す
				str = rec.split(",");
				for(String s : str){
					System.out.print(s + " "); //配列を全て表示
				}
				System.out.println();
			}
		}catch(FileNotFoundException e){
		}catch(IOException ee){
		}finally{
			try{
				if(br != null) br.close();
			}catch(IOException e){ }
		}
	}
}
