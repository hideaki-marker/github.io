package baseball;

public class Batter extends Sportsman{
	
	private double avg;
	
	public void introduction() {
		System.out.println(getName() + "Batter�@�ŗ��F" + avg + "��");
	}
	
	public Batter(String name, double avg) {
		super(name, 2);
		this.avg = avg;
		
	}


}
