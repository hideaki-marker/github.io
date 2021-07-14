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
		if (super.gouhi() == "合格") {
			if (boki >= 70) {
				return "合格";
			} else {
				return "不合格";

			}
		} else {
			return "•s‡Ši";

		}

	}
	public void infomation() {
		super.infomation();
		System.out.printf("簿記　：%6d",boki);
		System.out.println();
		
	}
}
