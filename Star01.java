// 별짓기  <정사각형>
public class Star01 {
	public static void main(String[] args) {
//		for(int i = 0 ; i  < 6; i++) {
//			for(int j = 0; j < 6; j++) {
//				if(i == 0 || i == 5) {
//					System.out.print("*");
//				} else {
//					if(j == 0 || j == 5) {
//						System.out.print("*");
//					} else {
//						System.out.print(" ");
//					}
//					
//				}
//				
//				
//			}
//			System.out.println(" ");
//			
//			"★" + "(i:" + i + ",j:" + j + ")\t"
//		}
//	}"☆" + "(i:" + i + ",j:" + j + ")\t"
//}

				
		// 별로 별만들기

		for (int i = 1; i < 2; i++) {
			for (int j = 1; j <= 4; j++) {
				if (i == 1 && j == 3) {
					System.out.print("★");
				} else {
					System.out.print("☆");
				}
				System.out.println();
			}

		}
	}
}
