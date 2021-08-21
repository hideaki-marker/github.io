package baseball;

public abstract class Sportsman {
	//�K�v�ȕϐ��̐ݒ�(���O�A�J�e�S���[�A�_���Ȃ�)
	private String name;
	private int category;
	private int point;
	private static int totalPoint;
	private static final String[] CATEGORY_NAME = { "Pitcher", "Batter" };

	//�R���X�g���N�^�[�̍쐬(���ꂪ�����ƃT�u�N���X�ł̃R���X�g���N�^�[�쐬���A�Ăяo�����ł����A�G���[�ɂȂ�)
	public Sportsman(String name, int category) {
		this.name = name;
		this.category = category;
		System.out.println("///" + name + "���񂪓o�^���܂����B�J�e�S���[��" +
				getCategoryName() + "�ł��B///");
	}

	//���[���̃Z�b�g�Ƒ����[��totalPoint)�̃J�E���g�𓯎��ɍs��
	public void setPoint(int point) {
		this.point += point;
		System.out.println(getName() + "�@" + getPoint() + "�[");

		totalPoint += point;
	}

	//�l�̓��[���̃Q�b�^�[
	public int getPoint() {
		return point;
	}

	//�l�̖��O�̃Q�b�^�[
	public String getName() {
		return name;
	}

	//�s�b�`���[�A�o�b�^�[�̃Q�b�^�[
	public String getCategoryName() {
		return CATEGORY_NAME[category - 1];
	}

	//���ۃ��\�b�h�̍쐬(�T�u�N���X�I�[�o�[���C�h�p)
	abstract void introduction();//���ۃ��\�b�h
	//�����[���̃Q�b�^�[

	public static int getTotalPoint() {
		return totalPoint;
	}

	//touhyou����̃C���X�^���X���ɑ΂��ẴQ�b�g�C���X�^���X(�s�b�`���[)
	public static Sportsman getInstance(String name, int category, int win) {

		if (category != 1) {
			System.out.println("�J�e�S���[���s���ł��B�v");

		}
		return new Pitcher(name, category, win);
	}

	//touhyou����̃C���X�^���X���ɑ΂��ẴQ�b�g�C���X�^���X(�o�b�^�[)
	public static Sportsman getInstance(String name, int category, double avg) {

		if (category != 2) {
			System.out.println("�J�e�S���[���s���ł��B�v");

		}

		return new Batter(name, category, avg);
	}

}
