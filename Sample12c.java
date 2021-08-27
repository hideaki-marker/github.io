package chap12;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class Sample12c {
	public static void main(String[] args) throws IOException {
		Path source = Paths.get("file13Copy.txt");
		System.out.println("■ループを使い1 行ずつ読み込んで表示");
		// Files クラスのnewBufferedReader()メソッドでBusseredReader オブジェクトを生成
		BufferedReader br = Files.newBufferedReader(source);
		String line;
		while ((line = br.readLine()) != null) { // 今まで通りループで読み込みながら表示
			System.out.println(line);
		}
		br.close();
		System.out.println("■全行読み込んでforEach メソッドとラムダ式で表示");
		List<String> allList = Files.readAllLines(source); // 全行一気に読み込む（List 型）
		allList.forEach(str -> System.out.println(str)); // ArrayList
															// のforEach()メソッド
		System.out.println("■全行読み込むとメモリーが心配な時、Stream を使って表示");
		Stream<String> stream = Files.lines(source); // Files クラスのlines()メソッド
		// 上記の右辺はFiles.newBufferedReader(source)でもOK
		stream.forEach(str -> {
			System.out.println(str + " " + str.length() + "文字");
		});
		stream.close();
	}
}
