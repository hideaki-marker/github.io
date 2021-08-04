package chap07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Ex05 {

	public static void main(String[] args) {
		HashMap hm = new HashMap();
		hm.put("エベレスト",8848);
		hm.put("モンブラン",5642);
		hm.put("マッキンリー",6194);
		hm.put("アコンカグア",6959);
		hm.put("キリマンジャロ",5895);
		hm.put("コジオスコ",2228);
		hm.put("ヴィンソン・マシフ",4892);
		
		
		
		System.out.println("//世界7大陸最高峰の標高を表示する辞書//");
		System.out.println();
		System.out.println("//山の名前//");
		System.out.println("「エベレスト」「モンブラン」「マッキンリー」\r\n「アコンカグア」「キリマンジャロ」「コジオスコ」「ヴィンソン・マシフ」");
		System.out.println();
		try (BufferedReader br = new BufferedReader
				(new InputStreamReader(System.in));) {
			String mt;
			System.out.print("■山の名前を入力してください(全角カタカナ) :");
			mt = br.readLine();
			
			if(hm.get(mt) == null) {
				System.out.println("そのような山は登録されていません :" + mt);
			}else {
				System.out.println(mt + "の標高は、" + hm.get(mt) + "mです。");
			}
		}catch (IOException e) {
			System.out.println("入力エラーが発生しました。");
		} 
	}

}
