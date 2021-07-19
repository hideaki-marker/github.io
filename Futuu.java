package school_A;

public class Futuu extends Gakusei{
	//フィールド
	private int 	syakai;		// 科目 社会
	//コンストラクター
	public Futuu(){
		super();
		this.syakai = 0;
	}
	public Futuu(char class_cd,String name,int kokugo,int suugaku,int syakai){
		super(class_cd,name,kokugo,suugaku);
		setSyakai(syakai);
	}
	//アクセスメソッド
	public int getSyakai() {
		return syakai;
	}
	/*
	 * 社会の点数を設定
	 * 引数の点数が０点より小さいか、１００より大きいときエラー
	 */
	public void setSyakai(int syakai) {
		if(syakai < 0 || syakai > 100){
			throw new HanteiException(getName()+"さんの社会に正しくない点数が設定されています。:" + syakai);
		}else{
			this.syakai = syakai;
		}
	}
	//メソッド
	/*
	 *  合格不合格の判定し文字列で合格、不合格を戻す。
	 * 	国語、数学、社会の平均点が６０点以上の時合格
	 */
	@Override
	public String gouhi(){
		String gouhi = "不合格";
		int goukei = getKokugo() + getSuugaku() + getSyakai();
		int avg    = goukei / 3;
		if(avg >= 60){
			gouhi = "合　格";
		}
		return gouhi;
	}
	/*
	 * 成績表示
	 * Gakuseiクラス（スーパークラス）のseiseki()メソッドで共通の情報を表示し
	 * 普通科独自の社会の点数を表示する。
	 */
	@Override
	public void seiseki(){
		super.seiseki();
		System.out.printf("社会:%4d", syakai);
		System.out.println();
	}

}
