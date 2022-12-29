import java.util.Arrays;

public class Thanos {
	public int[] human() {//사람 만들기
		return new int[] {2, 3, 1, 6, 5, 7, 8};//7
	}
	
	public void fingerSnap(int[] arrInt) {
		//삼항연산자 (조건식) ? 참일때 값 : 거짓일때 값;
		//int survival = (arrInt.length % 2 == 0) ? arrInt.length 
		// 2 : (int)(arrInt.length / 2 + (Math.random() * 2));
		int survival = 0;
		if(arrInt.length % 2 == 0) {
			survival = arrInt.length / 2;//3
		}else {
			survival = arrInt.length / 2 + (int)(Math.random() * 2);//3, 4
		}
		//System.out.println(survival);
		int[] result = new int[survival];//살아남은 사람의 배열
		for (int i = 0; i < result.length; i++) {
			int temp = (int)(Math.random() * arrInt.length);//0~6
			//System.out.println(temp);
			if(arrInt[temp] != 0) {				
				result[i] = arrInt[temp];
				arrInt[temp] = 0;
			} else {
				i--;
			}
		}
		System.out.println(Arrays.toString(result));
	}
	
	public static void main(String[] args) {
		Thanos thanos = new Thanos();
		thanos.fingerSnap(thanos.human());
	}
}
