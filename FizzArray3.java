package warmup;

/**
 * Given start and end numbers, return a new array containing the sequence of
 * integers from start up to but not including end, so start=5 and end=10 yields
 * {5, 6, 7, 8, 9}. 
 * The end number will be greater or equal to the start number.
 * Note that a length-0 array is valid.
 * 
 * @author Ramona
 */
public class FizzArray3 {
    public static int[] fizzArrays(int start, int end) {
        int len = end - start;
        int[] resultArr = new int[len];
        for(int i=0; i < len; i++) {
            resultArr[i] = start++;
    
        }   
        return resultArr;
    }
    
    public static void main(String[] args) {
        int[] arr = fizzArrays(5, 8);
        for (int item : arr) {
            System.out.println(item);
        }
    }
}
