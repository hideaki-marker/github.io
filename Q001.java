package WebPrac;


import java.util.ArrayList;
import java.util.stream.Stream;

public class Q001 {
	
	    public static void main(String[] args) {
	        //ArrayList�C���X�^���X�𐶐����܂��B
	    	ArrayList<String> al = new ArrayList<>();
	        //4�̗v�f��ǉ��Badd���\�b�h���g�p���܂��B
	    	al.add("���");
	    	al.add("�݂���");
	    	al.add("�o�i�i");
	    	al.add("�Ԃǂ�");

	        //�g��for���Ŋe�v�f��\�����܂��B
	    	for(String s : al) {
	    		System.out.println(s);
	    	}
	    	Stream str = al.stream();
	    	str.forEach(System.out::println);
	    }
	}


