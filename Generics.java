import java.util.ArrayList;

class Product {
}

class Tv extends Product {
}

class Audio extends Product {
}

public class Generics {
	public static void main(String[] args) {
		ArrayList<Product> productList = new ArrayList<Product>();
		ArrayList<Tv> TvList = new ArrayList<Tv>();

		productList.add(new Tv());
		productList.add(new Audio());

		TvList.add(new Tv());
	
		PrintAll(productList);

	}
	private static void PrintAll(ArrayList<Product> productList) {
		for (Product product : productList) {
			System.out.println(product);
		}
		
	}
	

}

class gugu {
	public static void main(String[] args) {
		
		Thread t = new Thread();
		t.start();
		for (int i = 0; i < args.length; i++) {
					
		}
	
	}
	
}

class gogo extends Thread{
	public void run() {
		
	}
}