package chap09;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
public class Ex05_A {
	public static void main(String[] args) throws IOException{
		//山の名前と標高の配列
		String[][] yama = {{"エベレスト","8848m"}
						  ,{"モンブラン","5642m"}
						  ,{"マッキンリー","6194m"}
						  ,{"アコンカグア","6959m"}
						  ,{"キリマンジャロ","5895m"}
						  ,{"コジオスコ","2228m"}
						  ,{"ヴィンソン・マシフ","4892m"}};
		//HashMapの生成
		HashMap hm = new HashMap();
		//HashMapに情報を格納
		for(String[] s : yama){
			hm.put(s[0],s[1]);
		}
		//HashMapのキーをすべて取得しSetクラスのオブジェクトに入れる
		Set hmSet = hm.keySet();
		System.out.println("//世界7大陸最高峰の標高を表示する辞書//");
		System.out.println("\n//山の名前//");
		//Setクラスのオブジェクトよりキーの一覧を表示
		for(Object obj: hmSet){
			System.out.print("「"+ (String)obj +"」");
		}

		System.out.print("\n■山の名前を上から選んで入力してください（全角カタカナ）: ");
		//標準入力オープン
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//山の名前を入力
		String str = br.readLine();
		//入力された文字列をキーにしてHashMapの値を取得
		if(hm.get(str)==null){
			//取得した結果がnullの場合
			System.out.print("\nそのような山は登録されていません : " + str);
		}else{
			//取得した山の標高を表示
			System.out.print("\n" + str + "の標高は、" + (String)hm.get(str) + "です。");
		}
	}
}





