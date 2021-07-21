package Ex27_A;
public class Pitcher extends Sportsman {
	private int win; //勝ち数
	/*コンストラクター*/
	public Pitcher(String name ,int win){
		super(name , 1); //スーパークラスのコンストラクター呼び出し
		this.win = win; //自フィールドを初期化
	}
	@Override
	public void introduction(){ //オーバーライド
		System.out.println(getName() + "("+ getCategoryName() +") 勝ち数：" + this.win + "勝" );
	}
}
