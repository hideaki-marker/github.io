package zipSearch;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZipSearch {

	public static void main(String[] args)  {
		String zipNum ;// �X�֔ԍ��̕ϐ�
		 boolean exit;

		try (BufferedReader br = new BufferedReader
				(new InputStreamReader(System.in));) {

			do {
				Runnable runner = () -> {for(int i = 0;i <= 1200;i++){
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO �����������ꂽ catch �u���b�N
						e.printStackTrace();
					}
					System.out.print("*");
					};
					System.out.println();};
				Thread z = new Thread(runner);
				System.out.print("�X�֔ԍ�����͂��Ă��������iq�ŏI���j �F ");
				zipNum = br.readLine();
				z.start();
				String regex = "^[^A-z]{3}-?[^A-z]{4}$";
				Pattern p = Pattern.compile(regex);
				Matcher m = p.matcher(zipNum);


				if (m.find()) {
					ZipBean.execute(zipNum);
					z.wait();

				}else{
					System.out.println("---�X�֔ԍ����s���ł��B---");
					z.wait();
				}

			} while (!zipNum.equals("q"));
		} catch (FileNotFoundException e) {
			System.out.println("�X�֔ԍ��t�@�C�������݂��܂���B");
		} catch (IOException e) {
			System.out.println("���̓G���[���������܂����B");
		} catch (InterruptedException e) {
			System.out.println("�G���[���������܂����B");
		} 
		System.out.println("�I�����܂��B");
	}

	public static void stopThread() {
		 boolean exit = true;
	    }
	}
