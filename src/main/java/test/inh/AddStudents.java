package test.inh;

import infra.DAO;
import models.test.inh.SpecialStudent;
import models.test.inh.Student;

public class AddStudents {

	public static void main(String[] args) {
		DAO<Student> dao = new DAO<>(Student.class);

		Student student = new Student(
				1223, "João");
		
		dao.store(student).store(new SpecialStudent(2222, "Clara", "TEA"));
	}

}
