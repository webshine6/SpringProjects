package warmup;

/**
 * We want make a package of goal kilos of chocolate. We have small bars (1 kilo
 * each) and big bars (5 kilos each). Return the number of small bars to use,
 * assuming we always use big bars before small bars. Return -1 if it can't be
 * done.
 *
 * @author Ramona
 */
public class МakeChocolate {

    public static int makeChocolate(int small, int big, int goal) {
        int smallBarKg = 1;
        int bigBarKg = 5;

        int smallCount = small;

        int reqKg = (goal - (big * bigBarKg));

        if (reqKg > (small * smallBarKg)) {
            smallCount = -1;
        }

        if (reqKg < (small * smallBarKg)) {
            smallCount = reqKg;
        }

        return smallCount;
    }

    public static void main(String[] args) {
        int result = makeChocolate(4, 1, 7);
        System.out.println(result);
    }
}
