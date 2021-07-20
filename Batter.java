package baseball;

public class Batter extends Sportsman{
	
	private double avg;
	
	public void introduction() {
		System.out.println(getName() + "Batter@‘Å—¦F" + avg + "Ÿ");
	}
	
	public Batter(String name, double avg) {
		super(name, 2);
		this.avg = avg;
		
	}


}
