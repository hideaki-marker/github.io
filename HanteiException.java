package school_A;

public class HanteiException extends RuntimeException{
	//フィールド
	String msg = ""; // エラーメッセージ
	//コンストラクター
	public HanteiException(){
		this.msg = "エラーが発生しました。";
	}
	public HanteiException(String msg){
		this.msg = msg;
	}
	//メソッド
	public void getMsg(){
		System.out.println(this.msg);
	}
}
