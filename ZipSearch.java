package chap07;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ZipSearch {
	static String yuubin;

	public static void main(String[] args) throws FileNotFoundException, IOException {

		try (Scanner bf = new Scanner(System.in)) {//���ׁ͂̈AScanner�̃I�[�v��

			do {
				System.out.println("�u�X�֔ԍ�����͂��Ă�������(q�ŏI��)�@�F�v");
				yuubin = bf.next();//�X�֔ԍ��̓���
				if (yuubin.equals("q")) {//q�����͂��ꂽ�ꍇ�A�I��
					System.out.println("�I�����܂��B");
				} else if (!yuubin.equals("q")) {//q�ȊO�̓���
					adress();

				}
			} while (!yuubin.equals("q"));
		} catch (Exception e) {
			System.out.println("�G���[���������܂����B");
		}
		//adress();

	}

	static void adress() throws IOException {//�Z���̌Ăяo�����\�b�h
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream("01HOKKAI.CSV"), "MS932"))) {

			String rec = "";//�t�@�C���̓ǂݍ��ݗp�ϐ�

			while ((rec = br.readLine()) != null) {//�t�@�C���̓ǂݍ���
				rec = rec.replace("\"", "");//�_�u���N�H�[�e�[�V�����̎�O��
				String[] str = rec.split(",");//�J���}�ŋ�؂�A�z��֑��
				String y_no = str[2];//�t�@�C������X�֔ԍ������o���ĕϐ��ɑ��
				if (yuubin.equals(y_no)) {//���͂��ꂽ�ԍ��ƍ��v�����ꍇ
					System.out.println("��" + y_no + str[6] + str[7] + str[8] + " ");

				} else {//������ꍇ
					int next = Integer.parseInt(yuubin);//int�^�ɕϊ����A1������String�^�ɖ߂�
					next += 1;
					yuubin = String.valueOf(next);

					System.out.println(0 + yuubin);
					if (yuubin.equals(y_no)) {//1�������ԍ��ƍ��v����ԍ����������Ȃ�\��
						System.out.println("��" + y_no + str[6] + str[7] + str[8] + " ");
					} else {//������΁E�E�E
						System.out.println("�Y���Ȃ�");
					}

				}

			}

		}
	}

}
