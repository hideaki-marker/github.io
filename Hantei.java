package practis;

public class Hantei {

	public static void main(String[] args) {
		Gakusei[] gaku = {
				Gakusei.getInstance("A","伊藤",75,68,62),
				Gakusei.getInstance("B","上田",63,72,67),
				Gakusei.getInstance("C","今井",52,38,72),
				Gakusei.getInstance("A","酒井",67,46,81),
				Gakusei.getInstance("C","松本",52,81,68),
				Gakusei.getInstance("B","石井",48,51,73)
		};
		
		for(Gakusei g: gaku) {
			//g.getClassRoom();
			g.gouhi();
			g.infomation();
		}
	}

}
