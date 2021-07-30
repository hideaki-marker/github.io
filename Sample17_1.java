package chap07;

import java.util.Scanner;

public class Sample17_1 {

	public static void main(String[] args) {

		// Scannerの宣言
		Scanner sc = new Scanner("1,a,true,あ,3.14");
		// 区切り文字設定
		sc.useDelimiter(",");
		/*
		 * CSVファイルを","で区切り読み込む
		 */
		while (sc.hasNext()) {
			if (sc.hasNextInt()) {// int型か確認している。
				System.out.println("int型 : " + (sc.nextInt() * 10));
			} else if (sc.hasNextDouble()) {// double型か確認している。
				System.out.println("double型 : " + (sc.nextDouble() * 10));
			} else if (sc.hasNextBoolean()) {// boolean型か確認している。
				System.out.println("boolean型 : " + sc.nextBoolean());
			} else {
				System.out.println("その他 : " + sc.next());
			}
		}
		sc.close();

	}

}
