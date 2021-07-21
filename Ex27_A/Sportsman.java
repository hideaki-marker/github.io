package Ex27_A;
public abstract class Sportsman{
	private String name; 					//選手名
	private int point; 						//各人の得票数
	private int category; 					//カテゴリー（1：ピッチャー、2：バッター）
	private static final String[] CATEGORY_NAME ={"Pitcher","Batter"}; //カテゴリー名の配列
	private static int totalPoint; 			//総得票数
	/** コンストラクター */
	public Sportsman(String name , int category){
		//フィールドに値を代入し、インスタンスができたメッセージを表示
		this.name = name;
		this.category = category;
		System.out.println("///" + getName() + "さんが登録しました。カテゴリーは" +
				getCategoryName() + "です。///");
	}
	//getInstance()の利用
	public static Sportsman getInstance(String name,int win){
		return new Pitcher(name,win);
	}
	public static Sportsman getInstance(String name,double avg){
		return new Batter(name,avg);
	}
	/** アクセスメソッド (今回はgeterのみ)*/
	public String getName() {
		return name;
	}

	public int getCategory() {
		return category;
	}

	public static int getTotalPoint() {
		return totalPoint;
	}

	public int getPoint() {
		return point;
	}
	public String getCategoryName() {
		return CATEGORY_NAME [category-1];
	}


	/** ポイントをセットするメソッド*/
	public void setPoint(int point){
		this.point += point; //自分の得票数に加算
		totalPoint += point; //総票数にも加算
		System.out.println(getName() + " " + getPoint() + "票");//得票を表示
	}
	/** サブクラスにオーバーライドさせるためのメソッド*/
	public abstract void introduction();

}
