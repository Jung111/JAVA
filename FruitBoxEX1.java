import java.util.ArrayList;



class Fruit {
	public String toString() {
		return "Fruit";
	}
}

class Apple extends Fruit {
	public String toString() {
		return "Apple";
	}
}

class Grape extends Fruit {
	public String toString() {
		return "Grape";
	}
}

class Toy {
	public String toString() {
		return "Toy";
	}
}

public class FruitBoxEX1 {
	public static void main(String[] args) {
		Box<Fruit> FruitBox = new Box<Fruit>();
		Box<Apple> AppleBox = new Box<Apple>();
		Box<Toy> ToyBox = new Box<Toy>();
		Box<Grape> GrapeBox = new Box<Grape>();

		FruitBox.add(new Fruit());
		FruitBox.add(new Apple());
		FruitBox.add(new Grape());

		System.out.println(FruitBox);

	}
}

class Box<T> {
	ArrayList<T> list = new ArrayList<T>();

	void add(T item) {
		list.add(item);
	}

	T get(int i) {
		return list.get(i);
	}

	int size() {
		return list.size();
	}

	public String toString() {
		return list.toString();
	}

}







