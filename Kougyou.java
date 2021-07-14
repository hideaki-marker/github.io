package practis;

public class Kougyou extends Gakusei {
	private int sekkei;
	
	public Kougyou() {
		this("Unknown","Unknown",0,0,0);
	}

	public Kougyou(String classRoom, String name, int kokugo, int suugaku, int sekkei) {
		super(classRoom, name, kokugo, suugaku);
		this.sekkei = sekkei;
	}

	@Override
	public String gouhi() {
		if (super.gouhi() == "合格") {
			if (sekkei >= 60) {
				return "合格";
			} else {
				return "不合格";

			}
		} else {
			return "不合格";

		}

	}

	public void infomation() {
		super.infomation();
		System.out.printf("設計　；%6d",sekkei);
		System.out.println();
		
	}
}
