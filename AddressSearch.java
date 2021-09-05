package DB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;

public class AddressSearch {

	public static void main(String[] args) {
		String name = "";
		try (BufferedReader  br = new BufferedReader(new InputStreamReader(
				System.in));) {
			System.out.print("名前の入力で検索します。半角'q'で終了(部分一致も可): ");
			name = br.readLine();
			
			Adr_search adr = new Adr_search();
			;
			for(Adr_book a : adr.searchAdr(name)) {
				Field[] fields = a.getClass().getDeclaredFields();
				for(int i = 0; i< fields.length;i++) {
					if(fields[i] == null) {
						System.out.print("？？？");
					}else {
						 fields[i].setAccessible(true);
						System.out.println(fields[i]);
					}
				}
				/*
				 * Optional<Adr_book> opt = Optional.ofNullable(a); opt.ifPresentOrElse(v ->
				 * System.out.println("登録No," + ((Adr_book) v).getAdb_id() + " 名前: " +
				 * ((Adr_book) v).getAdb_name() + " " + a.getAdb_reading() + " 性別: " +
				 * ((Adr_book) v).getGender_name() + " 住所: " + ((Adr_book) v).getAdb_zip() + " "
				 * + ((Adr_book) v).getAdb_address() + " Tel: " + ((Adr_book) v).getAdb_phone()
				 * + " メールアドレス:" + ((Adr_book) v).getAdb_mail() + " 地域: " + ((Adr_book)
				 * v).getDst_name() + " 関係: " + ((Adr_book) v).getGnr_name() + " 登録日: " +
				 * ((Adr_book) v).getAdb_add_day()), () -> System.out.println("nullでーす"));
				 */
				
				
				/*System.out.println("登録No," +  a.getAdb_id() + " 名前: " + a.getAdb_name() + " " + a.getAdb_reading() 
				+ " 性別: " + a.getGender_name() + " 住所: " + a.getAdb_zip() + " " + a.getAdb_address() + 
				" Tel: " + a.getAdb_phone() + " メールアドレス:" + a.getAdb_mail() + " 地域: " + a.getDst_name() + 
				" 関係: " + a.getGnr_name() + " 登録日: " + a.getAdb_add_day());*/
			}
			
			/*
			 * do {
			 * 
			 * }while(!name.equals("q"));
			 */
			
		}catch (IOException e) {
			System.out.println("郵便番号ファイルが存在しません。");
		}finally{
			System.out.println("終了します。");
		}

	}

}
