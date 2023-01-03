import java.util.*;
import java.util.stream.*;
import java.io.*;


public class Streams {
	public static void main(String[] args) {
		Stream<Student> studentStream = Stream.of(
				new Student("김",1, 500),
				new Student("이",3, 200),
				new Student("박",5, 400),
				new Student("최",4, 300),
				new Student("정",2, 100)
				);
		studentStream.sorted(Comparator.comparing(Student::gettotalScore)
			.thenComparing(Comparator.naturalOrder()))
			.forEach(System.out::println);
	}
}
class Student implements Comparable<Student>{
	String name;
	int ban;
	int totalScore;
	Student(String name,int ban,int totalSocre){
		this.name = name;
		this.ban = ban;
		this.totalScore = totalSocre;
	}
	public String toString() {
		return String.format("[%s,%d,%d]", name,ban,totalScore);
	}
	String getname() {
		return name;
		}
	int getban() {
		return ban;
	}
	
	int gettotalScore() {
		return totalScore;
	}
	public int compareTo(Student s) {
		return s.totalScore - this.totalScore;
	}
	
}
class Streams1{
	public static void main(String[] args) {
		File[] fileArr = {new File("ex1.java"), new File("ex1.bak"),
				new java.io.File("ex2.java"),new File("ex1"),new File("ex1.txt")};
		Stream<File> fileStream = Stream.of(fileArr);
		Stream<String> filnameStream = fileStream.map(File::getName);
		filnameStream.forEach(System.out::println);
		
		fileStream = Stream.of(fileArr);
		
		fileStream.map(File::getName)
		.filter(s -> s.indexOf('.')!=-1)
		.map(s -> s.substring(s.indexOf('.')+1))
		.map(String::toUpperCase)
		.distinct()
		.forEach(System.out::print);
		
		System.out.println();
		
	}
}

