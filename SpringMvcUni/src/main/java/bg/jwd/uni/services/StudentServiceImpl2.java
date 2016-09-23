package bg.jwd.uni.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import bg.jwd.uni.enities.Student;

@Service("newImpl")
public class StudentServiceImpl2 implements StudentService {

	@Override
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<Student>();

		Student student = new Student();
		student.setFacultyNo("faculty No test impl2");
		student.setName("name test impl2");

		students.add(student);

		return students;
	}

}
