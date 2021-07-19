package school_A;


public class Syougyou extends Gakusei{
	//フィールド
	private int 	boki;		// 科目 簿記
	//コンストラクター
	public Syougyou(){
		super();
		this.boki = 0;
	}
	public Syougyou(char class_cd,String name,int kokugo,int suugaku,int boki){
		super(class_cd,name,kokugo,suugaku);
		setBoki(boki);
	}
	//アクセスメソッド
	public int getBoki() {
		return boki;
	}
	/*
	 * 簿記の点数を設定
	 * 引数の点数が０点より小さいか、１００より大きいときエラー
	 */
	public void setBoki(int boki){
		if(boki < 0 || boki > 100){
			throw new HanteiException(getName()+"さんの簿記に正しくない点数が設定されています。:" + boki);
		}
		this.boki = boki;
	}
	//メソッド
	/*
	 *  合格不合格の判定し文字列で合格、不合格を戻す。
	 * 	国語、数学の平均点が50点以上かつ簿記が70点以上で合格
	 */
	@Override
	public String gouhi(){
		String gouhi = "不合格";
		int goukei = getKokugo() + getSuugaku();
		int avg    = goukei / 2;
		if(avg >= 50 && getBoki() >= 70 ){
			gouhi = "合　格";
		}
		return gouhi;
	}
	/*
	 * 成績表示
	 * Gakuseiクラス（スーパークラス）のseiseki()メソッドで共通の情報を表示し
	 * 商業科独自の簿記の点数を表示する。
	 */
	@Override
	public void seiseki(){
		super.seiseki();
		System.out.printf("簿記:%4d", boki);
		System.out.println();
	}

}
