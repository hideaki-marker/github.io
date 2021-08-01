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

		try (Scanner bf = new Scanner(System.in)) {

			do {
				System.out.println("「郵便番号を入力してください(qで終了)　：」");
				yuubin = bf.next();
				if (yuubin.equals("q")) {
					System.out.println("終了します。");
				} else if (!yuubin.equals("q")) {
					adress();

				}
			} while (!yuubin.equals("q"));
		} catch (Exception e) {
			System.out.println("エラーが発生しました。");
		}
		//adress();

	}

	static void adress() throws IOException {
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream("01HOKKAI.CSV"), "MS932"))) {

			String rec = "";

			while ((rec = br.readLine()) != null) {
				rec = rec.replace("\"", "");
				String[] str = rec.split(",");
				String y_no = str[2];
				if (yuubin.equals(y_no)) {
					System.out.println("〒" + y_no + str[6] + str[7] + str[8] + " ");

				} else {
					int next = Integer.parseInt(yuubin);
					next += 1;
					yuubin = String.valueOf(next);

					System.out.println(0 + yuubin);
					if (yuubin.equals(y_no)) {
						System.out.println("〒" + y_no + str[6] + str[7] + str[8] + " ");
					} else {
						System.out.println("該当なし");
					}

				}

			}

		}
	}

}
