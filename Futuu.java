package practis;

public class Futuu extends Gakusei {
	private int syakai;
	
	public Futuu() {
		this("Unknown","Unknown",0,0,0);
	}
	

	public Futuu(String classRoom, String name, int kokugo, int suugaku, int syakai) {
		super(classRoom, name, kokugo, suugaku);
		this.syakai = syakai;
	}

	@Override
	public String gouhi() {
		if (super.gouhi() == "���i") {
			if (syakai >= 60) {
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
		System.out.printf("�Љ�F%6d",syakai);
		System.out.println();
		
	}
}
