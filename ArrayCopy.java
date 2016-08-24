package warmup;

/**
 *
 * @author Ramona
 */
public class ArrayCopy {

    public static void ArrayCopy(String word, int srcPos, int srcDes, int lenght) {
        char[] letters = word.toCharArray();
        char[] copyTo = new char[lenght];

        System.arraycopy(letters, srcPos, copyTo, srcDes, lenght);

        System.out.println(new String(copyTo));

    }

    public static void main(String[] args) {
        String word = "decaffeinated";
        ArrayCopy(word, 2, 0, 7);

    }
}
