package baseball;

public class touhyou {

	public static void main(String[] args) {
		Sportsman[] sports = {
				Sportsman.getInstance("���c",1),
				Sportsman.getInstance("�R��",2),
				Sportsman.getInstance("����",2),
				Sportsman.getInstance("��{",1)
				
		};
		
for (Sportsman g : sports) {
			
			g.introduction();
			
		}

	}

}
