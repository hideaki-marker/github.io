package practis;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class Takarakuji {

	public static void main(String[] args) {
		long money = 0;
		/*int kuji = 0;
		while(kuji != 1) {
			kuji = (int)(Math.random()*9999999) + 1;
			System.out.println(kuji);
			money -= 300;
			
		}
		System.out.println("���߂łƂ��������܂��I�I1�����I���܂����I�I");
		System.out.println(money);*/
		Locale df = Locale.getDefault();//���P�[���̃I�u�W�F�N�g�̍쐬
		NumberFormat jp = NumberFormat.getCurrencyInstance(df);//�ʉ݃t�H�[�}�b�g�̃I�u�W�F�N�g�̍쐬
		
		ArrayList<Integer> kuji2 = new ArrayList<Integer>();//�N�W���i�[����ϐ�
		for(int i = 0; i <= 10000000;i++) {
			kuji2.add(i);//�N�W�̊i�[
		}
		
		Collections.shuffle(kuji2);//���Ԃ���ёւ���
		
		for(int value : kuji2) {//int�^�̊g��for���ɂ���
			System.out.println(value);
			money -= 300;//1��300�~�Ƃ���
			if(value == 1) {//����1�����������Ȃ�
				System.out.println("���߂łƂ��������܂��I�I1�����I���܂����I�I");
				break;
			}
		}
		System.out.println("�g�������z�́u" + jp.format(money) + "�~�v");//���I�܂łɎg�������z
		
		
	}

}
