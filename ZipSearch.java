package zipSearch;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZipSearch {

	public static void main(String[] args) {
		String zipNum ;// 郵便番号の変数

		try (BufferedReader br = new BufferedReader
				(new InputStreamReader(System.in));) {

			do {
				ZipBean be = new ZipBean();
				Thread z = new Thread(be);
				System.out.print("郵便番号を入力してください（qで終了） ： ");
				zipNum = br.readLine();
				z.start();
				String regex = "^[^A-z]{3}-?[^A-z]{4}$";
				Pattern p = Pattern.compile(regex);
				Matcher m = p.matcher(zipNum);


				if (m.find()) {
					ZipBean.execute(zipNum);
					z.join();

				}else{
					System.out.println("---郵便番号が不正です。---");
					z.join();
				}

			} while (!zipNum.equals("q"));
		} catch (FileNotFoundException e) {
			System.out.println("郵便番号ファイルが存在しません。");
		} catch (IOException e) {
			System.out.println("入力エラーが発生しました。");
		} catch (Exception e) {
			System.out.println("エラーが発生しました。");
		}
		System.out.println("終了します。");
	}

	}


