package chap06;

public class Sample99 {

	public static void main(String[] args) {
		//try,catch,finally で例外処理を行う
		try{

		}catch(Exception e){

		}finally{

		}
		//try,catch で例外処理を行う
		try{

		}catch(Exception e){

		}
		//try,finally で例外処理を行う
		try{

		}finally{

		}
		//catch,finally で例外処理を行うNG
		catch(Exception e){

		}finally{

		}

		finally で例外処理を行うNG

		}finally{

		}
	}
	void a(){
		//finally で例外処理を行うNG
		catch(Exception e){

		}
	}

}
