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
		if (super.gouhi() == "���i") {
			if (sekkei >= 60) {
				return "���i";
			} else {
				return "�s���i";

			}
		} else {
			return "�s���i";

		}

	}

	public void infomation() {
		super.infomation();
		System.out.printf("�݌v�F%6d",sekkei);
		System.out.println();
		
	}
}
