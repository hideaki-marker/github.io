package school_A;

public class Hantei {

	public static void main(String[] args) {
		try{
			// 学生の配列を生成
			Gakusei[] s = {
				Gakusei.getInstance('A', "伊藤", 75, 68, 62),
				Gakusei.getInstance('B', "上田", 63, 72, 67),
				Gakusei.getInstance('C', "今井", 52, 38, 72),
				Gakusei.getInstance('A', "酒井", 67, 46, 81),
				Gakusei.getInstance('C', "松本", 52, 81, 68),
				Gakusei.getInstance('B', "石井", 48, 51, 73)};
				//Gakusei.getInstance('D', "松本", -52, -81, -68) };
			// 成績の表示
			for (Gakusei g : s) {
				g.seiseki();
			}
		}catch(HanteiException e){
			e.getMsg();
		}catch (Exception e) {
			System.out.println("エラーが発生しました。");
			e.printStackTrace();
		}

	}
}
