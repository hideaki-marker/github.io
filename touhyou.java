package baseball;

public class touhyou {

	public static void main(String[] args) {
		//�I��̃I�u�W�F�N�g�̍쐬
		Sportsman[] sports = {
				Sportsman.getInstance("���c", 1, 15),
				Sportsman.getInstance("�R��", 2, 0.334),
				Sportsman.getInstance("����", 2, 0.313),
				Sportsman.getInstance("��{", 1, 11)

		};
		//���[��10��s��
		for (int i = 1; i <= 10; i++) {
			System.out.println(i + "���");
			//4�l���̕[���̕\��
			for (int j = 0; j < sports.length; j++) {
				sports[j].setPoint((int) (Math.random() * 51));
			}
			System.out.println();
			System.out.println("--------------------------");
			System.out.println();
		}
		//�S�����̑����[���̕\��
		System.out.println("�����[����" + Sportsman.getTotalPoint() + "�[�ł����B");

		//��ԕ[�����������l�����߂郍�W�b�N
		int maxp = 0;
		int m = 0;
		for (int i = 0; i < sports.length; i++) {
			if (m < sports[i].getPoint()) {
				m = sports[i].getPoint();
				maxp = i;
			}

		}
		//��ԕ[�����������l�̕\��
		System.out.println("�D����");
		sports[maxp].introduction();
	}

}
