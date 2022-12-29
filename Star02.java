// 1 번 " 꽉찬 정사각형   2번 직각삼각형 정방향 ,밑방향 -> 반대방향

public class Star02 {
	public static void main(String[] args) {
		// 토르 몰뢰르 다이아몬드부수기
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print("*");
			}
			for (int j1 = 0; j1 >= i + 1; j1++) {
				System.out.print("*");

			}
		}
		for (int i = 3; i < 9; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		// ↓ 꽉찬정사각형
		/*
		 * for (int i = 0; i < 13; i++) { for (int j = 0; j < 13; j++) {
		 * System.out.print("*");
		 * 
		 * } System.out.println(); }
		 */
		
		System.out.println(" ");
		// ↓ 직각삼각형
			
		for (int i2 = 0; i2 < 5; i2++) { // i2 = 0 1 2 <-그래서
			for (int j2 = 0; j2 <= i2; j2++) {// j2 = 0 1, 0,1,2 0,1,2,3 j2 = i2
				System.out.print("*");
			}
			System.out.println();
		}
		// ↓ 밑방향 직각삼각형
		for (int i3 = 0; i3 < 5; i3++) { // i3 = 5 4
			for (int j3 = 5; j3 > i3; j3--) { // j3 = 0,1,2,3 0,1,2
				System.out.print("*");
			}
			System.out.println();
		}

		// ↓ 반대 방향 윗직각삼각형
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4 - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 1 + i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		// ↓ 반대 방향 아래직각삼각형
		for (int i = 0; i < 5; i++) {
			for (int j = 5; j > 5 - i; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j < 5 - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		// 위에는 다이아몬드 밑에는 직사각형기둥 = 촛불모양 만들기

	}// main
}
