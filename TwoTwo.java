package warmup;

/**
 * Given an array of ints, return true if every 2 that appears in the array is
 * next to another 2.
 *
 * twoTwo([4, 2, 2, 3]) → true twoTwo([2, 2, 4, 2]) → false
 *
 * @author Ramona
 */
public class TwoTwo {
    
    public static boolean twoTwo(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 2) {
               continue;
            }
            if (!(i+1 < nums.length && nums[i+1]==2) 
                    && 
                    !(i>=1 && nums[i-1] == 2)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 4, 2};
        boolean result = twoTwo(arr);

        System.out.println(result);
    }
}
