
public class Lambda {

	public static int main(String[] args) {
    //1.메서드 형식 
		int max (int a,int b) {
			return a>b ?a:b;
		}
	//1.람다식으로 변경
		(a,b) -> a>b ?a:b

	//2.메서드 형식
		int printVar(String name, int i) {
			System.out.println(name + "=" + i);
		}
	//2.람다식으로 변경
		(String name,int i)-> System.out.println(i)
		   
	//3.메서드 형식			
		int square(int x) {
			return X * x ;
		}
	//3.람다식으로 변경
		x -> X *x
		
	//4.메서드 형식
		int roll() {
			return(int)(Math.random()*6);
		}
	//4.람다식으로 변경
		() ->(int)(Math.random()*6)
		
	}

}
