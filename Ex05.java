package chap07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Ex05 {

	public static void main(String[] args) {
		HashMap hm = new HashMap();
		hm.put("�G�x���X�g",8848);
		hm.put("�����u����",5642);
		hm.put("�}�b�L�����[",6194);
		hm.put("�A�R���J�O�A",6959);
		hm.put("�L���}���W����",5895);
		hm.put("�R�W�I�X�R",2228);
		hm.put("���B���\���E�}�V�t",4892);
		
		
		
		System.out.println("//���E7�嗤�ō���̕W����\�����鎫��//");
		System.out.println();
		System.out.println("//�R�̖��O//");
		System.out.println("�u�G�x���X�g�v�u�����u�����v�u�}�b�L�����[�v\r\n�u�A�R���J�O�A�v�u�L���}���W�����v�u�R�W�I�X�R�v�u���B���\���E�}�V�t�v");
		System.out.println();
		try (BufferedReader br = new BufferedReader
				(new InputStreamReader(System.in));) {
			String mt;
			System.out.print("���R�̖��O����͂��Ă�������(�S�p�J�^�J�i) :");
			mt = br.readLine();
			
			if(hm.get(mt) == null) {
				System.out.println("���̂悤�ȎR�͓o�^����Ă��܂��� :" + mt);
			}else {
				System.out.println(mt + "�̕W���́A" + hm.get(mt) + "m�ł��B");
			}
		}catch (IOException e) {
			System.out.println("���̓G���[���������܂����B");
		} 
	}

}
