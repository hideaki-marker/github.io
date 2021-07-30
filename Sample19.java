package chap07;

import java.util.Scanner;

public class Sample19 {
	public static void main(String[] args){
		String str = "one two three four five";
		try(Scanner sc = new Scanner(str)){ //try（）内でScannerを生成
			while(sc.hasNext()){ //ScannerクラスのhasNext()メソッド
				System.out.println(sc.next()); //next()メソッドを使い文字を分割
			}
		}
	}
}
