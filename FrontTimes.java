package warmup;

/**
 * Given a string and a non-negative int n, we'll say that the front of the
 * string is the first 3 chars, or whatever is there if the string is less than
 * length 3. Return n copies of the front;
 *
 * @author Ramona
 */
public class FrontTimes {

    public static String frontTimes(String str, int n) {
        String resultTimes = "";
        String front = "";

        if (str.length() > 3) {
            front = str.substring(0, 3);
        } else {
            front = str;
        }

        for (int i = 0; i < n; i++) {
            resultTimes += front;
        }
        return resultTimes;
    }

    public static void main(String[] args) {
        String result = frontTimes("Ab", 3);
        System.out.println(result);
    }
}
