import java.io.PrintStream;
import java.util.Scanner;

public class Chapter01 {
	public static void main(String[] args) {
		System.out.println("1" + "2");
		System.out.println(true + "");
		System.out.println('a' + 'b');
		System.out.println('1' + 2);
		System.out.println('j' + "ava");
//		System.out.println(true + null);

		int x = 1;
		int y = 2;
		int z = 3;

		int tmp;
		int tmp1;
		tmp = x;
		x = y;
		y = tmp;

		tmp1 = y;
		y = z;
		z = tmp1;

		System.out.println("x=" + x);
		System.out.println("y=" + y);
		System.out.println("z=" + z);

		double d = 85.4;
		int score = (int) d;
		System.out.println("score =" + score);
		System.out.println("d = " + d);

		int x1 = 2;
		int y1 = 5;
		char c = 'A';
		System.out.println(y1 >= 5 || x1 < 0 && x1 > 2);
		System.out.println(y1 += 10 - x1++);
		System.out.println(!('A' <= c && c <= 'z'));

		// 456 이라면 400이 되고 111 이라면 100이 된다 ,나눗셈연산자는 반올림을 하지 않고 버림을 한다.
		int num = 456;
		System.out.println(num / 100);
		int num1 = 111;
		System.out.println(num1 / 100 * 100);

		// 과일바구니
		int numofApples = 120;
		int sizeofBucket = 10;
		int numofBucket = (numofApples / 10 + 1);
		System.out.println(numofBucket);

		// 양수 음수 0을 출력하는 코드, 삼항연산자 담을값 = 조건 ? 참 : 거짓
		int num2 = 10;
		System.out.println(((num == 0) ? 0 : ((num > 0) ? "양수" : "음수")));
		
		
		
		int fahrenheit = 100;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("수를 입력하새요");
		
		int f =scanner.nextInt();
		double c1 = (int)((5.0/9*(f-32))*10+0.50)/10.0;
		
			System.out.println("섭씌온도 : " + c1);
	}
}
