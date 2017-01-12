package main.client;

import main.businessobject.StudentBO;
import main.transferobject.StudentTO;

public class Client {

    public static void main(String[] args) {

        StudentBO studentBO = new StudentBO();

        // print all students
        for (StudentTO student : studentBO.getStudents()) {
            System.out.println("name: " + student.getName());
            System.out.println("roll num: " + student.getRollNum());
        }

        System.out.println("----------------------------------------");

        // update student
        StudentTO studentTO = studentBO.getStudent(0);
        studentTO.setName("Michel");
        studentBO.updateStudent(studentTO);

        System.out.println("----------------------------------------");
        
        // get student
        studentTO = studentBO.getStudent(0);
        System.out.println("Student [Roll num: " + studentTO.getRollNum()
                + ", name: " + studentTO.getName() + "]");

    }
}
