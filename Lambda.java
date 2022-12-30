import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

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
//---------------------------------------------------------------/
		
// [] 안에 알맞은 함수인터페이스넣기

	[] f = () -> (int)(Math.random() * 100) +1;
	[] = Supplier
	
	[] f = i -> System.out.println(i + ", ");
	[] = Consumer
		
	[] f = i -> i%==0;
	[] = Predicate
			
	[] = f = i -> i/10 *10;
	[] = function
	
	
	
	}

}
