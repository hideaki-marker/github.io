package practis;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class Takarakuji {

	public static void main(String[] args) {
		long money = 0;
		/*int kuji = 0;
		while(kuji != 1) {
			kuji = (int)(Math.random()*9999999) + 1;
			System.out.println(kuji);
			money -= 300;
			
		}
		System.out.println("おめでとうございます！！1等当選しました！！");
		System.out.println(money);*/
		Locale df = Locale.getDefault();//ロケールのオブジェクトの作成
		NumberFormat jp = NumberFormat.getCurrencyInstance(df);//通貨フォーマットのオブジェクトの作成
		
		ArrayList<Integer> kuji2 = new ArrayList<Integer>();//クジを格納する変数
		for(int i = 0; i <= 10000000;i++) {
			kuji2.add(i);//クジの格納
		}
		
		Collections.shuffle(kuji2);//順番を並び替える
		
		for(int value : kuji2) {//int型の拡張for文にする
			System.out.println(value);
			money -= 300;//1枚300円とする
			if(value == 1) {//もし1等が引けたなら
				System.out.println("おめでとうございます！！1等当選しました！！");
				break;
			}
		}
		System.out.println("使った金額は「" + jp.format(money) + "円」");//当選までに使った金額
		
		
	}

}
