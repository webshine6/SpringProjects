package warmup.staticmembers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Ramona
 */
public class Student {

    private String name;
    private static int instances = 0;

    public Student(String name) {
        this.name = name;
        instances++;
    }

    public static void main(String[] args) {

        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

        String input = null;

        try {
            while (!(input = bReader.readLine()).equals("End")) {
                Student student = new Student(input);
            }
        } catch (IOException ioex) {
            System.out.println("I/O Exception" + ioex.getMessage());
        }

        System.out.println(Student.instances);

    }
}
