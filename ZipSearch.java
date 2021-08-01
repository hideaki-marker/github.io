package chap07;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ZipSearch {
	static String yuubin;

	public static void main(String[] args) throws FileNotFoundException, IOException {

		try (Scanner bf = new Scanner(System.in)) {//入力の為、Scannerのオープン

			do {
				System.out.println("「郵便番号を入力してください(qで終了)　：」");
				yuubin = bf.next();//郵便番号の入力
				if (yuubin.equals("q")) {//qが入力された場合、終了
					System.out.println("終了します。");
				} else if (!yuubin.equals("q")) {//q以外の入力
					adress();

				}
			} while (!yuubin.equals("q"));
		} catch (Exception e) {
			System.out.println("エラーが発生しました。");
		}
		//adress();

	}

	static void adress() throws IOException {//住所の呼び出しメソッド
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream("01HOKKAI.CSV"), "MS932"))) {

			String rec = "";//ファイルの読み込み用変数

			while ((rec = br.readLine()) != null) {//ファイルの読み込み
				rec = rec.replace("\"", "");//ダブルクォーテーションの取外し
				String[] str = rec.split(",");//カンマで区切り、配列へ代入
				String y_no = str[2];//ファイルから郵便番号を取り出して変数に代入
				if (yuubin.equals(y_no)) {//入力された番号と合致した場合
					System.out.println("〒" + y_no + str[6] + str[7] + str[8] + " ");

				} else {//違った場合
					int next = Integer.parseInt(yuubin);//int型に変換し、1足してString型に戻す
					next += 1;
					yuubin = String.valueOf(next);

					System.out.println(0 + yuubin);
					if (yuubin.equals(y_no)) {//1足した番号と合致する番号があったなら表示
						System.out.println("〒" + y_no + str[6] + str[7] + str[8] + " ");
					} else {//無ければ・・・
						System.out.println("該当なし");
					}

				}

			}

		}
	}

}
