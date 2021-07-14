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
		if (super.gouhi() == "合格") {
			if (syakai >= 60) {
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
		System.out.printf("社会　：%6d",syakai);
		System.out.println();
		
	}
}
