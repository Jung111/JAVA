import java.util.Arrays;
import java.util.Scanner;

public class Pingpong {
	 public static void main(String[] args) {
	      Scanner sc = new Scanner(System.in);
	      System.out.println("핑퐁 숫자 입력하세요");
	      Pingpong ping = new Pingpong();
	      int val = sc.nextInt();
	      ping.pingpong(val);
	      
	   }
	   void print(int[] num ,int val) {
	      System.out.println(num[val-1]);
	   }
	   
	   void pingpong(int val) {
	      int[] num = new int[101];
	      int count = 0;
	      int index = 0;

	      boolean a = true;
	      boolean b = true;
	      while (a) {
	         num[index++] = ++count;

	         if (index % 7 == 0 || String.valueOf(index).indexOf("7") >= 0) {
	            while (b) {
	               num[index++] = --count;
	               if (index % 7 == 0 || String.valueOf(index).indexOf("7") >= 0) {
	                  break;
	               }
	            }
	         }
	         if (index == 100) {
	            a = false;
	         }
	      }
	      Pingpong ping = new Pingpong();
	      ping.print(num, val);
	   }

}
