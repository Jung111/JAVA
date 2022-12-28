import java.util.Iterator;
import java.util.Scanner;

public class Chapter02 {
	public static void main(String[] args) {
		int x = 0;
		System.out.printf("x=%d 일때 ,참 인것은 %n ", x);
		if (x != 0) {
			System.out.println("x!=0");
		}
		if (!(x != 0)) {
			System.out.println("!(x != 0)");
		}

		System.out.println("이름이 무엇입니까?");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();

		if (input == 0) {
			System.out.println("반갑습니다 zero 님?");

		} else {
			System.out.println("누구십니까?");
		}

		System.out.println("현재 계절은 무엇입니까?");
		int year = sc.nextInt();
		switch (year) {
		case 11:
		case 12:
		case 1:
		case 2:
			System.out.println("현재의 겨울입니다 ");
			break;
		case 3:
		case 4:
		case 5:
			System.out.println("현재의 봄입니다 ");
			break;

		default:
			break;
		}
		System.out.println("----------------------------------------------------------");

		int num = 0;
		for (int i = 0; i <= 5; i++) {
			num = (int) (Math.random() * 10) + 1;
			System.out.println(num);
		}
		System.out.println("----------------------------------------------------------");

		int sum = 0;
		int i = 0;
		while (sum <= 100) {
			System.out.printf("%d - %d%n", i, sum);
			sum += ++i;
		}
		System.out.println("----------------------------------------------------------");
// 2,3 의 배수를 제외한 20까지의 총 합 얼마?
		int x1 = 0;
		for (int j = 0; j <= 20; j++) {
			if (j % 2 != 0 && j % 3 != 0) {
				x1 = x1 + j;

			}

		}
		System.out.println("배수 제외한 총 합 : " + x1);
		System.out.println("----------------------------------------------------------");

// 1+(1+2)+(1+2+3)+(1+2+3+4)+....+(1+2+.....+10) 결과값은?
		int value = 0;
		int number = 0;
		for (int j = 0; j <= 10; j++) {
			value = value + j;
			number = number + value;

		}
		System.out.println("결과값 : " + number);
		System.out.println("----------------------------------------------------------");

//1+(-2)+3+(-4)+......계속 더해나갔을떄 몇까지 더해야 총합이 100이상 이될까?

		int s = 0;
		int t = 0;
		while (true) {
			t++;
			if (t % 2 == 0) {
				s -= t;
			} else {
				s += t;

			}
			if (s >= 100) {
				break;
			}
		}
		System.out.println("합계 : " + t);
		System.out.println("----------------------------------------------------------");

//다음의 for문을 while문으로 변경하시오

		/*
		 * 
		 * for (int j = 0; j <=10; j++) { for (int j2 = 0; j2 < j; j2++) {
		 * System.out.println("*"); System.out.println();
		 * 
		 * }
		 * 
		 * }
		 */

		int j = 0;
		int j2 = 0;
		while (j <= 10) {

			System.out.printf("*");
			System.out.println();
			j += ++j;
			if (j == 10) {
				break;
			}

		}
		System.out.println("----------------------------------------------------------");

//두개 주사위 의 합이 6이 되는 모든 경우 의 수를 출력하시오
		for (int j0 = 1; j <= 6; j++) {
			for (int j1 = 1; j1 <= 6; j1++) {
				if (j + j1 == 6) {
					System.out.println(j + " " + j1);
				}
			}
		}
		System.out.println("----------------------------------------------------------");
// 문자열 12345 라면 1+2+3+4+5 의 결과 15를 출력이 되어야한다  

		String str = "12349";
		int sum2 = (int)1+ (int)2 + (int)3 +(int)4 +(int)5;
		
		
		for (int k = 0; k >= 5; k++) {
			sum2 += k;
		}
		System.out.println("sum2 = " + sum2);
		System.out.println("----------------------------------------------------------");
// math.random()을 이용해 1~6 사이 임의정수를 value 저장하는코드 완성하기
		int val = 0;
		for (int k = 0; k <= 6; k++) {
			val = (int) (Math.random() * 6) +1; 
			}
		System.out.println("val =" + val);
		System.out.println("----------------------------------------------------------");

// 숫자맞추기 게임 1~100 사이 값 반복 , 컴퓨터와대결 몇번만에 숫자를 맞추는지 알려주기
		int answer = 10;
		int input1 = 0;
		int count = 0;
		Scanner scanner = new Scanner(System.in);
		do {
			count++;
			System.out.println("1 ~10 사이 값을 입력하기");
			input1 = scanner.nextInt();
			if (input1 > answer) {
				System.out.println("떙!틀렸어 again");
			} else if (input1 < answer) {
				System.out.println("못맞췄찌롱~~");
			}else {
				count += count++;
				System.out.println("시도한 횟수 : "+ count);
			}
		} while (input1 != answer);
		System.out.println("맞췄군 쮀..");

	}

}