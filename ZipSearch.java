package zipSearch;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZipSearch {

	public static void main(String[] args)  {
		String zipNum ;// 郵便番号の変数
		 boolean exit;

		try (BufferedReader br = new BufferedReader
				(new InputStreamReader(System.in));) {

			do {
				Runnable runner = () -> {for(int i = 0;i <= 1200;i++){
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
					System.out.print("*");
					};
					System.out.println();};
				Thread z = new Thread(runner);
				System.out.print("郵便番号を入力してください（qで終了） ： ");
				zipNum = br.readLine();
				z.start();
				String regex = "^[^A-z]{3}-?[^A-z]{4}$";
				Pattern p = Pattern.compile(regex);
				Matcher m = p.matcher(zipNum);


				if (m.find()) {
					ZipBean.execute(zipNum);
					z.wait();

				}else{
					System.out.println("---郵便番号が不正です。---");
					z.wait();
				}

			} while (!zipNum.equals("q"));
		} catch (FileNotFoundException e) {
			System.out.println("郵便番号ファイルが存在しません。");
		} catch (IOException e) {
			System.out.println("入力エラーが発生しました。");
		} catch (InterruptedException e) {
			System.out.println("エラーが発生しました。");
		} 
		System.out.println("終了します。");
	}

	public static void stopThread() {
		 boolean exit = true;
	    }
	}
