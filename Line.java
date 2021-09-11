package Web;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.stream.Collectors;

public class Line {

	public static class LineNotify {
		public static void main(String[] args) {
			Scrape_re scrape_it = new Scrape_re("https://news.yahoo.co.jp/categories/it");
			
			System.out.println("ITニュース");
			String scrape = scrape_it.scrapeData();
			
	        LineNotify lineNotify = new LineNotify("自分のトークン"); // LINE Notifyのアクセストークン(適宜変更)
	        lineNotify.notify(scrape);
	        System.out.println("javaからlineへ通知しました。");
	    }

	
	 private final String token;
	    public LineNotify(String token) {
	        this.token = token;
	    }
	    
	    public void notify(String message) {
	        HttpURLConnection connection = null;
	        try {
	            URL url = new URL("https://notify-api.line.me/api/notify");
	            connection = (HttpURLConnection) url.openConnection();
	            connection.setDoOutput(true);
	            connection.setRequestMethod("POST");
	            connection.addRequestProperty("Authorization", "Bearer " + token);
	            try (OutputStream os = connection.getOutputStream();
	                 PrintWriter writer = new PrintWriter(os)) {
	                writer.append("message=").append(URLEncoder.encode(message, "UTF-8")).flush();
	                try (InputStream is = connection.getInputStream();
	                     BufferedReader r = new BufferedReader(new InputStreamReader(is))) {
	                    String res = r.lines().collect(Collectors.joining());
	                    if (!res.contains("\"message\":\"ok\"")) {
	                        System.out.println(res);
	                    }
	                }
	            }
	        } catch (Exception ignore) {
	        } finally {
	            if (connection != null) {
	                connection.disconnect();
	            }
	        }
	    }
	}
}
