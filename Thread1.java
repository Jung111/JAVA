
//
//public class Thread1 {
//	public static void main(String[] args) {
//		Thread th1 = new Thread();
//		th1.start();
//	}
//	
//	
//}
//class thread1 extends Thread{
//	public void run() {
//		for (int i = 0; i < 300; i++) {
//			System.out.println('-');
//		}
//	}
//}
//class thread0 implements Runnable{
//	public void run() {
//		for (int i = 0; i < 300; i++) {
//			System.out.println(Thread.currentThread());
//		}
//	}
//}
//
//class Threadd{
//	public static void main(String[] args) {
//		Threadd tdd = new Threadd();
//
//		
//		 for (int i = 0; i < 10; i++) 
//			System.out.println(i);
//		
//	}
//}
//class Threadd1 extends Threadd{
//	public void run() {
//		for (int i = 0; i < 10; i++) {
//			System.out.println(i);
//		}
//	}
//}



class Thread1{
	static boolean stopped = false;
		
	public static void main(String[] args) {
		
		Thread5 th1 = new Thread5();
		
		th1.start();
		try {
			Thread.sleep(6000);
		} catch (Exception e) {
			
			
		}
		stopped = true;
		System.out.println("멈춰");
	}
}
 class Thread5 extends Thread{
	 public void run() {
		 for (int i = 0; !Thread1.stopped; i++) {
			 System.out.println(i);
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				
			}
		}
	 }
 }




