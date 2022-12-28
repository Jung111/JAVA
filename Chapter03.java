import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Chapter03 {
	public static void main(String[] args) {
		int[][] arr = { { 5, 5, 5, 5, 5 }, { 10, 10, 10 }, { 20, 20, 20, 20 }, { 30, 30 }

		};
		System.out.println("arr[3] 길이 : " + arr[3].length); // 2
		System.out.println("----------------------------------------------------------");
// arr1 에 값을 담아 합계구하기
		int[] arr1 = { 10, 20, 30, 40, 50 };
		int sum = 0;

		for (int i = 0; i < arr1.length; i++) {
			sum += arr1[i];
		}
		System.out.println("합 : " + sum); // 150
		System.out.println("----------------------------------------------------------");
// arr2 값을 넣어 합계, 평균 구하기		
		int total = 0;
		float average = 0;
		int[][] arr2 = { { 5, 5, 5, 5, 5 }, { 10, 10, 10, 10, 10 }, { 20, 20, 20, 20, 20 }, { 30, 30, 30, 30, 30 }

		};

		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j <= arr2.length; j++) {
				total += arr2[i][j];

			}
		}
		average = total / (float) arr2.length;
		System.out.println("합계 : " + total);
		System.out.println("평균 : " + average);
		System.out.println("----------------------------------------------------------");
		
// 1~9 중에 중복되지 않는 숫자로 3자리 숫자 만들어보기
		int[] ballarr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] ball3 = new int[3];
		for (int i = 0; i < ballarr.length; i++) {
			int i1 = (int) (Math.random() * ballarr.length);
//			int j = (int) (Math.random() * ball3.length);
			int tmp = 0;

			// ballarr[i]와 ballarr[i1]을 바꾼다.
			tmp = ballarr[i];
			ballarr[i] = ballarr[i1];
			ballarr[i1] = tmp;

			// 배열 ballarr의 앞에서 3개의 수를 배열 ball3로 복사한다.
		}
		for (int i = 0; i < 3; i++) {

			ball3 = ballarr;
			System.out.print(ball3[i]);
			
		}
		System.out.println("");
		System.out.println("----------------------------------------------------------");
//단어의 글자 위치를	섞어서보여주고 원래의 단어를 맞춰보자
		String[] words = { "teieviison", "cpuomtre", "muoes", "hoepn" };
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < words.length; i++) {
			char[] question = words[i].toCharArray();

			words[0] = "television";
			words[1] = "computer";
			words[2] = "mouse";
			words[3] = "phone";
			System.out.printf("Q%d %s의 정답을 입력하세요", i + 1, new String(question));

			String tmp1 = scanner.nextLine();
			if (words[i].equals(tmp1)) {
				System.out.println("정답입니다");

			} else if (!words[i].equals(tmp1)) {
				System.out.printf("틀렸습니다, 다시 입력해주세요");
				System.out.println("");

			} else {

			}

		}

	}

}
