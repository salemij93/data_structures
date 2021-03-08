package csc402week8examples;

import java.util.Arrays;

import stdlib.*;

public class SortStudents {

	public static void main(String[] args) {
		Student[] students = new Student[8];
		students[0] = new Student(123, "Desiato", "Hotblack");
		students[1] = new Student(528, "Nullify", "Reg");
		students[2] = new Student(52,  "Prefect", "Ford");
		students[3] = new Student(99, "Dent", "Arthur");
		students[4] = new Student(404, "Beeblebrox", "Zaphod");
		students[5] = new Student(773, "Mouse", "Frankie");
		students[6] = new Student(815, "Mouse", "Benjy");
		students[7] = new Student(224, "Thought", "Deep");
		
		Arrays.sort(students);
		StdOut.println("--- Students ordered by id number ---");
		for (Student student: students) {
			StdOut.println(student);
		}
		
		Arrays.sort(students, Student.bylastname);
		StdOut.println();
		StdOut.println("--- Students ordered by lastname ---");
		for (Student student: students) {
			StdOut.println(student);
		}
		

	}

}
