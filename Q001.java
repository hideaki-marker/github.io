package WebPrac;


import java.util.ArrayList;
import java.util.stream.Stream;

public class Q001 {
	
	    public static void main(String[] args) {
	        //ArrayListインスタンスを生成します。
	    	ArrayList<String> al = new ArrayList<>();
	        //4つの要素を追加。addメソッドを使用します。
	    	al.add("りんご");
	    	al.add("みかん");
	    	al.add("バナナ");
	    	al.add("ぶどう");

	        //拡張for文で各要素を表示します。
	    	for(String s : al) {
	    		System.out.println(s);
	    	}
	    	Stream str = al.stream();
	    	str.forEach(System.out::println);
	    }
	}


