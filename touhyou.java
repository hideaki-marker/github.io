package baseball;

public class touhyou {

	public static void main(String[] args) {
		Sportsman[] sports = {
				Sportsman.getInstance("武田",1),
				Sportsman.getInstance("山中",2),
				Sportsman.getInstance("安部",2),
				Sportsman.getInstance("岩本",1)
				
		};
		
for (Sportsman g : sports) {
			
			g.introduction();
			
		}

	}

}
