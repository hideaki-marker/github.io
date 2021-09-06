package chap05;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class AddressSearch_A {

	public static void main(String[] args) {
		String name = "";
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			// "q"が入力されるまで繰り返す。
			while(!(name.equals("q"))){
				System.out.print("氏名を入力して下さい：");
				//コンソールより、氏名を入力する。
				name = br.readLine();
				//入力された値が"q"以外の時
				if(!(name.equals("q"))){
					// テーブル(adr_book)より該当の住所録情報を取得する。
					ArrayList<Adr_book_A> ary_adr = Adr_book_A.searchAdr(name);
					if(ary_adr == null){
						// 該当情報が存在しない場合は、メッセージを表示する。
						System.out.println("氏名:" + name + "に該当する情報はありませんでした。");
					}else{
						// 取得した住所録情報をコンソールに表示する。
						for(Adr_book_A adr : ary_adr){
							adr.information();
						}
					}
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			System.out.println("終了します。");
		}
	}

}