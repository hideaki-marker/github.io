package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZipSarch {

	public static void main(String[] args) {
		
		String  input = "";

		Yubin yu = new Yubin();
		
		try (BufferedReader  br = new BufferedReader(new InputStreamReader(
				System.in));) {
			
			while (!input.equals("q")) {
				System.out.print("郵便番号を入力してください。 ： ");
				input = br.readLine();
				if(!input.equals("q")){
				yu.address(input);
				}
				
					//System.out.println("---郵便番号が不正です。---");
				

			} 

			
	}catch (IOException e) {
		System.out.println("郵便番号ファイルが存在しません。");
	}finally{
		System.out.println("終了します。");
	}
	}
	
}