package Web;

public class Yahoo {

	public static void main(String[] args) {
		
		Scrape scrape_it = new Scrape("https://news.yahoo.co.jp/categories/it");
		
		System.out.println("ITƒjƒ…[ƒX");
		scrape_it.scrapeData();
		
	}

}
