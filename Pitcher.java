package baseball;
public class Pitcher extends Sportsman{
	

	private int win;
	
	public void introduction() {
		System.out.println(getName() + "Pitcher�@������" + win + "��");
	}
	
	public Pitcher(String name, int win) {
		super(name, 1);
		this.win = win;
	}

}
