package warmup.datastructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 *
 * @author Ramona
 */
public class ArrayListUnionIntersect {

    public static ArrayList<Integer> union(ArrayList<Integer> firstList,
            ArrayList<Integer> secondList) {

        ArrayList<Integer> union = new ArrayList<>();

        union.addAll(firstList);

        for (Integer number : secondList) {
            if (!union.contains(number)) {
                union.add(number);
            }
        }

        return union;
    }

    public static ArrayList<Integer> intersect(ArrayList<Integer> firstList,
            ArrayList<Integer> secondList) {

        ArrayList<Integer> intersect = new ArrayList<Integer>();

        for (Integer item : firstList) {
            if (secondList.contains(item)) {
                intersect.add(item);
            }
        }
        return intersect;

    }

    public static void printList(ArrayList<Integer> list) {
        System.out.print("{");

        for (Integer item : list) {
            System.out.print(item);
            System.out.print(" ");
        }

        System.out.println("}");
    }

    public static void main(String[] args) {
        ArrayList<Integer> firstList = new ArrayList<Integer>();

        firstList.add(265);
        firstList.add(170);
        firstList.add(23);
        firstList.add(29);

        printList(firstList);

        ArrayList<Integer> secondList = new ArrayList<Integer>();

        secondList.add(11);
        secondList.add(170);
        secondList.add(23);
        secondList.add(8);

        printList(secondList);

        System.out.print("Union: ");
        ArrayList<Integer> union = union(firstList, secondList);
        printList(union);
        
        System.out.print("Intersect: ");
        ArrayList<Integer> intersect = intersect(firstList, secondList);
        printList(intersect);

    }

}
