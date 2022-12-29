// 클래스명 은 자유 ->객체화 1->string 이름 이름출력
//			            2->string 이름  int 나이 (이름과 나이출력)
//			            3->		(이름 또는 나이를 입력해주세요 )

/* 
 * */

public class Class {

//string, age,  맴버변수 란 클래스 안에 메소드 쓰기전 공간에 있는 변수 
	
public void abc() {// 메소드 안에서 맴버변수를 쓰고 싶을때 this.맴버변수명
		System.out.println("abc");
		// 로컬변수 란 메소드 안에서 쓰는 변수 , 지역변수라고함
	}

	public static void main(String[] args) {
		Class c1 = new Class();
		c1.abc();

	}

}