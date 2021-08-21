package baseball;

public class Pitcher extends Sportsman {
	//ピッチャーでの総勝利数の変数
	private int win;

	//オーバーライド用のピッチャーの紹介文
	@Override
	public void introduction() {
		System.out.println(getName() + "(" + getCategoryName() + ")　勝ち数" + win + "勝");
	}

	//サブのコンストラクター
	public Pitcher(String name, int category, int win) {
		//ここでスーパークラスのコンストラクターを呼び出すのでスーパークラスに同じ引数のコンストラクターが必要
		super(name, category);
		//勝利数を変数に代入
		this.win = win;
	}

}
