package baseball;

public class Pitcher extends Sportsman {
	//�s�b�`���[�ł̑��������̕ϐ�
	private int win;

	//�I�[�o�[���C�h�p�̃s�b�`���[�̏Љ
	@Override
	public void introduction() {
		System.out.println(getName() + "(" + getCategoryName() + ")�@������" + win + "��");
	}

	//�T�u�̃R���X�g���N�^�[
	public Pitcher(String name, int category, int win) {
		//�����ŃX�[�p�[�N���X�̃R���X�g���N�^�[���Ăяo���̂ŃX�[�p�[�N���X�ɓ��������̃R���X�g���N�^�[���K�v
		super(name, category);
		//��������ϐ��ɑ��
		this.win = win;
	}

}
