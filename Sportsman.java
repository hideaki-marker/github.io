package baseball;

public abstract class Sportsman {
	//必要な変数の設定(名前、カテゴリー、点数など)
	private String name;
	private int category;
	private int point;
	private static int totalPoint;
	private static final String[] CATEGORY_NAME = { "Pitcher", "Batter" };

	//コンストラクターの作成(これが無いとサブクラスでのコンストラクター作成時、呼び出しができず、エラーになる)
	public Sportsman(String name, int category) {
		this.name = name;
		this.category = category;
		System.out.println("///" + name + "さんが登録しました。カテゴリーは" +
				getCategoryName() + "です。///");
	}

	//投票数のセットと総投票数totalPoint)のカウントを同時に行う
	public void setPoint(int point) {
		this.point += point;
		System.out.println(getName() + "　" + getPoint() + "票");

		totalPoint += point;
	}

	//個人の投票数のゲッター
	public int getPoint() {
		return point;
	}

	//個人の名前のゲッター
	public String getName() {
		return name;
	}

	//ピッチャー、バッターのゲッター
	public String getCategoryName() {
		return CATEGORY_NAME[category - 1];
	}

	//抽象メソッドの作成(サブクラスオーバーライド用)
	abstract void introduction();//抽象メソッド
	//総得票数のゲッター

	public static int getTotalPoint() {
		return totalPoint;
	}

	//touhyouからのインスタンス化に対してのゲットインスタンス(ピッチャー)
	public static Sportsman getInstance(String name, int category, int win) {

		if (category != 1) {
			System.out.println("カテゴリーが不明です。」");

		}
		return new Pitcher(name, category, win);
	}

	//touhyouからのインスタンス化に対してのゲットインスタンス(バッター)
	public static Sportsman getInstance(String name, int category, double avg) {

		if (category != 2) {
			System.out.println("カテゴリーが不明です。」");

		}

		return new Batter(name, category, avg);
	}

}
