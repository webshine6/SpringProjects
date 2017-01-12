package bg.jwd.uni.services;

import java.util.List;

import bg.jwd.uni.enities.Student;

public interface StudentService {

	boolean addStudent(Student student);

	List<Student> getStudents();

}
