package practis;

public class Gakusei {
		private String classRoom;
		private String name;
		private int  kokugo;
		private int suugaku;
		private static int num;
		
		

		

		public Gakusei(String classRoom2, String name2, int kokugo2, int suugaku2) {
			this.classRoom = classRoom2;
			this.name = name2;
			this.kokugo = kokugo2;
			this.suugaku = suugaku2;
		}



		public static Gakusei getInstance(String classRoom, String name, int kokugo,int suugaku,int num) {
			
			Gakusei ga = null;
			
			switch(classRoom) {
			case "A":
				ga = new Futuu(classRoom, name, kokugo,suugaku, num);
				break;
			case "B":
				ga = new Syougyou(classRoom, name, kokugo,suugaku, num);
				break;
			case "C":
				ga = new Kougyou(classRoom, name, kokugo,suugaku, num);
				break;
			default:
				break;
			}
			
			return ga;
		}
		
		
		
		public String gouhi() {
			if(kokugo + suugaku / 2 >= 60) {
				return "合格";
			}else {
				return "不合格";
			
		}
		}
		
		public void infomation() {
			System.out.printf("%-10s",classRoom);
			System.out.printf("%-12s",name);
			System.out.printf("国語：%6d",kokugo);
			System.out.printf("数学：%6d ",suugaku);
			
		}
}
