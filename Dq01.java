package practis;

import java.util.Scanner;

public class Dq01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int yuusyaHp = 100;
		int mp = 3;
		int yakusou = 10;
		int ryuuohHp = 140;
		System.out.println("���������ꂽ�I�I");
		
		try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
		
		
		while(ryuuohHp > 0 && yuusyaHp > 0){
			
			System.out.println("�s����I�����Ă�������");
			System.out.print("[1]�키�A[2]���@�A[3]����A[4]������F");
			int move = scanner.nextInt();
			
			while(move >= 5){
				System.out.print("�I��������тȂ����ĉ������F");
				move = scanner.nextInt();
			}
			switch(move){
			case 1:
				int i = (int)(Math.random()*10) + 1;
				System.out.println("�E�҂̍U���I");
				System.out.println("������" + i + "�̃_���[�W��^����");
				ryuuohHp -= i;
				i = 0;
				break;
			case 2:
				if(mp >= 1){
					System.out.println("�E�҂̓�����������");
					System.out.println("������20�̃_���[�W��^����");
					--mp;
					System.out.println("�c��" + mp + "��");
					ryuuohHp -= 20;
					break;
				}else{
					System.out.println("MP������܂���");
					continue;
				}
				
				
			case 3:
				if(yakusou >= 1){
				System.out.println("�E�҂͖򑐂��g����");
				System.out.println("�E�҂�HP��30�񕜂���");
				yuusyaHp += 30;
				--yakusou;
				System.out.println("�c���" + yakusou + "��");
				if(yuusyaHp >= 101){
					yuusyaHp = 100;
				}
				break;
				}else{
					System.out.println("�򑐂͂��������E�E�E");
					continue;
				}
			case 4:
				int k = (int)(Math.random()*30) + 1;
				System.out.println("�E�҂͓����o�����I");
				if(k <= 5){
					System.out.println("�E�҂͖����ɓ����邱�Ƃ��o����");
					System.out.println("�������A���E�͗����Ɏx�z����Ă��܂����E�E�E");
					System.out.println("�Q�[���I�[�o�[�E�E�E");
					yuusyaHp = 0;
					continue;
				}else{
					System.out.println("�c�O�E�E�E�����ɉ�荞�܂ꂽ�I�I");
				}
				break;
			default:
				
				
			}
			
			try {
	            Thread.sleep(2 * 1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        
	        }
			
			
			if(ryuuohHp <= 0){
				System.out.println("���߂łƂ��I�I������|���܂����I�I");
			}else{
			
			int ryuMove = (int)(Math.random()*2);
			switch(ryuMove){
			case 0:
				int rI = (int)(Math.random()*19) + 1;
				System.out.println("�����̍U���I");
				System.out.println("�E�҂�" + rI + "�̃_���[�W");
				yuusyaHp -= rI;
				rI = 0;
				break;
			case 1:
				System.out.println("�����͉���f�����I");
				System.out.println("�E�҂�25�̃_���[�W");
				yuusyaHp -= 25;
				break;
			case 2:
				System.out.println("������S�̈ꌂ�I");
				System.out.println("�E�҂�30�̃_���[�W");
				yuusyaHp -= 30;
				break;
			default:
			
			}
			
			if(yuusyaHp <= 0){
				yuusyaHp = 0;
				System.out.println("�c��E��HP" + yuusyaHp);
				System.out.println("�Q�[���I�[�o�[�E�E�E");
			}else{
			System.out.println("�c��E��HP" + yuusyaHp);
			}
		
		}	
		}
		

	}
}
