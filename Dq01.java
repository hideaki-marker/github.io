package practis;

import java.util.Scanner;

public class Dq01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int yuusyaHp = 100;
		int mp = 3;
		int yakusou = 10;
		int ryuuohHp = 140;
		System.out.println("竜王が現れた！！");
		
		try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
		
		
		while(ryuuohHp > 0 && yuusyaHp > 0){
			
			System.out.println("行動を選択してください");
			System.out.print("[1]戦う、[2]魔法、[3]道具、[4]逃げる：");
			int move = scanner.nextInt();
			
			while(move >= 5){
				System.out.print("選択をえらびなおして下さい：");
				move = scanner.nextInt();
			}
			switch(move){
			case 1:
				int i = (int)(Math.random()*10) + 1;
				System.out.println("勇者の攻撃！");
				System.out.println("竜王に" + i + "のダメージを与えた");
				ryuuohHp -= i;
				i = 0;
				break;
			case 2:
				if(mp >= 1){
					System.out.println("勇者はメラを唱えた");
					System.out.println("竜王に20のダメージを与えた");
					--mp;
					System.out.println("残り" + mp + "回");
					ryuuohHp -= 20;
					break;
				}else{
					System.out.println("MPが足りません");
					continue;
				}
				
				
			case 3:
				if(yakusou >= 1){
				System.out.println("勇者は薬草を使った");
				System.out.println("勇者のHPが30回復した");
				yuusyaHp += 30;
				--yakusou;
				System.out.println("残り薬草" + yakusou + "個");
				if(yuusyaHp >= 101){
					yuusyaHp = 100;
				}
				break;
				}else{
					System.out.println("薬草はもう無い・・・");
					continue;
				}
			case 4:
				int k = (int)(Math.random()*30) + 1;
				System.out.println("勇者は逃げ出した！");
				if(k <= 5){
					System.out.println("勇者は無事に逃げることが出来た");
					System.out.println("しかし、世界は竜王に支配されてしまった・・・");
					System.out.println("ゲームオーバー・・・");
					yuusyaHp = 0;
					continue;
				}else{
					System.out.println("残念・・・竜王に回り込まれた！！");
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
				System.out.println("おめでとう！！竜王を倒しました！！");
			}else{
			
			int ryuMove = (int)(Math.random()*2);
			switch(ryuMove){
			case 0:
				int rI = (int)(Math.random()*19) + 1;
				System.out.println("竜王の攻撃！");
				System.out.println("勇者に" + rI + "のダメージ");
				yuusyaHp -= rI;
				rI = 0;
				break;
			case 1:
				System.out.println("竜王は炎を吐いた！");
				System.out.println("勇者に25のダメージ");
				yuusyaHp -= 25;
				break;
			case 2:
				System.out.println("竜王会心の一撃！");
				System.out.println("勇者に30のダメージ");
				yuusyaHp -= 30;
				break;
			default:
			
			}
			
			if(yuusyaHp <= 0){
				yuusyaHp = 0;
				System.out.println("残り勇者HP" + yuusyaHp);
				System.out.println("ゲームオーバー・・・");
			}else{
			System.out.println("残り勇者HP" + yuusyaHp);
			}
		
		}	
		}
		

	}
}
