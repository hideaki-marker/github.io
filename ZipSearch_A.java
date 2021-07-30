package chap07;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * コンソールから入力した郵便番号に対応する住所を表示する。
 */
public class ZipSearch_A {

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader
				(new InputStreamReader(System.in));) {
			String yuubin;
			do {
				System.out.print("郵便番号を入力してください（qで終了） ： ");
				yuubin = br.readLine();
				if (!yuubin.equals("q")) {
					String address = getAddress(yuubin);
					System.out.println("〒" + yuubin + " : " + address);
				}
			} while (!yuubin.equals("q"));
		} catch (FileNotFoundException e) {
			System.out.println("郵便番号ファイルが存在しません。");
		} catch (IOException e) {
			System.out.println("入力エラーが発生しました。");
		} catch (Exception e) {
			System.out.println("エラーが発生しました。");
		}
		System.out.println("終了します。");
	}
	/*
	 * 引数の郵便番号に該当する住所情報を郵便番号ファイルより取得し戻す。
	 */
	public static String getAddress(String yuubin) throws IOException {
		String address = "該当する住所はありません。";
		// 郵便番号ファイルのオープン
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream("01HOKKAI.CSV"), "MS932"));) {
			String rec = "";
			// ファイルのデータを読み込む
			while ((rec = br.readLine()) != null) {
				rec = rec.replace("\"", "");
				String[] recArr = rec.split(","); // １行を要素単位に分割
				String y_no = recArr[2];
				if (yuubin.equals(y_no)) {
					// ダブルクォーテーションを除いた値を格納
					String todofuken = recArr[6];
					String shikuchoson = recArr[7];
					String choiki = recArr[8];
					// 住所情報の編集
					address = todofuken + shikuchoson + choiki;
					break;
				}
			}
			return address;
		}
	}
}
