package practis;

public class Hantei {

	public static void main(String[] args) {
		Gakusei[] gaku = {
				Gakusei.getInstance("A","ˆÉ“¡",75,68,62),
				Gakusei.getInstance("B","ã“c",63,72,67),
				Gakusei.getInstance("C","¡ˆä",52,38,72),
				Gakusei.getInstance("A","ğˆä",67,46,81),
				Gakusei.getInstance("C","¼–{",52,81,68),
				Gakusei.getInstance("B","Îˆä",48,51,73)
		};
		
		for(Gakusei g: gaku) {
			//g.getClassRoom();
			g.gouhi();
			g.infomation();
		}
	}

}
