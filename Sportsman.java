package baseball;

public abstract class  Sportsman {
	private String name;
	private int category1;
	private int category2;
	private int point;
	private static int totalPoint;
	private static final String[] CATEGORY_NAME = {"Pitcher","Batter"}; 
	
	public void setPoint(int point) {
		this.point = point;
		totalPoint += point;
	}
	
	abstract void introduction() ;
	
	public String getName() {
		return name;
	}
	
	public Sportsman(String name,int category) {
		this.name = name;
		switch(category){
		case 1:
			this.category1 = category;
			break;
		case 2:
			this.category2 = category;
			break;
			default:
				System.out.println( "カテゴリーは不明です。」");
				
	}
		
	}

	public static Sportsman getInstance(String name, int category) {
		Sportsman sp = null;
		System.out.print("///" + name + "さんが登録しました。");
		switch(category){
			case 1:
				System.out.println( "カテゴリーは" + CATEGORY_NAME[0] + "です。///");
				sp = new Pitcher(name,category);
				break;
			case 2:
				System.out.println( "カテゴリーは" + CATEGORY_NAME[1] + "です。///");
				sp = new Batter(name,category);
				break;
				default:
					System.out.println( "カテゴリーは不明です。」");
					
		}
		return sp;
		
	}
	
}
