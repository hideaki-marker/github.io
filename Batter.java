package baseball;

public class Batter extends Sportsman {
	//�o�b�^�[�ł̑ŗ��̕ϐ�
	private double avg;

	//�I�[�o�[���C�h���ăo�b�^�[�̏Љ�̕\��
	public void introduction() {
		//�ŗ���ϊ����郍�W�b�N
		int wri = (int) (this.avg * 10);
		int bu = (int) (this.avg * 100) - (wri * 10);
		int rin = (int) (this.avg * 1000) - (wri * 100) - (bu * 10);
		System.out.println(getName() + "(" + getCategoryName() + ") �ŗ��F"
				+ wri + "��" + bu + "��" + rin + "��");
	}

	//�T�u�̃R���X�g���N�^�[
	public Batter(String name, int category, double avg) {
		//�����ŃX�[�p�[�N���X�̃R���X�g���N�^�[���Ăяo���̂ŃX�[�p�[�N���X�ɓ��������̃R���X�g���N�^�[���K�v
		super(name, category);
		//�ŗ���ϐ��ɑ��
		this.avg = avg;

	}

}
