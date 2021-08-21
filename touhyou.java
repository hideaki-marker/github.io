package baseball;

public class touhyou {

	public static void main(String[] args) {
		//選手のオブジェクトの作成
		Sportsman[] sports = {
				Sportsman.getInstance("武田", 1, 15),
				Sportsman.getInstance("山中", 2, 0.334),
				Sportsman.getInstance("安部", 2, 0.313),
				Sportsman.getInstance("岩本", 1, 11)

		};
		//投票を10回行う
		for (int i = 1; i <= 10; i++) {
			System.out.println(i + "回目");
			//4人分の票数の表示
			for (int j = 0; j < sports.length; j++) {
				sports[j].setPoint((int) (Math.random() * 51));
			}
			System.out.println();
			System.out.println("--------------------------");
			System.out.println();
		}
		//全員分の総投票数の表示
		System.out.println("総投票数は" + Sportsman.getTotalPoint() + "票でした。");

		//一番票が多かった人を求めるロジック
		int maxp = 0;
		int m = 0;
		for (int i = 0; i < sports.length; i++) {
			if (m < sports[i].getPoint()) {
				m = sports[i].getPoint();
				maxp = i;
			}

		}
		//一番票が多かった人の表示
		System.out.println("優勝は");
		sports[maxp].introduction();
	}

}
