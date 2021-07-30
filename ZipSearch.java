package chap07;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ZipSearch {

	public static void main(String[] args) throws IOException {
		BufferedReader br = null;
		try(BufferedReader bf = new BufferedReader
				(new InputStreamReader(System.in))){
		Scanner sc = null;
		String rec = null;
		String[] str = null;

		System.out.println("「郵便番号を入力してください(qで終了)　：」");
		String yuubin = bf.readLine();
		if (yuubin.equals("q")) {
			System.out.println("終了します。");
		} else{
			
				br = new BufferedReader(new InputStreamReader
						(new FileInputStream("01HOKKAI.CSV"),"MS932"));
				
				while((rec = br.readLine()) != null){
					rec.replace("\"","");
					str = rec.split(",");
					
					if(yuubin.equals(str[2])){
					
						System.out.println(str[2] + str[6] + str[7] + str[8] + " ");
					}
				
				}
			
		}

	}
	}
}
