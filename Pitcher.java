package baseball;
public class Pitcher extends Sportsman{
	

	private int win;
	
	public void introduction() {
		System.out.println(getName() + "Pitcher　勝ち数" + win + "　勝");
	}
	
	public Pitcher(String name, int win) {
		super(name, 1);
		this.win = win;
	}

}
　勝ち数
