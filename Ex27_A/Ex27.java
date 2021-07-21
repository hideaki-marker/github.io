package Ex27_A;

public class Ex27 {
	public static void main(String[] args) {
		System.out.println("\n人気投票を始めます。\n");
		//Sportsmanクラス型の配列を生成
		Sportsman[] p = {	Sportsman.getInstance("武田",15), //それぞれの要素にインスタンスを代入
							Sportsman.getInstance("山中",0.324),
							Sportsman.getInstance("安部",0.310),
							Sportsman.getInstance("岩本",11)};
		for(int i = 1 ; i <= 10 ; i++){ //10回繰り返し
			System.out.println( i + "回目");
			for(int j = 0 ; j < p.length ; j++){ //pの要素数分繰り返し
				p[j].setPoint((int)(Math.random() * 51)); //得票を代入
				//System.out.println(p[j].getName() + " " + p[j].getPoint() + "票");//得票を表示
			}
			System.out.println("--------------------------");
		}
		System.out.println("総投票数は、" + Sportsman.getTotalPoint() + "票です。");
		/*
		for(int i = 0 ; i < p.length-1 ; i++){ //最高投票者を探す
			for(int j = i + 1 ; j < p.length ; j++){ //ポイント上位からのソート
				if(p[i].getPoint() < p[j].getPoint()){
					Sportsman temp = p[i];
					p[i] = p[j];
					p[j] = temp;
				}
			}
		}
		*/
		int maxPoint = 0; 	//最高得票数
		int maxIdx = 0;		//最高得票者インデックス
		for(int i = 0 ; i < p.length ; i++){ //最高投票者を探す
			if (maxPoint < p[i].getPoint()){
				maxPoint = p[i].getPoint();
				maxIdx = i;
			}
		}
		System.out.println("優勝者紹介：");
		p[maxIdx].introduction(); //ソートされたp[0]を紹介
	}
}
