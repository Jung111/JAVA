import java.util.Scanner;


public class Baskin {

   public static void main(String[] args) {
      
      Scanner sc = new Scanner(System.in);  
      // 사용자로부터 입력받는 객체 이름은 sc라고 내가 지어줬고, 
      //형태는 스캐너 형태 만든 실체(값)는 스캐너 객체
      
      int n = 0;  // 1~31까지 불리울 숫자 이름은 n 형태는 int형 초기값은 0
      int cnt = 0; // 진행 단계
      
      while (n < 30) {
         
         for (int i = n+1; i <= cnt*4+2; i++) {
     // 베스킨라빈스 게임에서 이길수 있는 룰 2 6 10 14 18 22 26 30을 먼저 말하면 이김
            System.out.println("컴퓨터 : "+i);
         }
         System.out.println("\t\t숫자와 숫자 사이는 ,를 넣어 입력해주세요.");
         n = cnt*4+2;
         
         String strValue = sc.next();                    
         // 사용자로부터 숫자 입력 받음
         String[] arrStrValue = strValue.split(",");           
         // 사용자가  입력받을 , 값으로 잘라서 스트링 배열로 리턴하는 
         //String의 split함수 사용
         
         if (arrStrValue.length > 3) { 
        	 // 사용자 입력 값 유효성 체크 
        	 //(※ 유효성에 문제가 있으면 continue로 단계 진행을 유지한다.※)
        	 
            System.err.println("숫자는 세개까지만 허용합니다.");
            continue;
         } else if (arrStrValue[0].compareTo(n+"") <= 0) {      // 컴퓨터가 마지막에 부른 숫자보다 작은 수를 말하면 경고 출력 
            System.err.println("제가 부른 숫자의 다음을 불러주세요.!!");
            continue;
         } else if (Integer.valueOf(arrStrValue[arrStrValue.length-1]) > n+3) {      // 컴퓨터가 마지막에 부른 숫자보다 작은 수를 말하면 경고 출력 
            System.err.println("숫자가 갑자기 너무 커요.... 규칙을 지켜주세요...!!");
            continue;
         }
         
         n = Integer.valueOf(arrStrValue[arrStrValue.length-1]);   // Integer 객체를 사용하여 마지막 입력받은 값을 숫자로 변환
         cnt++;                                       // 진행 단계가 올라감
      }
      System.out.println("내가 이겼지롱!!!!");
   }

}



























//import java.util.Arrays;
//
//import java.util.Scanner;
//
//public class Baskin {
//
//	public static void main(String[] args) {
//
//		// 컴퓨터가 무조건 먼저 시작하고,1P는 무조건 2번째로 말한다.
//
//		// 컴퓨터가 무조건 이기게 만들어라.
//
//
//		// 힌트2:이 게임은 31을 부르면 지는 게임이니 30을 부르면 이깁니다.
//
////		int i = 0;
//			
//		System.out.println("1,2,3");
//		
//		Scanner sc = new Scanner(System.in);
//      		
//		//String me=sc.next();
//		//boolean na=sc.nextBoolean();
//	  
//	    
//	  //jj 가 대답한 숫자 다음 숫자 말하기
//		int jj = 0;
//		while (jj>=0 && jj<=30) {
//			
//			jj=sc.nextInt();			
//			System.out.println("사용자 값 : "+jj);
//			
//			System.out.println("컴퓨터 말 : "+(jj+1));
//		} 
//		//너가 말했어 31 그니깐 니가 진거야
//			
//
//		
//		//	
//		for (int i = 0; i <= 30; i++) {
//
//		}
//
//		
//		while () {
//
//			System.out.println(" Baskin Robbins 31 ! game start ♪ ");
//
//			String str = "1,2,3";
//
//			String[] arr = str.split(",");
//
//			int number1 = Integer.parseInt(arr[0]);
//
//			System.out.println(Arrays.toString(arr));
//
//			
//		}
//
//	}
//
//}
