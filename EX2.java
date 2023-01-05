
import java.util.Scanner;

public class EX2 {
	public static void main(String[] args) {
// 두개의 주사위 의 합이 6이 되는 경우의 수 구하기
//		System.out.println("1~5 숫자 입력하기");
//		Scanner sc = new Scanner(System.in);
//
//		int n = sc.nextInt();
//
//		for (int i = 1; i < n; i++) {
//			if (i < 7 && n - i > 7) {
//
//			}
//			
//			System.out.print(i);
//			System.out.println(n - i);
//		}

// 1~6 사이 정수를 변수value 값에 저장 하기
//		int value = 0;
//		
//		for (int i = 1; i <=6; i++) {
//			value = (int)(Math.random() *6) +1;
//			System.out.println("변수 값 : "+ value);
//		}
//		

// 방정식 2x+4y=10 의 모든 해를 구하시오 x,y는 정수 범위는 0<=x<=10 , 0<=y<=10 이다 
//	 
//		for (int l = 0; l <= 10; l++) {
//			for (int i = 0; i <= 10; i++) {
//				int n = 2 * l + 4 *i ;
//				if (n == 10) {
//					System.out.println("x ,y 값은? " + i +","+ l);
//				}
//			}
//		}

//피보나치 수열  시작의 첫 두 숫자를 1,1 로 한다 
		int num1 = 1;
		int num2 = 1;
		int num3 = 0;
		
		for (int i = 0; i <10; i++) {
			System.out.print(num1 +",");
			num1 = num2+num3;
			num3 = num2;
			num2 = num1;
			
		
		}

	}
}
