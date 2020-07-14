package java8.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import java8.objects.Student;

public class ComparatorTest {

	@Test
	public void testComparator() {

		List<Student> list = new ArrayList<>();
		list.add(new Student(34, "kiran", "manam"));
		list.add(new Student(34, "priya", "manam"));
		list.add(new Student(34, "priya", "banu"));
		list.add(new Student(2, "vihaan", "manam"));
		Comparator<Student> studentComparator = Comparator.comparator(Student::getAge)
														  .thenComparingWith(Student::getFirstName)
														  .thenComparingWith(Student::getLastName);
		list.sort(studentComparator);
		list.forEach(System.out::println);

	}

}
