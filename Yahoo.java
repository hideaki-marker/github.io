package Web;

public class Yahoo {

	public static void main(String[] args) {
		
		Scrape scrape_it = new Scrape("https://news.yahoo.co.jp/categories/it");
		
		System.out.println("IT�j���[�X");
		scrape_it.scrapeData();
		
	}

}
