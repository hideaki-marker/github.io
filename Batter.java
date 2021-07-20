package baseball;

public class Batter extends Sportsman{
	
	private double avg;
	
	public void introduction() {
		System.out.println(getName() + "Batter 打率：" + avg + "勝");
	}
	
	public Batter(String name, double avg) {
		super(name, 2);
		this.avg = avg;
		
	}


}
