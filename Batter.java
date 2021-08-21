package baseball;

public class Batter extends Sportsman {
	//バッターでの打率の変数
	private double avg;

	//オーバーライドしてバッターの紹介文の表示
	public void introduction() {
		//打率を変換するロジック
		int wri = (int) (this.avg * 10);
		int bu = (int) (this.avg * 100) - (wri * 10);
		int rin = (int) (this.avg * 1000) - (wri * 100) - (bu * 10);
		System.out.println(getName() + "(" + getCategoryName() + ") 打率："
				+ wri + "割" + bu + "分" + rin + "厘");
	}

	//サブのコンストラクター
	public Batter(String name, int category, double avg) {
		//ここでスーパークラスのコンストラクターを呼び出すのでスーパークラスに同じ引数のコンストラクターが必要
		super(name, category);
		//打率を変数に代入
		this.avg = avg;

	}

}
