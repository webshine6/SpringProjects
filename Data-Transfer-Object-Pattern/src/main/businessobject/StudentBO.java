package main.businessobject;

import main.transferobject.StudentTO;

import java.util.ArrayList;

public class StudentBO {

    private ArrayList<StudentTO> students;

    public StudentBO() {
        this.students = new ArrayList<StudentTO>();
        students.add(new StudentTO("Pesho", 0));
        students.add(new StudentTO("Hristo", 1));
    }

    public StudentTO getStudent(int rollNum) {
        return students.get(rollNum);
    }

    public ArrayList<StudentTO> getStudents() {
        return students;
    }

    public void deleteStudent(StudentTO student) {
        students.remove(student.getRollNum());
    }

    public void updateStudent(StudentTO student) {
        students.get(student.getRollNum()).setName(student.getName());
        System.out.println("Student rollnum " + student.getRollNum() +
                " updated successful in DB.");
    }


}
