package chap05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZipSearch_A {
	public static void main(String[] args) {
		String postcode ="";
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			while(!(postcode.equals("q"))){
				System.out.print("郵便番号を入力して下さい：");
				postcode = br.readLine();
				if(!(postcode.equals("q"))){
					Yubin_A yub = Yubin_A.getYubin(postcode);
					if(yub == null){
						System.out.println("郵便番号:" + postcode + "に該当する住所はありません");
					}else{
						System.out.println("郵便番号:"+yub.getPostcode()+ " " + yub.getTodo()+ " " + yub.getShi() + " " + yub.getCho());

					}
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			System.out.println("終了します。");
		}
	}

}
