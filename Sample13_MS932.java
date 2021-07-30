package chap07;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
public class Sample13_MS932{
	public static void main(String[] args){
		BufferedWriter bw = null;
		try{
			//bw = new BufferedWriter(new FileWriter("FileCSV1.csv"));//Open処理
			bw = new BufferedWriter(new OutputStreamWriter
						 (new FileOutputStream("FileCSV_MS932.csv"),"MS932"));//Open処理
			for(int i = 1; i <= 5; i++){
				int id = i;
				String name = "商品名" + (char)('A' + i - 1); //商品名を生成
				int price = i * 1000; //価格を設定
				//値をコンマ区切りでつなぎ合わせる
				String rec = id + "," + name + "," + price;
				bw.write(rec + System.lineSeparator()); //改行を含めて書き出し
			}

		}catch(IOException ee){
		}finally{
			try{
				if(bw != null){
					bw.close(); //クローズ処理
				}
			}catch(IOException e){ }
		}
	}
}
