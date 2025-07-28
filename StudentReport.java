import java.util.*;

public class StudentReport {
	public static void main(String[] args) {
		Report report = new Report();
		
		report.addMark("Alankrati", 85);
		report.addMark("Alankrati", 81);
		report.addMark("Alankrati", 72);
		
		report.addMark("Harshita", 75);
		report.addMark("Harshita", 86);
		report.addMark("Harshita", 81);
		
		report.addMark("Devika", 80);
		report.addMark("Devika", 75);
		report.addMark("Devika", 87);
		
		System.out.println("--------------- All Marks -------------------");
		report.printMarks();
		
		System.out.println("--------------- Average of each Student ----------------");
		report.printAverage();
		
		System.out.println("-------------- Top Performer -----------------");
		System.out.println(report.getTopper());
	}
}

class Student{
	private String name;
	private List<Integer> marks;
	
	public Student(String name) {
		this.name = name;
		this.marks = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	
	public void addMark(int m) {
		marks.add(m);
	}
	
	public double getAverage() {
		double total = 0.0;
		for(int i : marks) {
			total += i;
		}
		
		return total/marks.size();
	}
	
	public List<Integer> getMarks(){
		return marks;
	}
}

class Report{
	Map<String, Student> map;
	
	public Report() {
		map = new HashMap<>();
	}
	
	public void addMark(String name, int mark) {
	    map.putIfAbsent(name, new Student(name));
	    map.get(name).addMark(mark);
	}

	
	public void printAverage() {
		for(Student s : map.values()) {
			System.out.println(s.getName() + "'s average is " + s.getAverage());
		}
	}
	
	public void printMarks() {
		for(Student s : map.values()) {
			System.out.println(s.getName() + "'s marks are " + s.getMarks());
		}
	}
	
	public String getTopper() {
		String topper = "";
		double max = 0.0;
		
		for(Student s : map.values()) {
			double curr = s.getAverage();
			if(max < curr) {
				max = curr;
				topper = s.getName();
			}
		}
		
		return topper;
	}
}


