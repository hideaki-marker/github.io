package school_A;


public abstract class Gakusei {
	//フィールド
	private char 	class_cd;	// クラス
	private String 	name;		// 名前
	private int 	kokugo;		// 科目 国語
	private int 	suugaku;	// 科目 数学

	//コンストラクター
	public Gakusei(){
		this(' '," ",0,0);
	}
	public Gakusei(char class_cd,String name,int kokugo,int suugaku){
		this.class_cd 	= class_cd;
		this.name 		= name;
		setKokugo(kokugo);
		setSuugaku(suugaku);
	}
	//アクセスメソッド
	public char getClass_cd() {
		return class_cd;
	}

	public String getName() {
		return name;
	}

	public int getKokugo() {
		return kokugo;
	}

	public int getSuugaku() {
		return suugaku;
	}
	/*
	 * 国語の点数を設定
	 * 引数の点数が０点より小さいか、１００より大きいときエラー
	 */
	public void setKokugo(int kokugo){
		if(kokugo < 0 || kokugo > 100){
			throw new HanteiException(this.name+"さんの国語に正しくない点数が設定されています。:" + kokugo);
		}else{
			this.kokugo = kokugo;
		}
	}
	/*
	 * 数学の点数を設定
	 * 引数の点数が０点より小さいか、１００より大きいときエラー
	 */
	public void setSuugaku(int suugaku) {
		if(suugaku < 0 || suugaku > 100){
			throw new HanteiException(this.name+"さんの数学に正しくない点数が設定されています。:" + suugaku);
		}else{
			this.suugaku = suugaku;
		}
	}

	//メソッド

	/*オブジェクトの生成
	 * 引数のclass_cdにより普通科、商業科、工業科の学生のオブジェクトを生成する
	 * class_cdがA,B,C以外の時エラー
	 */
	public static Gakusei getInstance(char class_cd,String name,int kokugo,int suugaku,int num){
		Gakusei g;
		switch(class_cd){
		 	case 'A':
		 		g = new Futuu(class_cd, name, kokugo, suugaku, num);
		 		break;
		 	case 'B':
		 		g = new Syougyou(class_cd, name, kokugo, suugaku, num);
		 		break;
		 	case 'C':
		 		g = new Kougyou(class_cd, name, kokugo, suugaku, num);
		 		break;
		 	default:
		 		throw new HanteiException(name + "さんに正しくないクラスが設定されています。:" + class_cd);

		}
		return g;
	}
	/*
	 *  合否判定
	 *  合格不合格の判定し文字列で合格、不合格を戻す。（抽象メソッド）
	 */

	public abstract String gouhi();//抽象メソッド
	/*
	 * 成績表示
	 * 合否、クラス名、名前、国語、数学を表示
	 */
	public void seiseki(){
		System.out.printf("%4s ", gouhi());
		System.out.printf("%3s ", class_cd);
		System.out.printf("%4s ", name);
		System.out.printf("国語:%4d ", kokugo);
		System.out.printf("数学:%4d ", suugaku);
	}


}
