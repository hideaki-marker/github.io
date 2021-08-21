package Web;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scrape_re {
	protected String url;
	protected String title;
	Scrape_re(String url){
		this.url = url;
	}
	
	public String scrapeData() {
		try {
			Document document = Jsoup.connect(this.url).get();
	        //System.out.println(document.html());
			Document doc = Jsoup.connect(this.url).get();
			Elements elm = doc.select("li.sc");
			for(Element elms : elm) {
				 title = elms.text() + elms.attr("href");
				
				
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return title;
	}
}
