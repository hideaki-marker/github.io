package school_A;

public class Kougyou extends Gakusei{
	//フィールド
	private int 	sekkei;		// 科目 設計
	//コンストラクター
	public Kougyou(){
		super();
		this.sekkei = 0;
	}
	public Kougyou(char class_cd,String name,int kokugo,int suugaku,int sekkei){
		super(class_cd,name,kokugo,suugaku);
		setSekkei(sekkei);
	}
	//アクセスメソッド
	public int getSekkei() {
		return sekkei;
	}
	/*
	 * 設計の点数を設定
	 * 引数の点数が０点より小さいか、１００より大きいときエラー
	 */
	public void setSekkei(int sekkei){
		if(sekkei <=0 || sekkei > 100){
			throw new HanteiException(getName()+"さんの設計に正しくない点数が設定されています。:" + sekkei);
		}
		this.sekkei = sekkei;
	}
	//メソッド
	/*
	 *  合格不合格の判定し文字列で合格、不合格を戻す。
	 * 	国語、数学の平均点が50点以上かつ設計が70点以上で合格
	 */
	@Override
	public String gouhi(){
		String gouhi = "不合格";
		int goukei = getKokugo() + getSuugaku();
		int avg    = goukei / 2;
		if(avg >= 50 && getSekkei() >= 70 ){
			gouhi = "合　格";
		}
		return gouhi;
	}
	/*
	 * 成績表示
	 * Gakuseiクラス（スーパークラス）のseiseki()メソッドで共通の情報を表示し
	 * 工業科独自の設計の点数を表示する。
	 */
	@Override
	public void seiseki(){
		super.seiseki();
		System.out.printf("設計:%4d", sekkei);
		System.out.println();
	}

}
