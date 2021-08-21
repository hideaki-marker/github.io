package Web;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scrape {
	protected String url;
	Scrape(String url){
		this.url = url;
	}
	
	public void scrapeData() {
		try {
			Document document = Jsoup.connect(this.url).get();
	        //System.out.println(document.html());
			Document doc = Jsoup.connect(this.url).get();
			Elements elm = doc.select("a");
			for(Element elms : elm) {
				String title = elms.text();
				System.out.println(title);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
