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
		if (super.gouhi() == "‡Ši") {
			if (syakai >= 60) {
				return "‡Ši";
			} else {
				return "•s‡Ši";

			}
		} else {
			return "•s‡Ši";

		}

	}

	public void infomation() {
		super.infomation();
		System.out.printf("Ğ‰ïF%6d",syakai);
		System.out.println();
		
	}
}
