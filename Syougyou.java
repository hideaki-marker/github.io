package practis;

public class Syougyou extends Gakusei {
	private int boki;
	
	public Syougyou() {
		this("Unknown","Unknown",0,0,0);
	}

	public Syougyou(String classRoom, String name, int kokugo, int suugaku, int boki) {
		super(classRoom, name, kokugo, suugaku);
		this.boki = boki;
	}

	@Override
	public String gouhi() {
		if (super.gouhi() == "‡Ši") {
			if (boki >= 70) {
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
		System.out.printf("•ë‹LF%6d",boki);
		System.out.println();
		
	}
}
