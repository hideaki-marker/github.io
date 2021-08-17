package zipSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ZipBean implements Runnable{

	public static void execute(String zipNum){
		HttpURLConnection connection = null;// HttpConnectionの宣言
		URL url = null;// URLの変数
		final String urlAddress = "https://zipcloud.ibsnet.co.jp/api/search?zipcode="
				+ zipNum;// URLとzipNumをくっつけた文字列
		try {
			url = new URL(urlAddress);// 郵便番号を繋げた変数をURLオブジェクトへ代入
			try {
				connection = (HttpURLConnection) url.openConnection();// 接続用HttpURLConnectionオブジェクトの作成
				connection.setRequestMethod("GET");// サーバーと繋ぐ時はGETを引数にする
				connection.setInstanceFollowRedirects(false);// リダイレクトはしないのでfalse
				connection.setRequestProperty("Accept-Language", "jp");// ヘッダーの設定(日本語)
				connection.connect();// リクエスト
				if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {// 無事に接続出来たなら
					try (InputStreamReader isr = new InputStreamReader(
							connection.getInputStream(), StandardCharsets.UTF_8);
							BufferedReader reader = new BufferedReader(isr)) {// 読み込みの準備と文字コードをUTF-8に設定
						String rec;// ファイル読み込み用の変数
						StringBuffer line = new StringBuffer();// ファイルの文字列を一行にまとめる変数
						while ((rec = reader.readLine()) != null) {// データが全て読み込みが終わるまで
							line.append(rec);// StringBuffer lineにrecを繋げていく
						}
						JSONObject json = new JSONObject(line.toString());// lineをString型に変換し、jsonオブジェクトへ代入
						int status = json.getInt("status");// ステータスコードの変数を代入
						if (status == 200) {// 200番なら通信に成功
							if (!json.isNull("results")) {// resultsのステータスを全部読み込み終えるまで
								JSONArray jar = json.getJSONArray("results");// resultsのデータをJSON配列に格納
								JSONObject data = jar.getJSONObject(0);// １番上の住所のデータをオブジェクトへ代入
								String yuubin = data.getString("zipcode");//
								String pref = data.getString("address1");//
								String city = data.getString("address2");//
								String town = data.getString("address3");//
								final String fullAddress = "〒　" + yuubin + "　住所:"
										+ pref + city + town;
								System.out.println(fullAddress);
							} else {
								System.out.println("〒" + zipNum
										+ "に該当する郵便番号は見つかりませんでした。");
							}
						} else {
							String message = json.getString("message");
							System.out.println("status:" + status + "message:"
									+ message);
						}
					} catch (JSONException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();

					}
				}

			} finally {
				if (connection != null) {
					connection.disconnect();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();

		}

	}
	@Override
	public void run(){
		try {

			for(int i = 0;i < 10;i++){
			Thread.sleep(50);
			}
			System.out.println("*******");
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}

